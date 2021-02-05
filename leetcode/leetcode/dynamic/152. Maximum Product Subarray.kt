package dynamic

import kotlin.test.assertEquals

fun maxProduct(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var prevPos = nums[0]
    var prevNeg = nums[0]

    var max = nums[0]

    for (i in 1..nums.lastIndex) {
        val pos = prevPos * nums[i]
        val neg = prevNeg * nums[i]
        prevPos = maxOf(nums[i], maxOf(neg, pos))
        prevNeg = minOf(nums[i], minOf(neg, pos))
        max = maxOf(max, prevPos)
    }

    return max
}

fun main() {
    assertEquals(actual = maxProduct(intArrayOf(2, 3, -2, 4)), expected = 6)
    assertEquals(actual = maxProduct(intArrayOf(-2, 3, -4)), expected = 24)
    assertEquals(actual = maxProduct(intArrayOf(0, 2)), expected = 2)
    assertEquals(actual = maxProduct(intArrayOf(2, -5, -2, -4, 3)), expected = 24)
}