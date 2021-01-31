package linkedlist

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class _61_Rotate_ListKtTest {

    @Test
    fun test1() {

        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(4)
        val node5 = ListNode(5)

        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5

        val node = rotateRight(node1, 2)

        val stB = StringBuilder()

        var n = node
        while (n != null) {
            stB.append(n.`val`)
            n = n.next
        }

        assertEquals(expected = listOf(4, 5, 1, 2, 3).joinToString(), actual = stB.toList().joinToString())
    }
}