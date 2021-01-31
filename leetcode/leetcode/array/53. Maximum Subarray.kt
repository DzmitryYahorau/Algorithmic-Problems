package array

fun maxSubArray(nums: IntArray): Int {
    var sum = 0
    var maxSum = Int.MIN_VALUE
    for (i in nums.indices) {
        if (nums[i] + sum < nums[i]) {
            sum = nums[i]
        } else {
            sum += nums[i]
        }
        if (sum > maxSum) maxSum = sum
    }
    return maxSum
}

fun main() {
    val input = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    println(maxSubArray(input))
}