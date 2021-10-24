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

//solved in ~7 min
fun middleNode2(head: ListNode?): ListNode? {
    var next = head?.next
    var mid = head

    while (next != null){
        next = next?.next?.next
        mid = mid?.next
    }

    return mid
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