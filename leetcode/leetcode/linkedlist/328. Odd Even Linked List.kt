package linkedlist

fun oddEvenList(head: ListNode?): ListNode? {
    if (head == null) return null
    var odd = head
    var even: ListNode? = ListNode(0)
    val resultOdd: ListNode = odd
    val evenResult: ListNode? = even

    while (odd != null) {
        val evenNext = odd.next
        val oddNext = odd.next?.next

        even?.next = evenNext
        even = evenNext

        if (oddNext == null) {
            odd.next = evenResult?.next
            return resultOdd
        } else {
            odd.next = oddNext
            odd = oddNext
        }
    }

    return resultOdd
}


fun main() {
    println(oddEvenList(listOf(2, 1, 3, 5, 6, 4, 7).toLinkedList())?.toValueString())
    println(oddEvenList(listOf(1, 2, 3, 4, 5).toLinkedList())?.toValueString())
}
