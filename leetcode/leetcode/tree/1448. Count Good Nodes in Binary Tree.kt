package tree

fun goodNodes(root: TreeNode?): Int {
    if (root == null) return 0

    val result = IntArray(1) { 1 }
    goodNodes(root, result, root.`val`)
    return result[0]
}

private fun goodNodes(root: TreeNode?, result: IntArray, maxValue: Int) {
    root?.left?.let {
        if (it.`val` >= maxValue) {
            result[0] += 1
        }
        goodNodes(it, result, maxOf(maxValue, it.`val`))
    }
    root?.right?.let {
        if (it.`val` >= maxValue) {
            result[0] += 1
        }
        goodNodes(it, result, maxOf(maxValue, it.`val`))
    }
}

fun main() {
    val root = TreeNode(3).apply {
        left = TreeNode(1).apply {
            left = TreeNode(3)
            right = null
        }
        right = TreeNode(4).apply {
            left = TreeNode(1)
            right = TreeNode(5)
        }
    }

    println(goodNodes(root))
}