package tree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


internal class _111_Minimum_Depth_of_Binary_TreeKtTest {

    @Test
    fun test1() {
        val root = TreeNode(2).apply {
            right = TreeNode(3).apply {
                right = TreeNode(4).apply {
                    right = TreeNode(5).apply {
                        right = TreeNode(6)
                    }
                }
            }
        }
        val actual = minDepth(root)

        assertEquals(actual = actual, expected = 5)
    }
}