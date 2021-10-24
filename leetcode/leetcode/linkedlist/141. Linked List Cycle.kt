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

//took ~15 min
fun hasCycle2(head: ListNode?): Boolean {
    if (head == null) return false
    if (head?.next == null) return false

    var slow : ListNode? = head?.next
    var fast : ListNode? = head?.next?.next

    while (fast != null){
        if (slow == fast){
            return true
        }
        fast = fast?.next?.next
        slow = slow?.next
    }
    return false
}