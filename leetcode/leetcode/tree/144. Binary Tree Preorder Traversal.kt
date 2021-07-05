package tree

import java.util.*

/**
 * Recursive solution
 */
fun preorderTraversal(root: TreeNode?): List<Int> {
    val result: MutableList<Int> = mutableListOf()
    preorderTraversal(root, result)

    return result
}

fun preorderTraversal(root: TreeNode?, result: MutableList<Int>) {
    root?.`val`?.let { result.add(it) }
    root?.left?.let { preorderTraversal(it, result) }
    root?.right?.let { preorderTraversal(it, result) }
}

/**
 * Iterative solution
 */
fun preorderTraversalIterative(root: TreeNode?): List<Int> {
    root ?: return emptyList()
    val result: MutableList<Int> = mutableListOf()

    val stack = Stack<TreeNode>()
    stack.push(root)
    while (stack.isNotEmpty()){
        val node = stack.pop()
        result.add(node.`val`)

        node.right?.let { stack.push(it) }
        node.left?.let { stack.push(it) }
    }
    return result
}