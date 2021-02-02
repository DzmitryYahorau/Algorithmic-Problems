package dynamic

fun minPathSum(grid: Array<IntArray>): Int {
    if (grid.isEmpty()) {
        return 0
    }

    val rowSize = grid.size
    val columnSize = grid[0].size

    val dp = Array(rowSize) { IntArray(columnSize) }

    for (i in dp.indices) {
        for (j in dp[0].indices) {
            dp[i][j] = grid[i][j]

            when {
                // we are here from top left
                (i > 0 && j > 0) -> {
                    dp[i][j] += minOf(dp[i - 1][j], dp[i][j - 1])
                }
                // we are on top
                (j > 0) -> {
                    dp[i][j] += dp[i][j - 1]
                }
                // we are here from top
                (i > 0) -> {
                    dp[i][j] += dp[i - 1][j]
                }
            }
        }
    }

    return dp[dp.lastIndex][dp[0].lastIndex]
}

fun main() {
    val a = arrayOf(
            intArrayOf(1, 3, 1),
            intArrayOf(1, 5, 1),
            intArrayOf(4, 2, 1)
    )

    val b = arrayOf(
            intArrayOf(1,2,3),
            intArrayOf(4,5,6)
    )

//    println(minPathSum(a))
    println(minPathSum(b))
}