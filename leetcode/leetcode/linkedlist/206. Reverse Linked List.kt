package linkedlist

fun reverseList(head: ListNode?): ListNode? {
    head ?: return null

    val list = mutableListOf<ListNode>()

    var tail = head

    while (tail != null){
        list.add(tail)
        tail = tail.next
    }

    if (list.size == 1) return list.first()

    for (i in list.lastIndex downTo 1){
        list[i].next = list[i - 1]
    }
    list[0].next = null

    return list.first()
}

//cleaner iterative solution
fun reverseList2(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var curr = head
    while (curr != null) {
        val nextTemp = curr.next
        curr.next = prev
        prev = curr
        curr = nextTemp
    }
    return prev
}