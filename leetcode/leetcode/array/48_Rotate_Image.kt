package array

fun rotate(matrix: Array<IntArray>) {
    for (i in matrix.indices) {
        for (j in 0..matrix[i].lastIndex / 2) {
            exch(matrix[i], j, matrix[i].lastIndex - j)
        }
    }

    for (i in matrix.indices) {
        for (j in 0..matrix.lastIndex - i) {
            val temp = matrix[i][j]
            matrix[i][j] = matrix[matrix.lastIndex - j][matrix.lastIndex - i]
            matrix[matrix.lastIndex - j][matrix.lastIndex - i] = temp
        }
    }
}

fun exch(array: IntArray, firstIndex: Int, secondIndex: Int) {
    val temp = array[secondIndex]
    array[secondIndex] = array[firstIndex]
    array[firstIndex] = temp
}