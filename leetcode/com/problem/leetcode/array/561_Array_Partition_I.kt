package array

class ArrayPartitionI {

    fun arrayPairSum(nums: IntArray): Int {
        return pairSum(nums.sorted().toIntArray())
    }

    private fun pairSum(nums: IntArray): Int {
        var result = 0
        for (i in nums.indices step 2) {
            result += nums[i]
        }
        return result
    }


}

fun main() {
    val input = intArrayOf(1, 4, 3, 2)
    println(ArrayPartitionI().arrayPairSum(input))
}