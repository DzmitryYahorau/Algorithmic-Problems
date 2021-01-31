package stack

import java.util.*

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 */
class Solution94 {
    fun inorderTraversal(root: TreeNode?): List<Int> {
       val traversal = ArrayDeque<Int>()
        inorderTraversal(root, traversal)
        return traversal.toList()
    }

    private fun inorderTraversal(node: TreeNode?, queue: ArrayDeque<Int>){
        if (node == null) return
        inorderTraversal(node.left, queue)
        queue.add(node.`val`)
        inorderTraversal(node.right, queue)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}