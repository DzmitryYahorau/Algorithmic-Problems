package linkedlist

class Solution237 {

    class ListNode(
            var `val`: Int?,
            var next: ListNode?
    )

    fun deleteNode(node: ListNode?) {
        node?.`val` = node?.next?.`val`
        node?.next = node?.next?.next
    }
}