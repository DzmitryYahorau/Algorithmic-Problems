package tree

fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    if (root1 == null && root2 == null) return null

    return TreeNode((root1?.`val` ?: 0) + (root2?.`val` ?: 0)).apply {
        left = mergeTrees(root1?.left, root2?.left)
        right = mergeTrees(root1?.right, root2?.right)
    }
}