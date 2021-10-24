package tree

fun binaryTreePaths(root: TreeNode?): List<String> =
        when {
            (root == null) -> emptyList()
            (root.isLeaf()) -> listOf(root.`val`.toString())
            else -> {
                val left = binaryTreePaths(root.left)
                val right = binaryTreePaths(root.right)

                (left + right).map{ (root.`val`.toString() + "->" + it) }
            }
        }

//second try #solved #timeout
fun binaryTreePaths(
        root: TreeNode?,
        sb: String = "",
        res: MutableList<String> = mutableListOf<String>()
): List<String> {

    if (root.isLeaf()){
        res.add(sb + root?.`val`)
        return res
    }

    root?.let {
        val path = "$sb${it.`val`}->"

        it.left?.let { binaryTreePaths(it, path, res) }
        it.right?.let { binaryTreePaths(it, path, res) }
    }

    return res
}
