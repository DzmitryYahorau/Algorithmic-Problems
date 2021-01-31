package tree

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class _98_Is_valid_BSTKtTest {

    @Test
    fun test1() {
        val root = TreeNode(5).apply {
            left = TreeNode(1)
            right = TreeNode(4).apply {
                left = TreeNode(3)
                right = TreeNode(6)
            }
        }

        val actual = isValidBST(root)

        assertEquals(expected = false, actual = actual)
    }

    @Test
    fun test2() {
        val root = TreeNode(2).apply {
            left = TreeNode(1)
            right = TreeNode(3)
        }

        val actual = isValidBST(root)

        assertEquals(expected = true, actual = actual)
    }

    @Test
    fun test3() {
        val root = TreeNode(7).apply {
            left = TreeNode(3)
            right = TreeNode(15).apply {
                left = TreeNode(9)
                right = TreeNode(20)
            }
        }

        val actual = isValidBST(root)

        assertEquals(expected = false, actual = actual)
    }

    @Test
    fun test4() {
        val root = TreeNode(10).apply {
            left = TreeNode(5)
            right = TreeNode(15).apply {
                left = TreeNode(6)
                right = TreeNode(20)
            }
        }

        val actual = isValidBST(root)

        assertEquals(expected = true, actual = actual)
    }
}