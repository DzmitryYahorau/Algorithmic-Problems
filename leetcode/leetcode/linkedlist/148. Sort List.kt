package linkedlist

fun sortList(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    val (firstHalf, secondHalf) = divideInTheMiddle(head)

    return mergeNodes(sortList(firstHalf), sortList(secondHalf))
}

fun mergeNodes(node1: ListNode?, node2: ListNode?): ListNode? {
    var a = node1
    var b = node2
    var tail: ListNode? = ListNode(0)
    val result: ListNode? = tail

    while (a != null || b != null) {
        when {
            (a != null && b == null) -> {
                tail?.next = a
                return result?.next
            }
            (a == null && b != null) -> {
                tail?.next = b
                return result?.next
            }
            (a != null && b != null) && (a.`val` <= b.`val`) -> {
                tail?.next = a
                tail = a
                a = a.next
            }
            else -> {
                tail?.next = b
                tail = b
                b = b?.next
            }
        }
    }
    return result?.next
}

fun divideInTheMiddle(head: ListNode?): Pair<ListNode?, ListNode?> {
    var fast = head
    var slow = fast
    var prev = head

    while (fast?.next != null) {
        prev = slow
        slow = slow?.next
        fast = fast.next?.next
    }

    prev?.next = null

    return head to slow
}

fun main() {
    val root = ListNode(`val` = 4).apply {
        next = ListNode(2).apply {
            next = ListNode(1).apply {
                next = ListNode(3)
            }
        }
    }



    println(sortList(root))
}

