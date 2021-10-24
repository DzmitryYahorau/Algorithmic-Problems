package linkedlist

fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    //for case where we delete first node
    val dummyNode = ListNode(0)
    dummyNode.next = head
    var prev: ListNode? = dummyNode

    while (prev?.next != null) {
        if (prev.next?.`val` == `val`) {
            //deletion - just skip current( == prev.next)
            prev.next = prev.next?.next
        } else {
            prev = prev.next
        }
    }

// return dummy node, without pointer at the beginning
    return dummyNode.next
}

// solved in 20+ min
fun removeElements2(head: ListNode?, `val`: Int): ListNode? {
    if (head == null){
        return null
    }

    var dum: ListNode? = ListNode(-1)

    dum?.next = head

    var t : ListNode? = dum

    while (t?.next != null){
        if (t?.next?.`val` == `val`){
            val temp = t?.next?.next

            t?.next = temp
        } else {
            t = t?.next
        }
    }
    return dum?.next
}