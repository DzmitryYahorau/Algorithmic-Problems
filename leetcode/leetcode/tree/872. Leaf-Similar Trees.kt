package tree

fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
    val root1_leaves = mutableListOf<Int>()
    val root2_leaves = mutableListOf<Int>()

    dfs_leaves(root1, root1_leaves)
    dfs_leaves(root2, root2_leaves)

    return root1_leaves == root2_leaves
}

fun dfs_leaves(node: TreeNode?, result: MutableList<Int>) {
    if (node?.isLeaf() == true) {
        result.add(node.`val`)
        return
    }

    node?.left?.let { dfs_leaves(it, result) }
    node?.right?.let { dfs_leaves(it, result) }
}