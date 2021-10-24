package greedy

import java.util.*

fun lastStoneWeight(stones: IntArray): Int {
    val pq = PriorityQueue<Int> { x, y -> Integer.compare(y, x) }

    pq.addAll(stones.toList())

    while(pq.size > 1){
        val f = pq.remove()
        val s = pq.remove()
        val diff = f-s

        if (diff != 0){
            pq.add(diff)
        }

    }

    return pq.firstOrNull() ?: 0
}