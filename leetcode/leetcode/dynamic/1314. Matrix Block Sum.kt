package dynamic

fun matrixBlockSum(mat: Array<IntArray>, k: Int): Array<IntArray> {
    val dp = Array(mat.size + 1) { IntArray(mat.first().size + 1) }
    val answer = Array(mat.size) { IntArray(mat.first().size) }

    for (i in mat.indices) {
        dp[i][0] = mat[i][0]
    }

    for (i in mat.indices) {
        for (j in 1 until mat.first().size) {
            dp[i][j] = dp[i][j - 1] + mat[i][j]
        }
    }

    for (i in 1 until mat.size) {
        for (j in mat.first().indices) {
            dp[i][j] = dp[i - 1][j] + dp[i][j]
        }
    }

    for (i in dp.lastIndex downTo 1) {
        for (j in dp.first().lastIndex downTo 1) {

            val i1 = (i + k - 1).coerceAtMost(dp.lastIndex-1)
            val j1 = (j + k - 1).coerceAtMost(dp.first().lastIndex-1)

            val pl = dp[i1][j1]

            val hor_bound = if (j - k - 2 >= 0) dp[i1][j - k - 2] else 0
            val ver_bound = if (i - k - 2 >= 0) dp[i - k - 2][j1] else 0

            val twiceDeletedArea = if (hor_bound > 0 && ver_bound > 0) dp[i - k - 2][j - k - 2] else 0

            answer[i - 1][j - 1] = pl - hor_bound - ver_bound + twiceDeletedArea
        }
    }

    return answer
}

//[[12,21,16],
// [27,45,33],
// [24,39,28]]

fun main() {
    println(
            matrixBlockSum(
                    arrayOf(
                            intArrayOf(1, 2, 3),
                            intArrayOf(4, 5, 6),
                            intArrayOf(7, 8, 9)), k = 1)
                    .joinToString("\n") { it.joinToString(" ") }
    )
}