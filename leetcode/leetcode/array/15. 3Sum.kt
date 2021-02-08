package array

import java.util.*
import kotlin.test.assertEquals

//biggest challenge here - avoid duplicates
fun threeSum(nums: IntArray): List<List<Int>> {
    if (nums.size < 3) return emptyList()

    Arrays.sort(nums)

    val result = mutableListOf<List<Int>>()

    for (index in 0..nums.lastIndex - 2) {
        val isNotDuplicate = (index == 0) || (index > 0 && nums[index] != nums[index - 1])
        if (isNotDuplicate) {

            var low = index + 1
            var high = nums.lastIndex
            val sum = 0 - nums[index]

            while (low < high) {
                when {
                    sum == nums[low] + nums[high] -> {
                        result.add(listOf(nums[low], nums[high], nums[index]))

                        while (low < high && nums[low] == nums[low + 1]) {
                            low++
                        }

                        while (low < high && nums[high] == nums[high - 1]) {
                            high--
                        }

                        high--
                        low++
                    }
                    (nums[low] + nums[high] > sum) -> {
                        high--
                    }
                    else -> {
                        low++
                    }
                }
            }
        }
    }

    return result
}

fun main() {
    assertEquals(actual = threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)), expected = listOf(listOf(-1, -1, 2), listOf(-1, 0, 1)))
    assertEquals(actual = threeSum(intArrayOf(0, 0, 0, 0)), expected = listOf(listOf(0, 0, 0)))
    assertEquals(actual = threeSum(intArrayOf(-2, 0, 0, 2, 2)), expected = listOf(listOf(-2, 0, 2)))
}