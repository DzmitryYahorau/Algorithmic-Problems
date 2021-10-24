package linkedlist

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head == null) return null

    val nodes = mutableListOf<ListNode>()
    var temp = head
    while (temp != null) {
        nodes.add(temp)
        temp = temp.next
    }

    val indexOfPrev = (nodes.size - n - 1)
    val indexToDelete = (indexOfPrev + 2)

    when {
        (indexOfPrev < 0) -> return head.next
        (indexToDelete > nodes.lastIndex) -> nodes[indexOfPrev].next = null
        else -> nodes[indexOfPrev].next = nodes[indexToDelete]

    }

    return head
}

//Another solution with one time visiting of nodes.
fun removeNthFromEnd2(head: ListNode?, n: Int): ListNode? {
    if (head == null || n == 0) return head
    var node = head
    val previousNode = ListNode(0)
    previousNode.next = node
    var start = previousNode
    var end = previousNode
    //smart move - reverse the indexing
    var windowCount = n - 1
    while (node?.next != null && end.next != null) {
        if (--windowCount == 0) {
            end = node
        } else if (windowCount < 0) {
            end = end.next!!
            start = start.next!!
        }
        node = node.next
    }
    start.next = start.next?.next
    return previousNode.next
}

fun removeNthFromEnd3(head: ListNode?, n: Int): ListNode? {
    var p: ListNode? = head
    var count = 1
    while (p?.next != null) {
        p = p.next
        count++
    }

    var steps = count - n
    val dummy = ListNode(0)
    dummy.next = head
    var t: ListNode? = dummy

    while (steps > 0) {
        t = t?.next
        steps--
    }

    val temp = t?.next?.next

    t?.next = temp

    return dummy.next
}