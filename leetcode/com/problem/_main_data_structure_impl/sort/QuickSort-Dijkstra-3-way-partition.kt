package _main_data_structure_impl.sort

private fun quickSort(array: IntArray, lo: Int, hi: Int) {
    if (hi <= lo) return

    var lt = lo
    var gt = hi
    var i = lo

    while (i <= gt) {
        when {
            array[i] < array[lo] -> exchange(array, lt++, i++)
            array[i] > array[lo] -> exchange(array, i, gt--)
            else -> i++
        }
    }

    quickSort(array, lo, lt - 1)
    quickSort(array, gt + 1, hi)
}

fun main() {
    val input = (0..100).shuffled().toIntArray()
    quickSort(input, 0, input.size - 1)
    println(input.joinToString(","))
}