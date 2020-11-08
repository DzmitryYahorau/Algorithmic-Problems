package tree

fun findTarget(
        root: TreeNode?,
        k: Int,
        nodes: MutableMap<Int, Int> = mutableMapOf()
): Boolean {
    if (root == null) return false

    val leftContains = findTarget(root.left, k, nodes)

    val currContains = nodes[root.`val` - k] != null
    nodes[-root.`val`] = root.`val`
    val rightContains = findTarget(root.right, k, nodes)

    return leftContains || currContains || rightContains
}

fun main() {
    val root = TreeNode(5).apply {
        left = TreeNode(3).apply {
            left = TreeNode(2)
            right = TreeNode(4)
        }
        right = TreeNode(6).apply {
            right = TreeNode(7)
        }
    }

    findTarget(root, 28).also { print(it) }
}