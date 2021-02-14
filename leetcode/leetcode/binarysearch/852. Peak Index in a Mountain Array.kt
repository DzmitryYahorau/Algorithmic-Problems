package binarysearch

import kotlin.test.assertEquals

fun peakIndexInMountainArray(A: IntArray): Int {
    var start = 0
    var end = A.lastIndex
    while (start < end) {
        val mid = start + (end - start) / 2

        //checking next = mid  + 1
        if (A[mid] < A[mid + 1]) {
            start = mid + 1
        } else {
            end = mid
        }
    }
    return start
}

fun main() {
    assertEquals(peakIndexInMountainArray(intArrayOf(0, 2, 1, 0)), 1)
    assertEquals(peakIndexInMountainArray(intArrayOf(0, 10, 5, 2)), 1)
}