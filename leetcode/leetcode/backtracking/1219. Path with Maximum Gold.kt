package backtracking

fun getMaximumGold(grid: Array<IntArray>): Int {
    if (grid.isEmpty()) return 0
    var max = Int.MIN_VALUE

    for (y in grid.indices) {
        for (x in grid[y].indices) {
            if (grid[y][x] != 0) {
                max = maxOf(max, dfs(x, y, grid, mutableListOf(), 0))
            }
        }
    }

    return max
}

private fun dfs(
        x: Int,
        y: Int,
        grid: Array<IntArray>,
        visited: List<String>,
        sum: Int
): Int {
    if (inBounds(x, y, grid) && grid[y][x] != 0 && !visited.contains("$y$x")) {
        val newSum = sum + grid[y][x]

        val bottom = dfs(x, y + 1, grid, visited + "$y$x", newSum)
        val left = dfs(x - 1, y, grid, visited + "$y$x", newSum)
        val right = dfs(x + 1, y, grid, visited + "$y$x", newSum)
        val top = dfs( x, y - 1, grid, visited + "$y$x", newSum)

        return listOf(left, right, top, bottom).max() ?: 0
    } else {
        return sum
    }
}

private fun inBounds(x: Int, y: Int, grid: Array<IntArray>): Boolean =
        (y in grid.indices) && (x in grid[y].indices)

fun main() {
    println(getMaximumGold(
            arrayOf(
                    intArrayOf(0, 1, 6, 20, 0),
                    intArrayOf(0, 0, 3, 0, 0),
                    intArrayOf(16, 9, 16, 8, 0),
                    intArrayOf(14, 0, 4, 20, 9)
            )
    ))
}
