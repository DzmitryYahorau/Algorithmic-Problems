package array

import java.util.*

fun majorityElement(nums: IntArray): Int {
    Arrays.sort(nums)

    val mid = nums.size / 2
    return nums[mid]
}

object `hashmap solution` {
    fun majorityElement(nums: IntArray): Int {
        if (nums.size == 1) return nums.first()
        val map = mutableMapOf<Int, Int>()

        for (i in nums.indices) {
            val num = nums[i]
            if (map.containsKey(num) && map.getOrDefault(num, 0) + 1 > nums.size / 2) {
                return num
            } else {
                map[num] = map.getOrDefault(num, 0) + 1
            }
        }

        return -1
    }
}

object `Boyer-Moore Voting Algorithm` {

    fun majorityElement(nums: IntArray): Int {
        var count = 0
        var candidate: Int? = null
        for (num in nums) {
            if (count == 0) {
                candidate = num
            }
            count += if (num == candidate) 1 else -1
        }
        return candidate ?: -1
    }
}

fun main() {

    `hashmap solution`.majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2))
}
