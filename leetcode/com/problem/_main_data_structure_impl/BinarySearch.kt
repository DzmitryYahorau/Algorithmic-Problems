package _main_data_structure_impl

import kotlin.time.*

private fun binarySearch(
        array: IntArray,
        lo: Int = 0,
        hi: Int = array.lastIndex,
        target: Int
): Int {
    if (lo == hi) return if (target == array[lo]) array[lo] else -1

    val mid = lo + (hi - lo) / 2

    return when {
        target > array[mid] -> binarySearch(array, mid + 1, hi, target)
        target < array[mid] -> binarySearch(array, lo, mid, target)
        else -> array[mid]
    }
}

@ExperimentalTime
fun main() {
    val arr = (0..100000000).toList().toIntArray()

    val time = measureTime {
        binarySearch(arr, target = 99)
    }
    println("Time: $time")
}