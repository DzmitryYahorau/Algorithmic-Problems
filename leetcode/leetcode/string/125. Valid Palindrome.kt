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

fun main() {
    assertEquals(actual = isPalindrome("A man, a plan, a canal: Panama"), expected = true, message = "1")
    assertEquals(actual = isPalindrome(".,"), expected = true, message = "2")
    assertEquals(false, isPalindrome("0P"), message = "3")
}