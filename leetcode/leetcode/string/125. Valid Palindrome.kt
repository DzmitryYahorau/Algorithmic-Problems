package string

import kotlin.test.assertEquals

fun isPalindrome(s: String): Boolean {

    var lo = 0
    var hi = s.lastIndex

    while (lo < hi) {
        while (lo in s.indices && !s[lo].isLetterOrDigit()) {
            lo++
        }

        while (hi in s.indices && !s[hi].isLetterOrDigit()) {
            hi--
        }

        if (lo !in s.indices && hi !in s.indices) return true

        if ((lo !in s.indices) || (!s[lo].equals(s[hi], ignoreCase = true))) {
            return false
        }

        lo++
        hi--
    }
    return true
}

fun isPalindromeDivAndCon(s: String): Boolean {
    return compute(s.filter { it.isLetterOrDigit() })
}

private fun compute(s: String): Boolean {
    if (s.isBlank()){
        return true
    }

    return when(s.length){
        in 0..1 -> true
        2 -> s.first() == s.last()
        else -> s.first().equals(s.last(), ignoreCase = true) && compute(s.substring(1 until s.lastIndex))
    }
}

fun main() {
    assertEquals(actual = isPalindromeDivAndCon("A man, a plan, a canal: Panama"), expected = true, message = "1")
    assertEquals(actual = isPalindromeDivAndCon(".,"), expected = true, message = "2")
    assertEquals(false, isPalindromeDivAndCon("0P"), message = "3")
}