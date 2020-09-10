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

fun main() {
    val input = BinaryHeap(102)
    (0..100).shuffled().toIntArray().forEach {
        input.insert(it)
    }
    heapSort(input)
    println(input.pq.joinToString(","))
}