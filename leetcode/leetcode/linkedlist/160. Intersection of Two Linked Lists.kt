package linkedlist

fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    if (headA == null || headB == null) return null

    var a = headA
    var b = headB

    while (a != b) {

        /**
         * If we reach end, we switch to the longer node.
         * Same with second node.
         * This will do the trick to cover the difference in length
         * and they will meet in same point.
         */

        a = if (a == null) {
            headB
        } else {
            a.next
        }

        b = if (b == null) {
            headA
        } else {
            b.next
        }
    }

    return a
}

fun main() {
    val intersection = ListNode(`val` = 100000).apply {
        next = ListNode(-1).apply {
            next = ListNode(-2).apply {
                next = ListNode(-3)
            }
        }
    }

    val root = ListNode(`val` = 0).apply {
        next = intersection
    }

    val root2 = ListNode(`val` = 1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                    next = intersection
                }
        }
    }

    println(getIntersectionNode(root, root2))
}

/**
Algorithm

Set pointer pA to point at headA.
Set pointer pB to point at headB.
While pA and pB are not pointing at the same node:
If pA is pointing to a null, set pA to point to headB.
Else, set pA to point at pA.next.
If pB is pointing to a null, set pB to point to headA.
Else, set pB to point at pB.next.
return the value pointed to by pA (or by pB; they're the same now).

 **/