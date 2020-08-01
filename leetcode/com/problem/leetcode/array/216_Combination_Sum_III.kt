package array

//https://leetcode.com/problems/combination-sum-iii/
class Solution1 {

    private val nums = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()

        check(
                result = result,
                current = mutableListOf<Int>(),
                startIndex = 0,
                target = n,
                length = k
        )

        return result
    }

    // https://discuss.leetcode.com/topic/37962/fast-easy-java-code-with-explanation - good explanation
    private fun check(
            result: MutableList<MutableList<Int>>,
            current: MutableList<Int>,
            startIndex: Int,
            target: Int,
            length: Int
    ) {
        if (length == 0 && target == 0) {
            result.add(current.toMutableList())
        } else {
            var i: Int = startIndex
            while (i < nums.size && target > 0 && length > 0) {
                val num = nums[i]
                current.add(num)
                check(
                        result = result,
                        current = current,
                        startIndex = i + 1,
                        target = target - num,
                        length = length - 1
                )
                current.remove(num)
                i++
            }
        }
    }
}

fun main() {
    val k = 3
    val n = 7
    println(Solution1().combinationSum3(k, n))
}