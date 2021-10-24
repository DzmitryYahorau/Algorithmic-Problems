package linkedlist

/**
 * 1 - Use two pointer with different speed:
 * [runner] - twice faster than walker
 * [walker]
 * If there is no cycle in this linked list, runner will finally run through entire list without meet walker.
 * 2 - If cycle exists
 * [x] - a node they will meet each other, [meetNode] represents the x-th node in this list
 * [y] - the position of cycle start,
 * [m] - the length of cycle.
 * About runner:
 * it has already run 2[x] nodes, which is equal to [y] + [m] + ([x] — [y])
 * (length to cycle start + length of cycle + nodes to meet walker).
 * So we have 2[x] = [y] + [m] + ([x] — [y]), and it can conduct to [x] = [m].
 * 
 * About walker:
 * it needs to walk more [m] — ([x] — [y]) = [m] — [x] + [y] nodes to reach cycle start.
 * As we know in 1 that [x] is equal to m, walker needs to walk more y nodes to reach the node of cycle start.
 * By 1 and 2, we can put another pointer, say seeker, with the same speed as walker at the head.
 * Because seeker also needs y move nodes to reach the node of cycle start,
 * the node that seeker and walker meet each other will be what we are looking for.
 *
 * Complexity
 * Let n denotes to count of all nodes in this linked list, x denotes to the x-th node is the node that runner meets walker and y denotes to the node that cycle starts.
 * If there is no cycle in this linked list, it takes O(n/2) time for runner to go through entire list.
 * If there exists a cycle in linked list, runner needs to take O(x) time to meet walker. And after they meet each other, it takes O(y) time to let seeker meet walker. So it will take O(x+y) = O(n+n) = O(n) time because x and y are both less than n.
 * By 1 and 2, it’s clear that it takes O(n/2 + n) = O(n) time for detecting node of cycle start.
 * For space complexity, it only uses O(1) extra space.
 */

fun detectCycle(head: ListNode?): ListNode? {
    var slow : ListNode? = head
    var fast : ListNode? = head

    while (slow != null && fast != null){
        slow = slow.next
        fast = fast.next?.next

        if(fast == slow){
            var seeker = head

            while (slow != seeker){
                slow = slow?.next
                seeker = seeker?.next
            }

            return seeker
        }
    }

    return null
}