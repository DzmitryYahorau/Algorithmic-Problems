package tree

import java.util.*

fun isSubtree(s: TreeNode?, t: TreeNode?): Boolean {
    if (s == null) return false

    val q = LinkedList<TreeNode>()
    q.offer(s)

    while (q.isNotEmpty()) {
        val node = q.pop()

        if (equals(node, t)) {
            return true
        }

        node.right?.let {
            q.offer(it)
            if (equals(it, t)) {
                return true
            }
        }
        node.left?.let {
            q.offer(it)
            if (equals(it, t)) {
                return true
            }
        }
    }
    return false
}

fun equals(s: TreeNode?, t: TreeNode?): Boolean {
    if (s == null && t == null) return true
    return (s?.`val` == t?.`val`) && equals(s?.left, t?.left) && equals(s?.right, t?.right)
}

fun main() {
    val root = 3.toTreeNode().apply {
        left = 4.toTreeNode().apply {
            left = 1.toTreeNode()
            right = 2.toTreeNode().apply {
                left = 0.toTreeNode()
            }
        }
        right = 5.toTreeNode()
    }

    val node = 4.toTreeNode().apply {
        left = 1.toTreeNode()
        right = 2.toTreeNode()
    }

    //expected false
    println(isSubtree(root, node))
}