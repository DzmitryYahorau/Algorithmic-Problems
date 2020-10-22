package linkedlist

fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head == null) return null
    val list = mutableListOf<ListNode>()
    var h = head

    var i = head
    while (i != null) {
        list.add(i)
        i = i.next
    }

    if (list.size == 1) return head

    // don't need to move all k times, just k % list.size !
    repeat(k % list.size) {
        list.add(0, list[list.lastIndex])
        list.removeAt(list.lastIndex)

        list[0].next = h
        h = list[0]
        list[list.lastIndex].next = null
    }
    return h
}

