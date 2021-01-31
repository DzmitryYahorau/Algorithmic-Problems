package tree

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_TraversalKtTest{

    @Test
    fun test1(){
        val inorder  = intArrayOf(3,9,20,15,7)
        val preorder = intArrayOf(9,3,15,20,7)

        val actual = buildTree(preorder, inorder)

        assertEquals(expected= "3,9,20,null,null,15,7", actual = actual?.toValueString())
    }
}