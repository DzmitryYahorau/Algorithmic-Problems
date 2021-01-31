package string

//brute force - O(n2)
fun shortestPalindrome(s: String): String {
    val reversed = s.reversed()

    for (i in s.indices) {
        if (s.substring(0, s.length - i) == reversed.substring(i)) {
            return reversed.substring(0, i) + s
        }
    }

    return ""
}

fun main() {
    println(shortestPalindrome(s = "abcd"))
}