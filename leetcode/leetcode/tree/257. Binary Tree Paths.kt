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
