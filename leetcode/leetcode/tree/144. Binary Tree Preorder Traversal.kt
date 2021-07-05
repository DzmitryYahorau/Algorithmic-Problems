package tree

fun preorderTraversal(root: TreeNode?): List<Int> {
    val result: MutableList<Int> = mutableListOf()
    preorderTraversal(root, result)

    return result
}

fun preorderTraversal(root: TreeNode?, result: MutableList<Int>) {
    root?.`val`?.let { result.add(it) }
    root?.left?.let { preorderTraversal(it, result) }
    root?.right?.let { preorderTraversal(it, result) }
}