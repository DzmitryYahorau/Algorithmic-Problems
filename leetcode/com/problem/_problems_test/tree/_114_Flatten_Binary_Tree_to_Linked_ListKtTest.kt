package tree

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class _114_Flatten_Binary_Tree_to_Linked_ListKtTest {

    @Test
    fun test1() {
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(3)
                right = TreeNode(4)
            }
            right = TreeNode(5).apply {
                right = TreeNode(6)
            }
        }

        val expected = TreeNode(1).apply {
            right = TreeNode(2).apply {
                right = TreeNode(3).apply {
                    right = TreeNode(4).apply {
                        right = TreeNode(5).apply {
                            right = TreeNode(6)
                        }
                    }
                }
            }

        }


        flatten(root)
        assertEquals(actual = root.toValueString(), expected = expected.toValueString())
    }
}
