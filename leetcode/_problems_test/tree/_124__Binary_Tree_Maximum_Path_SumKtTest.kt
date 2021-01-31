package tree

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class _124__Binary_Tree_Maximum_Path_SumKtTest{
    
    @Test
    fun test1(){

        val root = TreeNode(-10).apply {
            left = TreeNode(9)
            right = TreeNode(20).apply {
                left = TreeNode(15)
                right = TreeNode(7)
            }
        }

        val actual = maxPathSum(root)

        assertEquals(expected = 42, actual = actual)
    }
}