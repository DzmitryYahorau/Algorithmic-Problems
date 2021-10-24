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

// same dp approach, just revisited
fun maxSubArray2(nums: IntArray): Int {
    var max = Int.MIN_VALUE
    var sum = 0
    nums.forEach { num ->
        sum = maxOf(sum + num, num)
        max = maxOf(max, sum)
    }

    return max
}

// O(n)

fun main() {
    val input = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    println(maxSubArray2(input))
}