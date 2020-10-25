package tree

fun flatten(root: TreeNode?) {
    if (root?.isLeaf() == true) return

    root?.left?.let { flatten(root.left) }
    root?.right?.let { flatten(root.right) }

    val oldRight = root?.right
    root?.left ?: return

    var tail = root.left
    while (tail?.right != null) {
        tail = tail.right
    }

    root.right = root.left
    root.left = null
    tail?.right = oldRight
}