package tree

import java.util.*

fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    root ?: return emptyList()

    val answer = mutableListOf<List<Int>>()
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)

    var shouldReverse = false

    while (queue.isNotEmpty()) {
        val level = mutableListOf<Int>()
        repeat(queue.size) {
            val node = queue.pop()
            level.add(node.`val`)

            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }

        if (shouldReverse){
            answer.add(level.reversed())
        } else {
            answer.add(level)
        }
        shouldReverse = !shouldReverse
    }

    return answer
}