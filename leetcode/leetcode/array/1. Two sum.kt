package array

fun `1 twoSum`(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()

    for(index in nums.indices){
        val m = target - nums[index]

        if (map[m] != null){
            // solution
            return intArrayOf(index, map[m]!!)
        }

        map[nums[index]] = index
    }

    throw IllegalArgumentException()
}