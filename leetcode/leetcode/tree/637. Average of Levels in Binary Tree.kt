package tree

import java.util.*

//traversal same as in #102, just count average
fun averageOfLevels(root: TreeNode?): DoubleArray {
    root ?: return doubleArrayOf()

    val levelAverages = mutableListOf<Double>()

    val queue : Queue<TreeNode> = LinkedList<TreeNode>()
    queue.add(root)

    while (!queue.isEmpty()){
        val level = mutableListOf<Double>()
        val count = queue.size

        repeat(queue.size){
            val node = queue.poll()
            level.add(node.`val`.toDouble())

            node.left?.let{
                queue.add(it)
            }
            node.right?.let{
                queue.add(it)
            }
        }
        val average = level.reduce { acc, i -> acc+i } / count

        levelAverages.add(average)
    }

    return levelAverages.toDoubleArray()
}