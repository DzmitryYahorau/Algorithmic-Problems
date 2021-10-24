package tree

import java.util.*

fun largestValues(root: TreeNode?): List<Int> {
    root ?: return emptyList()

    val queue : Queue<TreeNode> = LinkedList<TreeNode>()

    queue.add(root)

    val levelsMax = mutableListOf<Int>()

    while(queue.isNotEmpty()){
        var levelMax = Int.MIN_VALUE

        repeat(queue.size){
            val node = queue.poll()

            levelMax = maxOf(node.`val`, levelMax)

            node.left?.let{ queue.add(it) }
            node.right?.let{ queue.add(it) }
        }
        levelsMax.add(levelMax)
    }
    return levelsMax
}