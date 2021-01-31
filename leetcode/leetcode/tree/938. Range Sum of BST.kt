package tree

fun rangeSumBST(root: TreeNode?, low: Int, high: Int, sum: Int = 0): Int {
    if (root == null) return 0

    val leftSum = rangeSumBST(root.left, low, high, sum)
    val midSum = if (root.`val` in low..high) root.`val` else 0
    val rightSum = rangeSumBST(root.right, low, high, sum)

    return leftSum + midSum + rightSum
}