package _main_data_structure_impl.sort

import java.util.*
import java.util.Collections.shuffle

/**
 * Rearranges the array in ascending order, using the natural order.
 * @param a the array to be sorted
 */
fun quickSort(a: IntArray) {
//    a.shuffle()
    sort(a, 0, a.size - 1)
}

// quicksort the subarray from a[lo] to a[hi]
private fun sort(a: IntArray, lo: Int, hi: Int) {
    if (hi <= lo) return
    val j = partition(a, lo, hi)
    sort(a, lo, j - 1)
    sort(a, j + 1, hi)
}

// partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
// and return the index j.
private fun partition(a: IntArray, lo: Int, hi: Int): Int {
    var i = lo
    var j = hi + 1
    val v = a[lo]
    while (true) {

        // find item on lo to swap
        while (a[++i] < v) {
            if (i == hi) break
        }

        // find item on hi to swap
        while (v < a[--j]) {
            if (j == lo) break // redundant since a[lo] acts as sentinel
        }

        // check if pointers cross
        if (i >= j) break
        exchange(a, i, j)
    }

    // put partitioning item v at a[j]
    exchange(a, lo, j)

    // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
    return j
}

/**
 * Rearranges the array so that `a[k]` contains the kth smallest key;
 * `a[0]` through `a[k-1]` are less than (or equal to) `a[k]`; and
 * `a[k+1]` through `a[n-1]` are greater than (or equal to) `a[k]`.
 *
 * @param  a the array
 * @param  k the rank of the key
 * @return the key of rank `k`
 * @throws IllegalArgumentException unless `0 <= k < a.length`
 */
fun select(a: IntArray, k: Int): Comparable<*>? {
    require(!(k < 0 || k >= a.size)) { "index is not between 0 and " + a.size + ": " + k }
//    shuffle(a)
    var lo = 0
    var hi = a.size - 1
    while (hi > lo) {
        val i = partition(a, lo, hi)
        when {
            i > k -> hi = i - 1
            i < k -> lo = i + 1
            else -> return a[i]
        }
    }
    return a[lo]
}

//private fun sort(array: IntArray, lo: Int, hi: Int) {
//    if (hi <= lo) return
//    var lt = lo
//    var gt = hi
//    val pivot = array[lo]
//    var i = lo
//
//    while (i <= gt) {
//        when {
//            (array[i] < pivot) -> exchange(array, lt++, i++)
//            (array[i] > pivot) -> exchange(array, i, gt--)
//            (array[i] == pivot) -> {
//                i++
//            }
//        }
//    }
//
//    sort(array, lo, lt - 1)
//    sort(array, gt + 1, hi)
//}