fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var i: ListNode? = l1
    var j: ListNode? = l2

    var root: ListNode? = null

    while (i != null || j != null) {
        val first = i?.`val`
        val second = j?.`val`
        var value = 0
        when {
            (first != null && second == null) -> {
                value = first
                i = i?.next
            }
            (first == null && second != null) -> {
                value = second
                j = j?.next
            }
            (first.orZERO() <= second.orZERO()) -> {
                value = first.orZERO()
                i = i?.next
            }
            (first.orZERO() > second.orZERO()) -> {
                value = second.orZERO()
                j = j?.next
            }
        }
        root = root insertNode ListNode(value)
    }

    return root
}

private infix fun ListNode?.insertNode(node: ListNode): ListNode {
    if (this == null) {
        return node
    }
    var oldRoot: ListNode? = this

    while (oldRoot?.next != null) {
        oldRoot = oldRoot.next
    }

    oldRoot?.next = node

    return this
}

private fun Int?.orZERO(): Int = this ?: 0

fun main() {
    val li1 = ListNode(1).apply { next = ListNode(2).apply { next = ListNode(4) } }
    val li2 = ListNode(1).apply { next = ListNode(3).apply { next = ListNode(4) } }

    var result = mergeTwoLists(li1, li2)

    while (result != null) {
        println(result.toString())
        result = result.next
    }

}