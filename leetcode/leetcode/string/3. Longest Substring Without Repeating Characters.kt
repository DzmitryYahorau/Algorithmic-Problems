package string

fun lengthOfLongestSubstring(s: String): Int {
    val list = mutableListOf<String>()

    var i = 0

    while (i < s.length) {
        var j = i
        val sb = StringBuilder()

        while (j in s.indices && !sb.contains(s[j])) {
            sb.append(s[j])
            j++
        }

        list.add(sb.toString())
        i++
    }

    return list.maxBy { it.length }?.length ?: 0
}


fun main() {
    val input = "abcabcbb"
    println(lengthOfLongestSubstring(input))
}