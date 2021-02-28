package interview_preparation_kit

import kotlin.test.assertEquals

//https://www.coursera.org/learn/algorithm-design-analysis
fun countInversions(arr: Array<Int>): Long {
    if (arr.isEmpty()) return 0

    return doMergeSort(
            lo = 0,
            hi = arr.lastIndex,
            array = arr,
            aux = arr.clone()
    )
}

fun doMergeSort(lo: Int, hi: Int, array: Array<Int>, aux: Array<Int>): Long {
    if (lo >= hi) return 0

    val mid = lo + (hi - lo) / 2

    var count = 0L

    //there is a trick - to swap aux and  array
    count+=doMergeSort(lo, mid, aux, array)
    count+=doMergeSort(mid + 1, hi, aux, array)

    count+=mergeWithCounter(array, aux, lo, mid, hi)
    return count
}

private fun mergeWithCounter(a: Array<Int>, aux: Array<Int>, lo: Int, mid: Int, hi: Int): Long {
    var i = lo
    var j = mid + 1
    var count = 0L
    for (k in lo..hi) {
        when {
            (i > mid) -> {
                a[k] = aux[j++]
            }
            (j > hi) -> {
                a[k] = aux[i++]
            }
            (aux[j] < aux[i]) -> {
                a[k] = aux[j++]
                //gypsy trick to count swaps
                count += mid + 1 - i
            }
            else -> {
                a[k] = aux[i++]
            }
        }
    }
    return count
}

fun main() {
    assertEquals(actual = countInversions(arrayOf(2, 1, 3, 1, 2)), expected = 4)
}