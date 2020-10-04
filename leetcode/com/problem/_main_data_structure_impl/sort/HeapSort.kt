package _main_data_structure_impl.sort

import _main_data_structure_impl.priority_queue.BinaryHeap

fun heapSort(priorityQueue: BinaryHeap) {
    var N = priorityQueue.pq.size -1
    for (k in N / 2 downTo 1) {
        priorityQueue.sink(k, N)
        while (N > 1) {
            exchange(priorityQueue.pq, 1, N)
            priorityQueue.sink(1, --N)
        }
    }
}

/**
 * The `Heap` class provides a static method to sort an array
 * using *heapsort*.
 *
 *
 * This implementation takes (*n* log *n*) time
 * to sort any array of length *n* (assuming comparisons
 * take constant time). It makes at most
 * 2 *n* log<sub>2</sub> *n* compares.
 *
 *
 * This sorting algorithm is not stable.
 * It uses (1) extra memory (not including the input array).
 *
 *
 * For additional documentation, see
 * [Section 2.4](https://algs4.cs.princeton.edu/24pq) of
 * *Algorithms, 4th Edition* by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
class Heap {
    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param pq the array to be sorted
     */
    fun heapSort(pq: IntArray) {
        val n = pq.size

        // heapify phase
        for (k in n / 2 downTo 1) sink(pq, k, n)

        // sort down phase
        var j = n
        while (j > 1) {
            exchange(pq, 1, j--)
            sink(pq, 1, j)
        }
    }

    /***************************************************************************
     * Helper functions to restore the heap invariant.
     */
    private fun sink(pq: IntArray, k: Int, n: Int) {
        var k = k
        while (2 * k <= n) {
            var j = 2 * k
            if (j < n && (pq[j - 1] < pq[j])) j++
            if (pq[k - 1] >= pq[j]) break
            exchange(pq, k, j)
            k = j
        }
    }
}

fun main() {
    val input = BinaryHeap(102)
    (0..100).shuffled().toIntArray().forEach {
        input.insert(it)
    }
    heapSort(input)
    println(input.pq.joinToString(","))
}