package heap

import linkedlist.ListNode
import java.util.*

fun mergeKLists(lists: Array<ListNode?>): ListNode? =
        when (lists.size) {
            0 -> null
            1 -> lists.first()
            2 -> mergeNodes(first = lists[0], second = lists[1])
            else -> {
                val mid = lists.size / 2

                val first = mergeKLists(lists.sliceArray(0..mid))
                val second = mergeKLists(lists.sliceArray(mid + 1..lists.lastIndex))

                mergeNodes(first = first, second = second)
            }
        }

fun mergeNodes(first: ListNode?, second: ListNode?): ListNode? {
    val aux = mutableListOf<ListNode>()

    var l = first
    var mid = 0
    while (l != null) {
//        l.next = null
        aux.add(l)
        l = l.next
        mid++
    }

    var m = second

    while (m != null) {
//        m.next = null
        aux.add(m)
        m = m.next
    }

    var i = 0
    var j = mid


    val list = LinkedList<ListNode>()

    for (k in aux.indices) {
        val next = when {
            (i >= mid) -> aux[j++]
            (j > aux.lastIndex) -> aux[i++]
            (aux[j].`val` < aux[i].`val`) -> aux[j++]
            else -> aux[i++]
        }

        list.add(next)
    }

    val queue = LinkedQueue()

    list.forEach {
        queue.enqueue(it)
    }

    return queue.getRoot()
}

class LinkedQueue {

    private var first: ListNode? = null
    private var last: ListNode? = null

    fun enqueue(item: ListNode) {

        val oldLast = last
        last = ListNode(item.`val`)

        if (isEmpty()) {
            first = last
        } else {
            oldLast?.next = last
        }
    }

    fun isEmpty(): Boolean = first == null

    fun getRoot() = first

}

//works a bit faster, less code, cleaner
class SolutionUsingPQ {

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val pq = PriorityQueue<ListNode> { a, b ->
            a.`val` - b.`val`
        }
        val dummy = ListNode(-1)
        var d: ListNode? = dummy

        for (l in lists) {
            if (l != null)
                pq.offer(l)
        }
        while (!pq.isEmpty()) {
            val node = pq.poll()
            d?.next = node
            d = d?.next
            if (node.next != null)
                pq.offer(node.next)
        }
        return dummy.next
    }
}

fun main() {
//    lists = [[1,4,5],[1,3,4],[2,6]]

    val root1 = ListNode(1).apply { next = ListNode(4).apply { next = ListNode(5) } }
    val root2 = ListNode(1).apply { next = ListNode(3).apply { next = ListNode(4) } }
    val root3 = ListNode(2).apply { next = ListNode(6) }

    mergeKLists(lists = arrayOf(root1, root2, root3)).also { print(it) }
}
