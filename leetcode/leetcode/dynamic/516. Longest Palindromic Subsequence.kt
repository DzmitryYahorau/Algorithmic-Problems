package dynamic

fun longestPalindromeSubseq(s: String): Int {
    val dp = Array<IntArray>(s.length + 1) { IntArray(s.length + 1) }
//    solved exactly same as with Longest common subsequence
//    second string is same strin, but reversed
    val re = s.reversed()
    for (i in s.lastIndex downTo 0) {
        for (j in s.lastIndex downTo 0) {
            if (s[i] == re[j]) {
                dp[i][j] = 1 + dp[i + 1][j + 1]
            } else {
                dp[i][j] = maxOf(dp[i][j + 1], dp[i + 1][j])
            }
        }
    }

    return dp[0][0]
}

fun main() {
    println(longestPalindromeSubseq("bbbab"))
}