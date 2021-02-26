package linkedlist

fun reorderList(head: ListNode?) {
    if (head == null) return

    var tail: ListNode? = head

    while (tail?.next?.next != null) {
        val last = firstToLast(tail.next)
        last?.next = tail.next
        tail.next = last
        tail = last?.next
    }
}

tailrec fun firstToLast(head: ListNode?): ListNode? =
        if (head?.next?.next == null) {
            val node = head?.next
            head?.next = null
            node
        } else {
            firstToLast(head.next)
        }

fun main() {
    val list = listOf<Int>(1, 2, 3, 4, 5).toLinkedList()
    val list2 = listOf<Int>(1, 2, 3, 4).toLinkedList()
    reorderList(list)
    reorderList(list2)

    println(list?.toValueString())
    println(list2?.toValueString())
}