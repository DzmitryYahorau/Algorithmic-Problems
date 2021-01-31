package priority_queue

import sort.exchange

class BinaryHeap(capacity: Int) : PriorityQueue {

    private var N = 0
    val pq = Array<Int?>(capacity) { null }

    override fun insert(key: Int) {
        pq[++N] = key
        swim(N)
    }

    override fun deleteMax(): Int {
        val max = pq[1]
        exchange(pq, 1, N--)
        sink(1, N)
        pq[N + 1] = null
        return max ?: 0
    }

    override fun isEmpty(): Boolean = N == 0

    private fun swim(key: Int) {
        var k = key
        while (k > 1 && pq[k / 2] ?: 0 < pq[k] ?: 0) {
            exchange(pq, k, k / 2)
            k /= 2
        }
    }

    fun sink(key: Int, N: Int) {
        var k = key
        while (2 * k <= N) {
            var j = 2 * k
            if (j < N && pq[j] ?: 0 < pq[j + 1] ?: 0) {
                j++
            }

            if (pq[k] ?: 0 > pq[j] ?: 0) {
                break
            }

            exchange(pq, k, j)
            k = j
        }
    }
}

fun main() {
    val pq: PriorityQueue = BinaryHeap(6)

    pq.insert(1)
    pq.insert(2)
    pq.insert(3)
    pq.insert(100)
    pq.insert(5)

    println(pq.deleteMax())
}