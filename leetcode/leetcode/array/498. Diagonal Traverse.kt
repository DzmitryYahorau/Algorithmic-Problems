package array

fun findDiagonalOrder(matrix: Array<IntArray>): IntArray {
    if (matrix.isEmpty()) return intArrayOf()
    val res = mutableListOf<Int>()
    goUp(matrix, 0, 0, res)
    return res.toTypedArray().toIntArray()
}

fun goUp(matrix: Array<IntArray>, startX: Int, startY: Int, result: MutableList<Int>) {
    if ((startX >= matrix.lastIndex) && (startY >= matrix[startX].lastIndex)) {
        result.add(matrix[startX][startY])
        return
    }

    var i = startX
    var j = startY

    while (i in matrix.indices && j in matrix[i].indices) {
        result.add(matrix[i][j])
        i--
        j++
    }

    if ((j) > matrix[startX].lastIndex) {
        i = i + 2
    }

    goDown(matrix, i.coerceAtLeast(0), (j).coerceAtMost(matrix[startX].lastIndex), result)
}

fun goDown(matrix: Array<IntArray>, startX: Int, startY: Int, result: MutableList<Int>) {
    if ((startX >= matrix.lastIndex) && (startY >= matrix[startX].lastIndex)) {
        result.add(matrix[startX][startY])
        return
    }

    var i = startX
    var j = startY

    while (i in matrix.indices && j in matrix[i].indices) {
        result.add(matrix[i][j])
        i++
        j--
    }

    if ((i) > matrix.lastIndex) {
        j = j + 2
    }

    goUp(matrix, (i).coerceAtMost(matrix.lastIndex), j.coerceAtLeast(0), result)
}

fun main() {
    println(
            findDiagonalOrder(
                    arrayOf(
                            intArrayOf(1, 2, 3),
                            intArrayOf(4, 5, 6),
                            intArrayOf(7, 8, 9)
                    )
            ).joinToString()
    )
}