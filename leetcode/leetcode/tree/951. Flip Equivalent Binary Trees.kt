package tree

fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
    if (root1 == null && root2 == null) return true

    return root1?.`val` == root2?.`val`
            && (flipEquiv(root1?.left, root2?.left) || flipEquiv(root1?.right, root2?.left) || flipEquiv(root1?.left, root2?.right))
}