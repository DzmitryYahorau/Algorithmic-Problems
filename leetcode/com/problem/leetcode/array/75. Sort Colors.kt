package array

fun sortColors(nums: IntArray) {
    var red = 0
    var white = 0

    nums.forEach {
        when (it) {
            0 -> red++
            1 -> white++
        }
    }

    for (i in nums.indices) {
        when (i) {
            in (0 until red) -> nums[i] = 0
            in (red until white + red) -> nums[i] = 1
            in (white + red until nums.size) -> nums[i] = 2
        }
    }
}