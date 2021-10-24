package tree

import java.util.ArrayList
import java.util.LinkedList

import java.util.HashMap


fun allPossibleFBT(N: Int): List<TreeNode?> {
    if (N == 0) return emptyList()

    val root = TreeNode(0)

    val result = mutableListOf<TreeNode?>()

    for (i in 1..N) {
        backtracking(root, i - 1, result)
    }

    return result
}

private fun backtracking(root: TreeNode?, N: Int, result: MutableList<TreeNode?>) {
    if (N == 1) return
    if (N <= 0) {
        if (root.isFull()) {
            result.add(root)
        }
        return
    }

//    if (root?.right != null) {
    root?.let {
        it.left = TreeNode(0)
        backtracking(it, N - 1, result)
    }
//    }

//    if (root?.left != null) {
    root?.let {
        it.right = TreeNode(0)
        backtracking(it, N - 1, result)
    }
//    }

    root?.let {
        it.left = TreeNode(0)
        it.right = TreeNode(0)
        backtracking(it, N - 2, result)
    }
}

fun allPossibleFBT2(N: Int): List<TreeNode?> {
    // Recursive: build all possible FBT of leftSubTree and rightSubTree with number n
    if (N <= 0 || N % 2 == 0) return ArrayList()

    //1. if N = 3 , the number of nodes combination are as follows
    //      left    root    right
    //       1       1        1
    //--------------N = 3, res = 1----------

    //2. if N = 5 , the number of nodes combination are as follows
    //      left    root    right
    //       1       1        3 (recursion)
    //       3       1        1
    //  --------------N = 5, res = 1 + 1 = 2----------

    //3. if N = 7 , the number of nodes combination are as follows
    //      left    root    right
    //       1       1        5 (recursion)
    //       3       1        3
    //       5       1        1
    //  --------------N = 7, res = 2 + 1 + 2 = 5----------

    //4. in order to make full binary tree, the node number must increase by 2
    val res: MutableList<TreeNode?> = ArrayList()
    if (N == 1) {
        res.add(TreeNode(0))
        return res
    }
    var i = 1
    while (i < N) {
        val leftSubTrees: List<TreeNode?> = allPossibleFBT2(i)
        val rightSubTrees: List<TreeNode?> = allPossibleFBT2(N - i - 1)
        for (l in leftSubTrees) {
            for (r in rightSubTrees) {
                val root = TreeNode(0)
                root.left = l
                root.right = r
                res.add(root)
            }
        }
        i += 2
    }
    return res
}

class S {

    var memo = mutableMapOf<Int, List<TreeNode?>>()

    fun allPossibleFBT(N: Int): List<TreeNode?> {
        if (!memo.containsKey(N)) {
            val ans: MutableList<TreeNode?> = mutableListOf()

            if (N == 1) {
                ans.add(TreeNode(0))
            } else if (N % 2 == 1) {
                for (x in 0 until N) {
                    val y = N - 1 - x
                    for (left in allPossibleFBT(x)) {
                        for (right in allPossibleFBT(y)) {
                            val bns = TreeNode(0)
                            bns.left = left
                            bns.right = right
                            ans.add(bns)
                        }
                    }
                }
            }
            memo[N] = ans
        }
        return memo[N]!!
    }
}

fun TreeNode?.isFull(): Boolean =
        this == null || (this.isLeaf()) || (this.left != null && this.right != null)

fun main() {
    println(allPossibleFBT(7).joinToString("\n", transform = { it?.toValueString() ?: "" }))
}