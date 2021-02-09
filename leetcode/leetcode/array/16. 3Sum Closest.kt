package array

import java.util.*
import kotlin.test.assertEquals


fun threeSumClosest(nums: IntArray, target: Int): Int {
    if (nums.size < 3) return 0

    Arrays.sort(nums)

    var minDelta = Int.MAX_VALUE
    var sumClosest = Int.MIN_VALUE

    for (i in 0..nums.lastIndex - 2) {
        if (i > 0 && (nums[i] == nums[i - 1])) {
            continue
        }

        var high = nums.lastIndex
        var low = i + 1

        while (low < high) {
            val sum = nums[low] + nums[high]
            val delta = target - nums[i]

            if (sum < delta) {
                if (delta - sum < minDelta) {
                    minDelta = delta - sum
                    sumClosest = sum + nums[i]
                }
                low++
                continue
            }

            if (sum > delta) {
                if (sum - delta < minDelta) {
                    minDelta = sum - delta
                    sumClosest = sum + nums[i]
                }
                high--
                continue
            }
            return sum + nums[i]
        }
    }

    return sumClosest
}

fun main() {
    assertEquals(expected = 2, actual = threeSumClosest(intArrayOf(-1, 2, 1, -4), target = 1))

    assertEquals(expected = 0, actual = threeSumClosest(intArrayOf(0, 2, 1, -3), target = 1))
}