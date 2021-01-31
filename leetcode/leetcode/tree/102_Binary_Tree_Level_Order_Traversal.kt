package tree

import java.util.*

//my solution
fun levelOrder(root: TreeNode?): List<List<Int>> {
    root ?: return emptyList()

    val result = mutableListOf<List<Int>>()

    val level = ArrayDeque<TreeNode>()
    level.add(root)
    result.add(listOf(root.`val`))

    while (level.isNotEmpty()) {
        val nextLevel = mutableListOf<TreeNode?>()
        val level1 = mutableListOf<Int>()

        val levelsCount = level.size
        repeat(levelsCount) {
            val node = level.pop()

            node.left?.let {
                nextLevel.add(it)
                level1.add(it.`val`)
            }
            node.right?.let {
                nextLevel.add(it)
                level1.add(it.`val`)
            }
        }

        level1.takeIf { it.isNotEmpty() }?.let { result.add(it) }
        nextLevel.forEach { it?.let { level.add(it) } }
    }

    return result
}

//cleaner solution
fun levelOrder1(root: TreeNode?): List<List<Int>> {

    root ?: return emptyList()

    val answer = mutableListOf<MutableList<Int>>()
    val queue = mutableListOf<TreeNode>()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val level = mutableListOf<Int>()
        repeat(queue.size) {
            val node = queue.removeAt(0)
            level.add(node.`val`)
            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }
        answer.add(level)
    }

    return answer
}