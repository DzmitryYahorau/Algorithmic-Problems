package tree

fun diameterOfBinaryTree(root: TreeNode?): Int {
    if (root == null) return 0

    val diameter = IntArray(1)
    length(root, diameter)

    return diameter[0]
}

fun length(node: TreeNode?, diameter: IntArray): Int {
    if (node == null) {
        return 0
    }

    val leftHeight = length(node.left, diameter)
    val rightHeight = length(node.right, diameter)

    diameter[0] = maxOf(diameter[0], leftHeight + rightHeight)

    return 1 + maxOf(leftHeight, rightHeight)
}