package array

import kotlin.math.min

fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {
    if (grid.size == 1 && grid[0].size == 1) return 0

    val rowMax = IntArray(grid.size)

    for (i in grid.indices) {
        val row = grid[i]
        rowMax[i] = row.max() ?: 0
    }

    val columnMax = IntArray(grid[0].size)
    for (j in grid[0].indices) {
        var max = 0
        for (i in 0..grid.lastIndex) {
            max = maxOf(max, grid[i][j])
        }

        columnMax[j] = max
    }

    var increaseCount = 0

    for (i in grid.indices) {
        val row = grid[i].indices
        for (j in row) {
            increaseCount += (min(rowMax[i], columnMax[j]) - grid[i][j])
        }
    }

    return increaseCount
}

fun main() {
    println(maxIncreaseKeepingSkyline(
            arrayOf(
                    intArrayOf(3, 0, 8, 4),
                    intArrayOf(2, 4, 5, 7),
                    intArrayOf(9, 2, 6, 3),
                    intArrayOf(0, 3, 1, 0)
            )
    ))
}