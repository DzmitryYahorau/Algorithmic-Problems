package tree

fun maxDepth(root: TreeNode?, sum: Int = 0): Int =
        if (root == null) {
            sum
        } else {
            val leftSum = maxDepth(root.left, sum)
            val rightSum = maxDepth(root.right, sum)
            1 + (maxOf(leftSum, rightSum))
        }