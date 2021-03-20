package array

import kotlin.test.assertEquals

fun twoSum(numbers: IntArray, target: Int): IntArray {
    var lo = 0

    while (lo < numbers.size) {
        val secondIndex = searchII(numbers, target - numbers[lo], lo + 1, numbers.lastIndex)
        if (numbers[lo] + numbers[secondIndex] == target) {
            return intArrayOf(lo + 1, secondIndex + 1)
        }

        lo++
    }
    return intArrayOf()
}

private fun searchII(numbers: IntArray, target: Int, lo: Int, hi: Int): Int {
    if (lo >= hi) return lo
    val mid = lo + (hi - lo) / 2

    return if (numbers[mid] < target) {
        searchII(numbers, target, mid + 1, hi)
    } else {
        searchII(numbers, target, lo, mid)
    }
}


fun main() {
    assertEquals(twoSum(intArrayOf(2, 7, 11, 15), 9).joinToString(), intArrayOf(1, 2).joinToString())
    assertEquals(twoSum(intArrayOf(2, 3, 4), 6).joinToString(), intArrayOf(1, 3).joinToString())
}