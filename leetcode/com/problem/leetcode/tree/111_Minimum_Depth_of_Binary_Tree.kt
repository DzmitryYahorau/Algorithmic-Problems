package tree

fun minDepth(root: TreeNode?, sum: Int = 1): Int =
        when {
            (root == null) -> 0
            root.isLeaf() -> sum
            else -> {
                val leftPathSum = root.left?.let { minDepth(it, sum + 1) } ?: Int.MAX_VALUE
                val rightPathSum = root.right?.let { minDepth(it, sum + 1) } ?: Int.MAX_VALUE

                minOf(leftPathSum, rightPathSum)
            }
        }

private fun TreeNode.isLeaf(): Boolean = (this.left == null) && (this.right == null)
