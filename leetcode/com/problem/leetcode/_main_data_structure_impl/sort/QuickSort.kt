package _main_data_structure_impl.sort

private fun sort(array: IntArray, lo: Int, hi: Int) {
    if (hi <= lo) return
    var lt = lo
    var gt = hi
    val pivot = array[lo]
    var i = lo

    while (i <= gt) {
        when {
            (array[i] < pivot) -> exchange(array, lt++, i++)
            (array[i] > pivot) -> exchange(array, i, gt--)
            (array[i] == pivot) -> {
                i++
            }
        }
    }

    sort(array, lo, lt - 1)
    sort(array, gt + 1, hi)
}
