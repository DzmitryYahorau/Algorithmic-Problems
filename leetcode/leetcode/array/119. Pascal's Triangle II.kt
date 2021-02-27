package array

fun getRow(rowIndex: Int): List<Int> {
    return getRowByIndex(rowIndex)
}

private fun getRowByIndex(rowIndex: Int): List<Int> {
    if (rowIndex == 0) return listOf(1)
    return listOf(1) + getRowByIndex(rowIndex - 1).zipWithNext { a, b -> a + b } + listOf(1)
}

fun getRow2(rowIndex: Int): List<Int> {
    val result = mutableListOf<Int>()
    result.add(1)
    for (i in 1..rowIndex) {
        for (j in i - 1 downTo 1) {
            val tmp = result[j - 1] + result[j]
            result[j] = tmp
        }
        result.add(1)
    }
    return result
}

fun main() {
    println(getRow(0))

    println(getRow(1))
    println(getRow(3))
    println(getRow(10))


    println(getRow(33))
}