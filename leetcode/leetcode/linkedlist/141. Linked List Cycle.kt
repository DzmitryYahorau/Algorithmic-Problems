package linkedlist

fun hasCycle(head: ListNode?): Boolean {
    if (head == null) return false

    var fastNode: ListNode? = head.next
    var slowNode: ListNode? = head

    while (slowNode != fastNode) {
        if (slowNode == null || fastNode == null) {
            return false
        }

        fastNode = fastNode.next?.next
        slowNode = slowNode.next
    }

    return true
}