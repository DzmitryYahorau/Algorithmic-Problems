package tree

fun sumOfLeftLeaves(root: TreeNode?, isLeft: Boolean = false): Int =
        when {
            root == null -> 0
            root.isLeaf() && isLeft -> root.`val`
            root.isLeaf() && !isLeft -> 0
            else -> sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false)
        }