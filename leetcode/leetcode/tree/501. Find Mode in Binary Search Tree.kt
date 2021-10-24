package tree

//#solved #extra_space
fun findMode(root: TreeNode?): IntArray {
    root ?: return IntArray(1) { 0 }

    val result = mutableMapOf<Int, Int>()

    find(root, result)

    val mode = result.maxBy { it.value }?.value

    return result.filterValues { it == mode }.map { it.value }
            .toTypedArray().toIntArray()
}

private fun find(curr: TreeNode?, result: MutableMap<Int, Int>) {
    curr ?: return

    val freq = result.getOrDefault(curr.`val`, 0)

    result[curr.`val`] = freq + 1

    find(curr.left, result)
    find(curr.right, result)
}