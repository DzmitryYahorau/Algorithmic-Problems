package array

import kotlin.math.abs

class Solution442 {

    fun findDuplicates(nums: IntArray): List<Int>? {
        val result: MutableList<Int> = ArrayList()

        for (element in nums) {
            val location = abs(element) - 1 // index of element where we store the marker
            if (nums[location] < 0) {
                result.add(abs(element))
            } else {
                nums[location] = -nums[location]
            } // use -nums[location] like a marker that location item exists in nums
        }

        for (i in nums.indices) {
            nums[i] = abs(nums[i]) // recover array
        }

        return result
    }
}

fun main() {
    val input = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)
    println(Solution442().findDuplicates(input))
}