package linkedlist

fun swapPairs(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    val next = head.next

    head.next = swapPairs(head.next?.next)
    next?.next = head

    return next
}

fun main() {

//    [1,2,3,4]

    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)

    node1.next = node2
    node2.next = node3
    node3.next = node4

    println(swapPairs(node1).toString())
}