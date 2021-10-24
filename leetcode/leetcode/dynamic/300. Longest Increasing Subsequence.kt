package dynamic

fun lengthOfLIS(nums: IntArray): Int {
    val dp = IntArray(nums.size) { 1 }

    for (i in nums.lastIndex downTo 0) {
        for (j in i + 1..nums.lastIndex) {
            if (nums[i] < nums[j]) {
                dp[i] = maxOf(1 + dp[j], dp[i])
            }
        }
    }

    return dp.max() ?: 0
}

fun main() {
    println(lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18))) // 4
    println(lengthOfLIS(intArrayOf(0, 1, 0, 3, 2, 3))) // 4
    println(lengthOfLIS(intArrayOf(7, 7, 7, 7, 7, 7, 7))) // 1
}