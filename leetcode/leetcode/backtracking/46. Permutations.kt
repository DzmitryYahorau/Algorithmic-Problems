package backtracking

import java.util.*

fun permute(nums: IntArray): List<List<Int>> {
    val list = mutableListOf<List<Int>>()

    permute(nums, Stack(), list, BooleanArray(nums.size) { false })
    return list
}

private fun permute(nums: IntArray, permutation: Stack<Int>, result: MutableList<List<Int>>, used: BooleanArray) {

    //backtracking GOAL
    if (permutation.size == nums.size) {
        result.add(permutation.toList())
        return
    } else {
        for (i in nums.indices) {
            // constraint - choice is valid
            if (!used[i]) {
                used[i] = true
                // make choice
                val num = nums[i]
                permutation.push(num)
                permute(nums, permutation, result, used)
                used[i] = false
                permutation.pop()
            }
        }
    }
}

fun main() {
    val inputArray = intArrayOf(1, 2, 3)
    println(permute(inputArray))
}