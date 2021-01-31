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

fun main() {

    println(longestCommonPrefix(arrayOf("a")))
}