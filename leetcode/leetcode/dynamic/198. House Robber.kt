package dynamic

import kotlin.test.assertEquals

//https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.

fun rob(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var prev1 = 0
    var prev2 = 0
    for (num in nums) {
        val tmp = prev1
        prev1 = (prev2 + num).coerceAtLeast(prev1)
        prev2 = tmp
    }
    return prev1
}


fun main() {
    assertEquals(rob(intArrayOf(1, 2, 3, 1)), 4)
    assertEquals(rob(intArrayOf(2, 1, 1, 2)), 4)
    assertEquals(rob(intArrayOf(2, 7, 9, 3, 1)), 12)
    assertEquals(rob(intArrayOf(0, 0, 0)), 0)
    assertEquals(rob(intArrayOf(4, 1, 2, 7, 5, 3, 1)), 14)
    assertEquals(actual = rob(intArrayOf(1, 3, 1)), expected = 3)
}