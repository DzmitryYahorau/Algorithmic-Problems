package priority_queue

import sort.exchange

class UnorderedMaxPriorityQueue(capacity: Int) : PriorityQueue {

    private var pq = IntArray(capacity)

    /**
     * Number of elements in {Priority queue}
     */
    private var N = 0

    override fun insert(key: Int) {
        pq[N++] = key
    }

    override fun deleteMax(): Int {
        var max = 0
        for (i in 1 until N) {
            if (max < pq[i]) {
                max = i
            }
        }
        exchange(pq, max, N - 1)
        return pq[--N]
    }

    override fun isEmpty(): Boolean = N == 0
}

fun main() {
    val pq: PriorityQueue = UnorderedMaxPriorityQueue(5)

    pq.insert(1)
    pq.insert(2)
    pq.insert(3)
    pq.insert(5)
    pq.insert(100)

    println(pq.deleteMax())
}