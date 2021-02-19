package binarysearch

fun search(nums: IntArray, target: Int): Int {
    return binarySearch(nums, target, 0, nums.lastIndex)
}

private fun binarySearch(nums: IntArray, target: Int, lo: Int, hi: Int): Int {
    if (lo > hi) return -1
    val mid = lo + (hi - lo) / 2

    return when {
        nums[mid] < target -> binarySearch(nums, target, mid + 1, hi)
        nums[mid] > target -> binarySearch(nums, target, lo, mid - 1)
        else -> mid
    }
}

fun main() {
    search(intArrayOf(-1, 0, 3, 5, 9, 12), 9)
    search(intArrayOf(2, 5), 0)
}