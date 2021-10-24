package dynamic

import kotlin.test.assertEquals

fun uniquePaths(m: Int, n: Int): Int {
    if ((m == 1) || (n == 1)) return 1

    val dp = Array(m) { IntArray(n) }

    //we  can get to the top cells in only 1 way
    dp[0].forEachIndexed { index, _ -> dp[0][index] = 1 }

    //we can get to the right border cells in only 1 way
    dp.forEachIndexed { index, _ -> dp[index][0] = 1 }

    for (i in 1 until m) {
        for (j in 1 until n) {
            // count ways how ew can get  to current  cell:
            // (dp[i][j - 1] - from left) + (from top - dp[i - 1][j])
            dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
        }
    }

    return dp[m - 1][n - 1]
}

class SecondTry() {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array<IntArray>(m) { IntArray(n) { 0 } }

        dp[0].forEachIndexed { index, ints -> dp[0][index] = 1 }
        dp.forEachIndexed { index, ints -> dp[index][0] = 1 }

        for (i in 1 until m){
            for (j in 1 until n){
                dp[i][j] += dp[i-1][j]
                dp[i][j] += dp[i][j-1]
            }
        }

        return dp[m-1][n-1]
    }
}

fun main() {
    assertEquals(expected = 193536720, actual = uniquePaths(23, 12))
}