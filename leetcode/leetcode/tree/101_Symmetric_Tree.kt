package tree

import java.util.*

//my solution using bfs
fun isSymmetric(root: TreeNode?): Boolean {
    root ?: return false

    val queue = LinkedList<TreeNode?>()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val level = mutableListOf<Int?>()

        repeat(queue.size) {
            val node = queue.pop()
            level.add(node?.left?.`val`)
            level.add(node?.right?.`val`)
            node?.left?.let {
                queue.add(node.left)
            }
            node?.right?.let { queue.add(node.right) }
        }

        if (level.size > 1) {
            while (level.isNotEmpty()) {
                val first = level.removeAt(0)
                val last = level.removeAt(level.lastIndex)
                if (first != last) return false
            }
        }
    }

    return true
}

// cleaner solution
fun isSymmetric1(root: TreeNode?): Boolean = isMirror(root, root)

fun isMirror(t1: TreeNode?, t2: TreeNode?): Boolean =
        when {
            (t1 == null && t2 == null) -> true
            (t1 == null || t2 == null) -> false
            else -> (t1.`val` == t2.`val`) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right)
        }