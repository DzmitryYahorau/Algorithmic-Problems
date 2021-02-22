package linkedlist

fun middleNode(head: ListNode?): ListNode? {

    var fast = head
    var slow = fast

    while (fast?.next != null) {
        //head moves 2x times faster (head.next?.next) vs (midPrev.next),
        //so when head will be at the end, prev  will be on the middle
        slow = slow?.next
        fast = fast.next?.next
    }
    return slow
}

fun main() {
    val root = ListNode(`val` = 4).apply {
        next = ListNode(2).apply {
            next = ListNode(1).apply {
                next = ListNode(3)
            }
        }
    }

    println(middleNode(root).toString())
}