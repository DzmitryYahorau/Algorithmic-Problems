package array

fun moveZeroes(nums: IntArray) {
    if (nums.isEmpty()) return

    var current = 0

    while (current < nums.size) {
        if (nums[current] == 0) {
            var nextNonZero = current + 1
            while (nextNonZero < nums.size && nums[nextNonZero] == 0) {
                nextNonZero++
            }
            if (nextNonZero < nums.size) {
                exch(nums, current, nextNonZero)
            }
        }
        current++
    }
}


fun main() {
    val input = intArrayOf(0, 1, 0, 3, 12)
    moveZeroes(input)
    println(input.joinToString())
}