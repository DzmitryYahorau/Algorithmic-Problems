package array

import kotlin.math.min

private class Solution697 {

    fun findShortestSubArray(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()

        var maxDegree = 0
        for (i in nums.indices) {
            var cnt = (map[nums[i]] ?: 0)
            map[nums[i]] = ++cnt
            maxDegree = maxOf(maxDegree, cnt)
        }

        var res = Int.MAX_VALUE
        for (i in map.keys) {
            if (map[i] == maxDegree) {
                val minLen: Int = minSubarrContainingX(nums, i)
                res = min(res, minLen)
            }
        }
        return res
    }

    private fun minSubarrContainingX(nums: IntArray, x: Int): Int {
        var l = 0
        var r = nums.size - 1
        while (l < r) {
            val li = nums[l]
            val ri = nums[r]

            when {
                ((li == x) && (ri == x)) -> return r - l + 1
                (li != x) -> l++
                (ri != x) -> r--
            }

        }
        return r - l + 1
    }
}

fun main() {
//    val input = intArrayOf(1, 2, 2, 3, 1)
    val input = intArrayOf(1, 2, 2, 3, 1, 4, 2)
    println(Solution697().findShortestSubArray(input))
}