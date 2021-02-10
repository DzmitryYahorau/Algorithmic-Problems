package array

import kotlin.test.assertEquals

fun flipAndInvertImage(A: Array<IntArray>): Array<IntArray> {
    for (i in A.indices) {
        var lo = 0
        var hi: Int = A[0].lastIndex
        while (lo <= hi) {
            if (A[i][lo] == A[i][hi]) {
                A[i][lo] = 1 - A[i][lo]
                A[i][hi] = A[i][lo]
            }
            lo++
            hi--
        }
    }
    return A
}

fun main() {

    assertEquals(
//            expected = arrayOf(intArrayOf(1, 0, 0).joinToString(), intArrayOf(0, 1, 0).joinToString(), intArrayOf(1, 1, 1).joinToString()).joinToString(),
            expected = arrayOf(intArrayOf(1, 0, 0).joinToString()).joinToString(),
            actual = flipAndInvertImage(arrayOf(intArrayOf(1, 1, 0))).joinToString { it.joinToString() }
    )
}