package tree

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? =
        buildTree(
                preorder = preorder,
                preStart = 0,
                preEnd = preorder.size - 1,
                inStart = 0,
                inEnd = inorder.size - 1,
                indexMap = inorder.mapIndexed { index: Int, i: Int -> i to index }.toMap()
        )

fun buildTree(
        preorder: IntArray,
        preStart: Int,
        preEnd: Int,
        inStart: Int,
        inEnd: Int,
        indexMap: Map<Int, Int>
): TreeNode? {
    if (preStart > preEnd || inStart > inEnd) return null

    val root = preorder[preStart].toTreeNode()
    val inRoot = indexMap[root.`val`] ?: return null
    val numsLeft = inRoot - inStart

    root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inStart, inRoot - 1, indexMap)
    root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inRoot + 1, inEnd, indexMap)
    return root
}

fun main() {

    val preorder = intArrayOf(3, 9, 20, 15, 7)
    val inorder = intArrayOf(9, 3, 15, 20, 7)

    val actual = buildTree(preorder, inorder)
    println("expected= [3,9,20,null,null,15,7],actual= ${actual?.toValueString()}")
}