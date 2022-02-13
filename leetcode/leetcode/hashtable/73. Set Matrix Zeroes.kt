package hashtable

fun setZeroes(matrix: Array<IntArray>) {

    // check rows, columns: set flag to start row/col
    var isCol = false

    for (i in matrix.indices) {
        if (matrix[i][0] == 0) {
            isCol = true
        }
    }

    for (i in matrix.indices) {
        for (j in 1..matrix.first().lastIndex) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0
                matrix[0][j] = 0
            }
        }
    }

    for (i in 1..matrix.lastIndex) {
        for (j in 1..matrix.first().lastIndex) {
            if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                matrix[i][j] = 0
            }
        }
    }

    if (matrix[0][0] == 0) {
        for (i in 1..matrix.first().lastIndex) {
            matrix[0][i] = 0
        }
    }

    if (isCol) {
        for (j in matrix.indices) {
            matrix[j][0] = 0
        }
    }

//    println(matrix.joinToString("\n") { it.joinToString(" ") })
}

fun main() {
    println(setZeroes(matrix = arrayOf(
            intArrayOf(0, 0, 0, 5),
            intArrayOf(4, 3, 1, 4),
            intArrayOf(0, 1, 1, 4),
            intArrayOf(1, 2, 1, 3),
            intArrayOf(0, 0, 1, 1)
    )))
    println(setZeroes(matrix = arrayOf(
            intArrayOf(0, 1, 2, 0),
            intArrayOf(3, 4, 5, 2),
            intArrayOf(1, 3, 1, 5)
    )))

    println(setZeroes(matrix = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 1)
    )))
    setZeroes(matrix = arrayOf(
            intArrayOf(1, 0)
    ))
    setZeroes(matrix = arrayOf(
            intArrayOf(1),
            intArrayOf(0)
    ))
}