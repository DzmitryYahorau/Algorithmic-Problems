/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
data class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var result: ListNode? = null

        var extra = 0
        var i1 = l1
        var i2 = l2

        while (i1 != null || i2 != null || extra != 0) {

            val sum = i1?.`val`.orZero() + i2?.`val`.orZero() + extra
            extra = 0

            val nextNode = if (sum >= 10) {
                extra++
                ListNode((sum % 10))
            } else {
                ListNode(sum)
            }

            //put nextNode as last in result
            if (result == null) {
                result = nextNode
            } else {
                enqueue(result, nextNode)
            }

            if (i1 != null) {
                i1 = i1.next
            }
            if (i2 != null) {
                i2 = i2.next
            }
        }

        return result
    }

    private fun enqueue(result: ListNode?, newNode: ListNode) {
        if (result?.next == null) {
            result?.next = newNode
        } else {
            enqueue(result.next, newNode)
        }
    }

    private fun Int?.orZero(): Int = this ?: 0
}