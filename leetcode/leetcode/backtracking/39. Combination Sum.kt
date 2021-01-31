package backtracking

//https://leetcode.com/problems/combination-sum/discuss/16502/
// A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)

import java.util.ArrayDeque

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