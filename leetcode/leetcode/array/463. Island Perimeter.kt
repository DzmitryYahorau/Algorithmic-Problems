package hashtable

import kotlin.test.assertEquals

fun islandPerimeter(grid: Array<IntArray>): Int {
    var perimeter = 0

    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == 1) {
                perimeter += neighborsCount(grid, i, j)
            }
        }
    }

    return perimeter
}

fun neighborsCount(grid: Array<IntArray>, x: Int, y: Int): Int {
    var count = 4

    if (y - 1 in grid[x].indices && grid[x][y - 1] == 1) {
        count -= 1
    }
    if (y + 1 in grid[x].indices && grid[x][y + 1] == 1) {
        count -= 1
    }
    if (x - 1 in grid.indices && grid[x - 1][y] == 1) {
        count -= 1
    }
    if (x + 1 in grid.indices && grid[x + 1][y] == 1) {
        count -= 1
    }

    return count
}

fun islandPerimeter2(grid: Array<IntArray>): Int {
    var islands = 0
    var neighbours = 0

    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == 1) {
                islands++ // count islands
                if (i < grid.size - 1 && grid[i + 1][j] == 1) neighbours++ // count down neighbours
                if (j < grid[i].size - 1 && grid[i][j + 1] == 1) neighbours++ // count right neighbours
            }
        }
    }
    return islands * 4 - neighbours * 2
}

fun main() {

    assertEquals(
            actual = islandPerimeter(
                    arrayOf(
                            intArrayOf(0, 1, 0, 0),
                            intArrayOf(1, 1, 1, 0),
                            intArrayOf(0, 1, 0, 0),
                            intArrayOf(1, 1, 0, 0),
                    )
            ),
            expected = 16
    )
    assertEquals(
            actual = islandPerimeter(
                    arrayOf(
                            intArrayOf(0, 1)
                    )
            ),
            expected = 4)
    assertEquals(
            actual = islandPerimeter(
                    arrayOf(
                            intArrayOf(1, 1),
                            intArrayOf(1, 1)
                    )
            ),
            expected = 8)
}
