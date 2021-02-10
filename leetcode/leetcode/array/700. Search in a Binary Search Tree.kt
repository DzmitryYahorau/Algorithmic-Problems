package array

import tree.TreeNode

fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
    if (root == null) return null

    return when {
        (root.`val` == `val`) -> root
        (root.`val` > `val`) -> searchBST(root.left, `val`)
        else -> searchBST(root.right, `val`)
    }
}