package linkedlist

import org.junit.jupiter.api.Test

import kotlin.test.assertEquals

internal class _148__Sort_ListKtTest {

    @Test
    fun `getMiddle test1`() {
        val first = ListNode(`val` = 4).apply { next = ListNode(2) }
        val second = ListNode(1).apply { next = ListNode(3) }
        val root = first.apply { next = second }

        val a = divideInTheMiddle(root)

        assertEquals(actual = a.first, expected = first)
        assertEquals(actual = a.second, expected = second)
    }

    @Test
    fun `merge test1`() {
        val first = ListNode(`val` = 4).apply { next = ListNode(2) }
        val second = ListNode(1).apply { next = ListNode(3) }
        val root = second.apply { next = first }

        val a = mergeNodes(first, second)

        assertEquals(actual = a, expected = root)
    }

    @Test
    fun `merge test2`() {
        val first = ListNode(`val` = 4)
        val a = sortList(first)

        assertEquals(actual = a, expected = first)
    }

    @Test
    fun `merge test3, null value`() {
        val first = null
        val a = sortList(first)

        assertEquals(actual = a, expected = first)
    }
}