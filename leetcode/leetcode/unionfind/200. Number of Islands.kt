package unionfind

fun numIslands(grid: Array<CharArray>): Int {
    var islandsCount = 0

    grid.forEachIndexed { i, row ->
        row.forEachIndexed { j, char ->
            if (char == '1') {
                dfs(grid, i, j)
                islandsCount ++
            }
        }
    }

    return islandsCount
}

private fun dfs(grid: Array<CharArray>, i: Int, j: Int) {
    if (i !in grid.indices || j !in grid[i].indices || grid[i][j] == '0') {
        return
    }

    grid[i][j] = '0'

    dfs(grid, i + 1, j)
    dfs(grid, i - 1, j)
    dfs(grid, i, j + 1)
    dfs(grid, i, j - 1)
}

fun main() {
    val input1 = arrayOf(
            charArrayOf('1', '1', '1', '1', '0'),
            charArrayOf('1', '1', '0', '1', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '0', '0', '0')
    )

    println(numIslands(input1))
}