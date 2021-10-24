package stack

import java.util.*

private const val PING_INTERVAL = 3000

class RecentCounter() {

    var pings = listOf<Int>()

    fun ping(t: Int): Int {
        pings = pings.filter { it in (t - PING_INTERVAL)..t } + t
        return pings.size
    }
}

//singly Linked list - #timeout but solved, took 30 min
class RecentCounter2() {

    private class Node(var next : Node?, val t: Int)

    private var calls : Node? = null

    fun ping(t: Int): Int {
        var i = 0
        val new = Node(null, t)
        new.next = calls
        var temp : Node? = new

        while (temp != null && ((temp.t) in (t - PING_INTERVAL)..t)){
            temp = temp.next
            i++
        }

        temp?.next = null

        calls = new

        return i
    }
}