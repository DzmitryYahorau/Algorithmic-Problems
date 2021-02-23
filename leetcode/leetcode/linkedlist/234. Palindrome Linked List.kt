package linkedlist

import java.util.*

fun isPalindrome(head: ListNode?): Boolean {
    head ?: return false

    val stack = Stack<Int>()

    var p = head
    var mid = middleNode(head)

    while (mid != null){
        stack.push(mid.`val`)
        mid = mid.next
    }

    while (stack.isNotEmpty()){
        if (stack.pop() != p?.`val`){
            return false
        }
        p = p?.next
    }

    return true
}

internal class `234 Palindromic linked list - recursive smart solution ` {
    var ref: ListNode? = null

    fun isPalindrome(head: ListNode?): Boolean {
        ref = head
        return check(head)
    }

    fun check(node: ListNode?): Boolean {
        //here is a trick how we go back, so we can traverse nodes in reversed order!!!
        if (node == null) return true
        val ans = check(node.next)
        val isEqual = ref?.`val` == node.`val`
        ref = ref?.next
        return ans && isEqual
    }
}

fun main() {
    println(isPalindrome(listOf(1, 2, 2, 1).toLinkedList()))
}