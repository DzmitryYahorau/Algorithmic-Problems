package array

fun pivotIndex(nums: IntArray): Int {
    var left_sum = 0
    var right_sum = nums.sum()
    for (i in nums.indices) {
        right_sum -= nums[i]
        if (left_sum == right_sum) {
            return i
        }
        left_sum += nums[i]
    }

    return -1
}

fun main() {
    println(pivotIndex(intArrayOf(1, 7, 3, 6, 5, 6)))
    println(pivotIndex(intArrayOf(2, -1, 1)))
}