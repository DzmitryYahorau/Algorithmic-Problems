package tree

fun invertTree(root: TreeNode?): TreeNode? {
    val right = root?.right
    root?.right = invertTree(root?.left)
    root?.left = invertTree(right)
    return root
}