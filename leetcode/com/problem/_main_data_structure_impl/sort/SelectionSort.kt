package _main_data_structure_impl.sort

fun selectionSort(array: IntArray) {
    for (i in array.indices) {
        var min = i
        for (j in (i + 1) until array.size) {
            if (array[j] < array[min]) {
                min = j
            }
        }
        exchange(array, i, min)
    }
}

fun <T : Any?> exchange(array: Array<T>, first: Int, second: Int) {
    val temp = array[first]
    array[first] = array[second]
    array[second] = temp
}

fun exchange(array: IntArray, first: Int, second: Int) {
    val temp = array[first]
    array[first] = array[second]
    array[second] = temp
}

fun main() {
    val input = (0..10).shuffled().toIntArray()
    selectionSort(input)
    println(input.joinToString(","))
}