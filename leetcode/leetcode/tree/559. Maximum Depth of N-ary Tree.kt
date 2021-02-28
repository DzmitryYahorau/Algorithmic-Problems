package tree

import java.util.*

typealias Node = NNode

fun maxDepth(root: Node?, result: Int = 0): Int {
    if (root == null) return result

    var count = result + 1

    val q: Queue<Node> = LinkedList()
    q.offer(root)

    while (q.isNotEmpty()) {
        val node = q.poll()

        node.children.filterNotNull().forEach {
            count = maxOf(count, maxDepth(it, result + 1))
        }
    }

    return count
}

class NNode(var `val`: Int) {
    var children: List<Node?> = listOf()
}