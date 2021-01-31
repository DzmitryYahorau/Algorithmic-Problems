package tree

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class _112_Path_SumKtTest {

    /**
                  5
                 / \
                4   8
               /   / \
             11   13  4
            /  \       \
          7    2       1
     */
    @Test
    fun test1() {
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

        assertEquals(actual = hasPathSum(tree, 22), expected = true)
    }
}