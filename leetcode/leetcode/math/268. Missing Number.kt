package math

fun missingNumber(nums: IntArray): Int {
    val n = nums.size
    val sumExpected = (1 + n) * n / 2

    return sumExpected - nums.sum()
}