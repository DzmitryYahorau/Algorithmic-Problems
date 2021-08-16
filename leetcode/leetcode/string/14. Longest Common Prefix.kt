package string

fun longestCommonPrefix(strs: Array<String>): String {
    val maxPrefix = strs.minBy { it.length } ?: return ""

    maxPrefix.forEachIndexed { i, c ->
        val isAllSameChar = strs.all { it[i] == maxPrefix[i] }
        if (!isAllSameChar) {
            return maxPrefix.substring(0..i)
        }
    }

    return maxPrefix
}

fun longestCommonPrefixDivideAndConquer(strs: Array<String>): String {
    if (strs.isEmpty()) {
        return ""
    }

    return if (strs.size == 1) {
        strs.first()
    } else {

        // divide
        val mid = strs.size / 2

        val firstHalf = longestCommonPrefixDivideAndConquer(strs.sliceArray(0 until mid))
        val lastHalf = longestCommonPrefixDivideAndConquer(strs.sliceArray(mid..strs.lastIndex))

        //conquer
        commonPrefix(firstHalf, lastHalf)
    }
}

fun commonPrefix(a: String, b: String): String {
    val minLength = minOf(a.length, b.length)
    var i = 0
    while (i < minLength) {
        if (a[i] != b[i]) {
            return a.substring(0 until i)
        }
        i++
    }
    return a.substring(0 until minLength)
}

fun main() {
    println(longestCommonPrefixDivideAndConquer(arrayOf("flower", "flow", "flight")))
}