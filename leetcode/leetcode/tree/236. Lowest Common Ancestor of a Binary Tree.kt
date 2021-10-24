package tree

/**
 * definition of LCA on Wikipedia:
 * “The lowest common ancestor
 * is defined between two nodes p and q
 * as the lowest node in T
 * that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 */

var result: TreeNode? = null

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    lowest(root, p, q)
    return result
}

// #didn't solve
//trick was to count nodes,
fun lowest(root: TreeNode?, p: TreeNode?, q: TreeNode?): Boolean {
    if (root == null) return false

    val left = if (lowest(root.left, p, q)) 1 else 0
    val right = if (lowest(root.right, p, q)) 1 else 0
    val mid = if (root == p || root == q) 1 else 0

    if (mid + left + right >= 2) {
        result = root
    }
    return (mid + left + right > 0)
}