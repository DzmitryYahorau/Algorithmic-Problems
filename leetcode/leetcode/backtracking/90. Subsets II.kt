package backtracking

import java.util.*

class `90 Subset 2` {

    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val result: MutableList<List<Int>> = mutableListOf()
        Arrays.sort(nums)
        backtracking(0, nums, mutableListOf(), result)

        return result.toList()
    }

    private fun backtracking(
            index: Int,
            nums: IntArray,
            current: MutableList<Int>,
            result: MutableList<List<Int>>
    ) {
        result.add(current.toList())

        for (i in index..nums.lastIndex) {
            if (i > index && nums[i] == nums[i - 1]) continue
            current.add(nums[i])
            backtracking(i + 1, nums, current, result)
            current.removeAt(current.lastIndex)
        }
    }
}

fun main() {
    println(`90 Subset 2`().subsetsWithDup(intArrayOf(1, 2, 2)).joinToString())
}
