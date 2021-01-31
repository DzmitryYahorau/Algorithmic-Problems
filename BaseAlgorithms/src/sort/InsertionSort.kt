package sort

fun insertionSort(array: IntArray) {
    for (i in array.indices) {
        for (j in i downTo 1) {
            if (array[j] < array[j - 1]) {
                exchange(array, j, j - 1)
            } else {
                break
            }
        }
    }
}

fun main() {
    val input = (0..10).shuffled().toIntArray()
    insertionSort(input)
    println(input.joinToString(","))
}