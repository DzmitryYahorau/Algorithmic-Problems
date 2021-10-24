package dynamic

import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 *Time complexity :
 * O(2 in power of n)
 * O(2n). Size of recursion tree will be 2n.
 * Space complexity :
 * O(n)
 * O(n). The depth of the recursion tree can go up to n n.
 */
fun PredictTheWinner(nums: IntArray): Boolean {
    if (nums.size == 1) return true

    return makeStepFirst(nums = nums, lo = 0, hi = nums.lastIndex, firstSum = 0, secondSum = 0)
}

fun makeStepFirst(nums: IntArray, lo: Int, hi: Int, firstSum: Int, secondSum: Int) : Boolean {
    if (lo > hi) {
        return firstSum >= secondSum
    }

    return makeStepSecond(nums, lo + 1, hi, firstSum + nums[lo], secondSum)
            || makeStepSecond(nums, lo, hi - 1, firstSum + nums[hi], secondSum)
}

fun makeStepSecond(nums: IntArray, lo: Int, hi: Int, firstSum: Int, secondSum: Int): Boolean {
    if (lo > hi) {
        return firstSum >= secondSum
    }

    val fromLeft = makeStepFirst(nums, lo + 1, hi, firstSum, secondSum + nums[lo])
    val fromRight = makeStepFirst(nums, lo, hi - 1, firstSum, secondSum + nums[hi])

    when{
        !fromLeft && !fromRight -> return false
        fromLeft && fromRight -> return true
        !fromLeft -> return makeStepFirst(nums, lo + 1, hi, firstSum, secondSum + nums[lo])
        else -> return makeStepFirst(nums, lo, hi - 1, firstSum, secondSum + nums[hi])
    }
}

/**
 * Todo: Think about DP next time.
 */


fun main() {
    assertFalse(PredictTheWinner(intArrayOf(1, 5, 2)))
    assertTrue(PredictTheWinner(intArrayOf(1, 5, 233, 7)))
    assertFalse(PredictTheWinner(intArrayOf(2, 4, 55, 6, 8)))
}