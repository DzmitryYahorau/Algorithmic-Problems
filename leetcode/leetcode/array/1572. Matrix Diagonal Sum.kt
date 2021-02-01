package array

fun diagonalSum(mat: Array<IntArray>): Int {
    var result = 0
    for (i in mat.indices) {
        val row = mat[i]
        result += if (i != row.lastIndex - i) {
            row[i] + row[row.lastIndex - i]
        } else {
            row[i]
        }
    }
    return result
}

fun main() {
    val mat = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
    )

    println(diagonalSum(mat))
}