package tree

import java.util.*

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
private class BSTIterator(root: TreeNode?) {

    val stack = Stack<Int>()

    init {
        val items = mutableListOf<Int>()
        toList(root, items)

        for (i in items.lastIndex downTo 0) {
            stack.push(items[i])
        }
    }

    private fun toList(node: TreeNode?, values: MutableList<Int>) {
        if (node == null) return

        toList(node.left, values)
        values.add(node.`val`)
        toList(node.right, values)
    }

    /** @return the next smallest number */
    fun next(): Int = stack.pop()

    /** @return whether we have a next smallest number */
    fun hasNext(): Boolean = stack.isNotEmpty()

}

fun main() {
    val root = TreeNode(7).apply {
        left = TreeNode(3)
        right = TreeNode(15).apply {
            left = TreeNode(9)
            right = TreeNode(20)
        }
    }

    val iterator = BSTIterator(root = root)

    println(iterator.next());    // return 3
    println(iterator.next());    // return 7
    println(iterator.hasNext()); // return true
    println(iterator.next());    // return 9
    println(iterator.hasNext()); // return true
    println(iterator.next());    // return 15
    println(iterator.hasNext()); // return true
    println(iterator.next());    // return 20
    println(iterator.hasNext()); // return false
}


/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */