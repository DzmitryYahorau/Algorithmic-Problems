package tree

import kotlin.math.min

var min : Int = Integer.MAX_VALUE
var prevNode: TreeNode? = null

fun getMinimumDifference(root: TreeNode?): Int {
    if (root == null) return min

    getMinimumDifference(root.left)

    prevNode?.let {
        min = min(min, root.`val` - it.`val`)
    }

    prevNode = root

    getMinimumDifference(root.right)

    return min
}

fun main() {
    println(getMinimumDifference(
            TreeNode(236).apply {
                left = TreeNode(104).apply {
                    right = TreeNode(227)
                }
                right = TreeNode(701).apply {
                    right = TreeNode(901)
                }
            }
    ))
}