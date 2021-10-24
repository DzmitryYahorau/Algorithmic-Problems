package dynamic

fun longestCommonSubsequence(text1: String, text2: String): Int {
    //https://www.youtube.com/watch?v=Ua0GhsJSlWM
    // fill 2d array with 0s
    val dp = Array<IntArray>(text1.length + 1) { IntArray(text2.length + 1) }

    //going bottom-up fill the values
    for (i in text1.lastIndex downTo 0) {
        for (j in text2.lastIndex downTo 0) {
            if (text1[i] == text2[j]) {
                // if chars are same -> add 1 to diagonal value
                dp[i][j] = 1 + dp[i + 1][j + 1]
            } else {
                // if not, check max value between bottom and right
                dp[i][j] = maxOf(dp[i + 1][j], dp[i][j + 1])
            }
        }
    }
    //this value we will get last
    return dp[0][0]
}


fun main() {
    println(longestCommonSubsequence("abcde", text2 = "ace"))
    println(longestCommonSubsequence("bsbininm", text2 = "jmjkbkjkv"))
}