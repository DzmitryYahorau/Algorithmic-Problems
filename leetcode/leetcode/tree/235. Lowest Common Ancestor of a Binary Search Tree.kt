package tree

private var res: TreeNode? = null

fun lowestCommonAncestorInBST(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (p == null || q == null) return null
    lowestInBST(root, p, q)
    return res
}

fun lowestInBST(root: TreeNode?, p_node: TreeNode, q_node: TreeNode): TreeNode? {
    if (root == null) {
        return null
    }

    val current = root.`val`
    val p = p_node.`val`
    val q = q_node.`val`

    return when {
        (current > p) && current > q -> lowestCommonAncestor(root.left, p_node, q_node)
        (current < p) && current < q -> lowestCommonAncestor(root.right, p_node, q_node)
        else -> root
    }
}

fun isSameTree2(p: TreeNode?, q: TreeNode?): Boolean {
    return (p?.`val` == q?.`val`) && isSameTree2(p?.left, q?.left) && isSameTree2(p?.right, q?.right)
}

fun main() {
    lowestCommonAncestorInBST(
            TreeNode(6).apply {
                left = TreeNode(2).apply {
                    left = TreeNode(0)
                    right = TreeNode(4).apply {
                        left = TreeNode(3)
                        right = TreeNode(5)
                    }
                }
                right = TreeNode(8).apply {
                    left = TreeNode(7)
                    right = TreeNode(9)
                }
            },
            TreeNode(2),
            TreeNode(4)

    )
}