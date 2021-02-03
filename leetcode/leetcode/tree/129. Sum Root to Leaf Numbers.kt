package tree

fun sumNumbers(root: TreeNode?): Int {
    if (root == null) return 0

    val paths = mutableListOf<List<Int>>()
    getPaths(root, paths, mutableListOf())

    return paths.map { it.joinToString("").toInt() }.sum()
}

private fun getPaths(node: TreeNode?, paths: MutableList<List<Int>>, currentPath: List<Int>) {
    if (node == null) return

    if (node.isLeaf()) {
        paths.add(currentPath + node.`val`)
        return
    }

    getPaths(node = node.left, paths = paths, currentPath = currentPath + node.`val`)
    getPaths(node = node.right, paths = paths, currentPath = currentPath + node.`val`)
}

fun main() {
    val tree = TreeNode(`val` = 4).apply {
        left = TreeNode(`val` = 9).apply {
            left = TreeNode(`val` = 5)
            right = TreeNode(`val` = 1)
        }
        right = TreeNode(`val` = 0)
    }
    println(sumNumbers(tree))
}
