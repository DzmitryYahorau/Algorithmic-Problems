package dynamic

// similar to Fibonaci
fun numDecodings(s: String): Int {
    val dp = IntArray(s.length + 1)

    dp[0] = 1
    dp[1] = if (s[0] != '0') 1 else 0

    for (i in 2..s.length) {
        val first: Int = Integer.valueOf(s[i - 1].toString())
        val second: Int = Integer.valueOf(s.substring(i - 2 until i))
        if (first in 1..9) {
            dp[i] += dp[i - 1]
        }
        if (second in 10..26) {
            dp[i] += dp[i - 2]
        }
    }
    return dp[s.length]
}

fun main() {
    println(numDecodings("226"))
    println(numDecodings("06"))
    println(numDecodings("111111111111111111111111111111111111111111111"))
}