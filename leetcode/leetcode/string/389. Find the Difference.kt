// solved in 9:50 min

fun findTheDifference(s: String, t: String): Char {
    val arr = Array<Int>(26) { 0 }

    for (i in s.indices) {
        val charIndex = s[i] - 'a'
        arr[charIndex]++
    }

    for (i in t.indices) {
        val charIndex = t[i] - 'a'
        arr[charIndex]--
        if (arr[charIndex] == -1) {
            return t[i]
        }
    }

    return ' '
}