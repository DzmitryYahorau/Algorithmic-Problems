package backtracking

//https://leetcode.com/problems/combination-sum/discuss/16502/
// A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)

import java.util.*

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val list = mutableListOf<List<Int>>()
    backtrack(result = list, candidates = candidates.sorted(), remain = target, start = 0)
    return list
}

private fun backtrack(
        result: MutableList<List<Int>>,
        tempList: ArrayDeque<Int> = ArrayDeque(),
        candidates: List<Int>,
        remain: Int,
        start: Int
) {
    when {
        (remain < 0) -> return
        (remain == 0) -> result.add(tempList.toList())
        else -> {
            for (i in start until candidates.size) {
                tempList.push(candidates[i])
                backtrack(result, tempList, candidates, remain - candidates[i], i) // not i + 1 because we can reuse same elements
                tempList.pop()
            }
        }
    }
}

class `39 Second Try`{

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        val result = mutableListOf<List<Int>>()
        backtracking(result = result, candidates = candidates, remain = target, start = 0)
        return result
    }

    private fun backtracking(
            result: MutableList<List<Int>>,
            temp: ArrayDeque<Int> = ArrayDeque(),
            candidates: IntArray,
            remain: Int,
            start: Int
    ){
        if (remain < 0) {
            return
        }
        if (remain == 0){
            result.add(temp.toList())
        }

        for (a in start..candidates.lastIndex){
            temp.offer(candidates[a])
            backtracking(result, temp, candidates, remain - candidates[a], a)
            temp.poll()
        }
    }
}

fun main() {
    val a= `39 Second Try`()
    a.combinationSum(intArrayOf(2, 2, 3), 7)
}