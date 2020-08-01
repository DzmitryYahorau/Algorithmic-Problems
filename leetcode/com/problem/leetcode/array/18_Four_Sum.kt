package array

class Solution18 {

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = mutableSetOf<List<Int>>()

        check(
                result = result,
                current = mutableListOf<Int>(),
                nums = nums.sortedArray(),
                startIndex = 0,
                target = target,
                length = 4
        )

        return result.toList()
    }

    private fun check(
            result: MutableSet<List<Int>>,
            current: MutableList<Int>,
            nums: IntArray,
            startIndex: Int,
            target: Int,
            length: Int
    ) {
        if (target == 0 && length == 0 && !result.contains(current)) {
            //IMPORTANT: make copy of list, as it's in use.
            result.add(current.toMutableList())
        } else {
            var i = startIndex
            while (i < nums.size && length > 0) {
                val num = nums[i]
                current.add(num)
                check(
                        result = result,
                        current = current,
                        nums = nums,
                        startIndex = ++i,
                        target = target - num,
                        length = length - 1
                )
                current.remove(num)
            }
        }
    }
}

fun main() {
//    val inputArray = intArrayOf(1, 0, -1, 0, -2, 2)
    val inputArray = intArrayOf(-3, -2, -1, 0, 0, 1, 2, 3)
    val target = 0
    println(Solution18().fourSum(inputArray, target))
}