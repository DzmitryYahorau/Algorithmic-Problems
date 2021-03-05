package array

import kotlin.test.assertEquals

fun findLengthOfLCIS(nums: IntArray): Int {
    if (nums.size <= 1) return nums.size

    var result = 0
    var i = 1

    while (i <= nums.lastIndex) {
        var local = 1
        while (i in nums.indices && nums[i - 1] < nums[i]) {
            i++
            local++
        }
        result = maxOf(result, local)
        i++
    }

    return result
}

fun main() {
    assertEquals(actual = findLengthOfLCIS(intArrayOf(1, 3, 5, 4, 7)), expected = 3)
    assertEquals(actual = findLengthOfLCIS(intArrayOf(2, 2, 2, 2, 2)), expected = 1)
    assertEquals(actual = findLengthOfLCIS(intArrayOf(1, 2)), expected = 2)
}