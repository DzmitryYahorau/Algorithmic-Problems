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
        (indexOfPrev < 0)                 -> return head.next
        (indexToDelete > nodes.lastIndex) -> nodes[indexOfPrev].next = null
        else                              -> nodes[indexOfPrev].next = nodes[indexToDelete]

    }

    return head
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}