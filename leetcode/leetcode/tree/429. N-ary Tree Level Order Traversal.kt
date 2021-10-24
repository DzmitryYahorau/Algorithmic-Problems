package tree

import java.util.*

//level order traversal from #102
fun levelOrder(root: NNode?): List<List<Int>> {
    root ?: return emptyList()

    val queue: Queue<NNode> = LinkedList()

    queue.add(root)

    val result = mutableListOf<List<Int>>()

    while (queue.isNotEmpty()) {
        val level = mutableListOf<Int>()

        repeat(queue.size) {
            val node = queue.poll()
            level.add(node.`val`)

            queue.addAll(node.children)
        }
        result.add(level)
    }
    return result
}