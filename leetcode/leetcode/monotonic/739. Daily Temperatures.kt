package monotonic

import java.util.*

fun dailyTemperatures(temperatures: IntArray): IntArray {
    val res = IntArray(temperatures.size)

    val q: Deque<Int> = LinkedList()

    var i = temperatures.lastIndex

    while (i >= 0) {

        while (q.isNotEmpty() && temperatures[q.peekFirst()] <= temperatures[i]) {
            q.pollFirst()
        }

        res[i] = if (q.isEmpty()) 0 else q.peekFirst() - i

        q.addFirst(i)

        i--
    }

    return res
}

fun main() {
    println(dailyTemperatures(
            intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
    ).joinToString()) // [1,1,4,2,1,1,0,0]
}