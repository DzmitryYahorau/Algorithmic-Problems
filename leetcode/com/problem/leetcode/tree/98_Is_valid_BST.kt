package tree

fun isValidBST(
        root: TreeNode?,
        minValue: Long = Long.MIN_VALUE,
        maxValue: Long = Long.MAX_VALUE
): Boolean =
        when {
            (root == null) -> true
            (root.`val` >= maxValue) || (root.`val` <= minValue) -> false
            else -> isValidBST(root.left, minValue, root.`val`.toLong()) && isValidBST(root.right, root.`val`.toLong(), maxValue)
        }