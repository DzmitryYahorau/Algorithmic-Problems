package tree

import java.util.*

//DFS
fun minDepth(root: TreeNode?, sum: Int = 1): Int =
        when {
            (root == null) -> 0
            root.isLeaf() -> sum
            else -> {
                val leftPathSum = root.left?.let { minDepth(it, sum + 1) } ?: Int.MAX_VALUE
                val rightPathSum = root.right?.let { minDepth(it, sum + 1) } ?: Int.MAX_VALUE

                minOf(leftPathSum, rightPathSum)
            }
        }

//BFS - should be more efficient
fun minDepth(root: TreeNode?): Int {
    return if (root == null) {
        0
    } else {
        val queue: Queue<TreeNode> = LinkedList<TreeNode>()
        queue.offer(root)
        var level = 1
        var i: Int
        var N: Int
        var current: TreeNode
        while (!queue.isEmpty()) {
            N = queue.size
            i = 0
            while (i < N) {
                current = queue.poll()

                if (current.isLeaf()) return level
                if (current.left != null) queue.offer(current.left)
                if (current.right != null) queue.offer(current.right)
                i++
            }
            ++level
        }
        -1
    }
}

private fun TreeNode.isLeaf(): Boolean = (this.left == null) && (this.right == null)
