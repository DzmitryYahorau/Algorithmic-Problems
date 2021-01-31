package linkedlist

fun deleteDuplicates(head: ListNode?): ListNode? {
    var next = head

    while (next?.next != null) {
        if (next.`val` == next.next?.`val`) {
            next.next = next.next?.next
        } else {
            next = next.next
        }
    }
    return head
}