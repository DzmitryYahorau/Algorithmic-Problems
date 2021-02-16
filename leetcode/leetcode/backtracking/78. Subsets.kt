package backtracking

class `78 Subsets` {

    fun subsets(nums: IntArray): List<List<Int>> {

        val result: MutableList<List<Int>> = mutableListOf()

        backtracking(nums = nums, result = result, index = 0, current = mutableListOf())

        return result
    }

    private fun backtracking(nums: IntArray, index: Int, current: MutableList<Int>, result: MutableList<List<Int>>) {
        result.add(current.toList())

        for (i in index..nums.lastIndex) {
            current.add(nums[i])
            backtracking(nums, i + 1, current, result)
            current.removeAt(current.lastIndex)
        }
    }
}

fun main() {
    println(`78 Subsets`().subsets(intArrayOf(1, 2, 3)).joinToString())
}