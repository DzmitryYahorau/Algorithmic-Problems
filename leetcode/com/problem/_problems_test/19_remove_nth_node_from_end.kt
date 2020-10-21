import linkedlist.removeNthFromEnd
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RemoveNthNodeFromEndTest {

    @Test
    fun test1() {
        val head = linkedlist.ListNode(1)
        val actual = removeNthFromEnd(head, 1)
        assertEquals(actual, null)
    }

    @Test
    fun test2() {
        val head = linkedlist.ListNode(1)
        val a2 = linkedlist.ListNode(2)
        val a3 = linkedlist.ListNode(3)
        val a4 = linkedlist.ListNode(4)
        val a5 = linkedlist.ListNode(5)


        head.next = a2
        a2.next = a3
        a3.next = a4
        a4.next = a5
        val actual = removeNthFromEnd(head, 2)

        val str = StringBuilder()
        var next = actual
        while (next != null) {
            str.append(next.`val`)
            next = next.next
        }
        val expected = "1235"
        assertEquals(expected = expected, actual = str.toString())
    }
}