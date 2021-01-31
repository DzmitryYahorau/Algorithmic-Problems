package tree

import java.util.*

fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
    root ?: return emptyList()

    val result = mutableListOf<List<Int>>()
    val queue = LinkedList<TreeNode>()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val level = mutableListOf<Int>()

        repeat(queue.size) {
            val node = queue.pop()
            level.add(node.`val`)

            node?.left?.let { queue.add(it) }
            node?.right?.let { queue.add(it) }
        }
        result.add(0, level)
    }

    return result
}