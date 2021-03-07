package tree

import java.util.*

class Solution106 {

    private var mapOfIndexes: Map<Int, Int> = mapOf()

    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        if (postorder.isEmpty() || inorder.isEmpty()) return null

        mapOfIndexes = inorder.mapIndexed { index, value -> value to index }.toMap()

        return buildTree(0, postorder.lastIndex, LinkedList(postorder.toList()))
    }

    private fun buildTree(lo: Int, hi: Int, postorder: LinkedList<Int>): TreeNode? {
        if (lo > hi) {
            return null
        }

        val root = postorder.removeLast().toTreeNode()

        val midIndex = mapOfIndexes[root.`val`] ?: return null

        root.right = buildTree(midIndex + 1, hi, postorder)
        root.left = buildTree(lo, midIndex - 1, postorder)

        return root
    }
}

fun main() {
    println(Solution106().buildTree(inorder = intArrayOf(9, 3, 15, 20, 7), postorder = intArrayOf(9, 15, 7, 20, 3))?.toValueString())
    println(Solution106().buildTree(inorder = intArrayOf(2, 1), postorder = intArrayOf(2, 1))?.toValueString())
    println(Solution106().buildTree(inorder = intArrayOf(1, 2), postorder = intArrayOf(2, 1))?.toValueString())

    println(Solution106().buildTree(inorder = intArrayOf(3, 2, 1), postorder = intArrayOf(3, 2, 1))?.toValueString())
}
