package array

fun searchInsert(nums: IntArray, target: Int): Int =
        searchInsert(nums, target, 0, nums.size - 1)

private fun searchInsert(nums: IntArray, target: Int, lo: Int, hi: Int): Int {
    if (lo >= hi) return if (nums.last() < target) {
        hi + 1
    } else {
        hi
    }

    val mid = lo + (hi - lo) / 2

    return when {
        nums[mid] < target -> searchInsert(nums, target, mid + 1, hi)
        nums[mid] > target -> searchInsert(nums, target, lo, mid)
        else -> return mid
    }
}

fun main() {
    val input = intArrayOf(1, 3, 5, 6)
    println(searchInsert(input, 7))
}