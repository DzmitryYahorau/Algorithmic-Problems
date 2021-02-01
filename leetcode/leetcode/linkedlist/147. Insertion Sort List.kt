package linkedlist

fun insertionSortList(head: ListNode?): ListNode? {
    val sorted = ListNode(0)

    var pre: ListNode?
    var current: ListNode? = head

    while (current != null) {
        pre = sorted

        while (pre?.next != null && pre.next!!.`val` < current.`val`) {
            pre = pre.next
        }

        val next = current.next
        current.next = pre?.next
        pre?.next = current
        current = next
    }

    return sorted.next
}

fun main() {
    val node1 = ListNode(111)
    val node2 = ListNode(20)
    val node3 = ListNode(13)
    val node4 = ListNode(4)

    node1.next = node2
    node2.next = node3
    node3.next = node4

    println(insertionSortList(node1))
}