package tree

fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
    val paths: MutableList<List<Int>> = mutableListOf()

    dfs(root, paths, emptyList())
    return paths.filter { it.sum() == targetSum }
}

private fun dfs(root: TreeNode?, allPaths: MutableList<List<Int>>, current_path: List<Int>) {
    if (root == null) return

    if (root.isLeaf()) {
        allPaths.add(current_path + root.`val`)
        return
    }

    dfs(root = root.left, allPaths = allPaths, current_path = current_path + root.`val`)
    dfs(root = root.right, allPaths = allPaths, current_path = current_path + root.`val`)
}

fun main() {
//    Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//    Output: [[5,4,11,2],[5,8,4,5]]

    val tree = TreeNode(`val` = 5).apply {
        left = TreeNode(`val` = 4).apply {
            left = TreeNode(`val` = 11).apply {
                left = TreeNode(`val` = 7)
                right = TreeNode(`val` = 2)
            }
        }
        right = TreeNode(`val` = 8).apply {
            left = TreeNode(`val` = 13)
            right = TreeNode(`val` = 4).apply {
                right = TreeNode(`val` = 1)
            }
        }
    }

    println(pathSum(tree, 22).joinToString())
}