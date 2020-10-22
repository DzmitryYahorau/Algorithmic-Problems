package array

fun generate(numRows: Int): List<List<Int>> {
    if (numRows == 0) return emptyList()

    val result = mutableListOf(listOf(1))

    repeat(numRows - 1) {
        result.add(listOf(1) + result.last().zipWithNext { a, b -> a + b } + listOf(1))
    }

    return result
}