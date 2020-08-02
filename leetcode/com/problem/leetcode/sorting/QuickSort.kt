package sorting

class QuickSort {

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

    private fun exchange(array: IntArray, i: Int, j: Int) {
        val temp = array[i]

        array[i] = array[j]
        array[j] = temp
    }
}