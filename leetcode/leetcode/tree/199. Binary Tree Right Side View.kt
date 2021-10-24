package tree

import java.util.*

//same as #102
fun rightSideView(root: TreeNode?): List<Int> {
    root ?: return emptyList()

    val queue: Queue<TreeNode> = LinkedList()

    queue.offer(root)

    val result = mutableListOf<Int>()

    while (queue.isNotEmpty()) {

        var levelLast = 0
        val levelSize = queue.size

        for(i in 0 until levelSize){
            val node = queue.poll()
            if (i == levelSize-1){
                levelLast = node.`val`
            }

            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }

        result.add(levelLast)
    }
    return result
}