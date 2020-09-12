package tree

import kotlin.math.abs

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 */
class Solution110 {

    private var isBalanced = true

    fun isBalanced(root: TreeNode?): Boolean {
        checkDepth(root)

        return isBalanced
    }

    private fun checkDepth(root: TreeNode?): Int {
        if (root == null) return 0

        val leftDepth = checkDepth(root.left)
        val rightDepth = checkDepth(root.right)

        if (abs(leftDepth - rightDepth) > 1) {
            isBalanced = false
        }

        return maxOf(leftDepth, rightDepth) + 1
    }
}

/** Definition for a binary tree node. */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val root = TreeNode(1).apply {
        left = null
        right = TreeNode(2).apply {
            left = null
            right = TreeNode(3)
        }
    }

    println(Solution110().isBalanced(root))
}

