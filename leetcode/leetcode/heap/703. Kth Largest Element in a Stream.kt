package heap

import java.util.*

class KthLargest(val k: Int, nums: IntArray) {

    private val pq = PriorityQueue<Int>(k)

    init {
        nums.forEach { add(it) }
    }

    fun add(`val`: Int): Int {

        if (pq.size == k) {
            if (pq.peek() < `val`) {
                pq.poll()
                pq.add(`val`)
            }
        } else {
            pq.add(`val`)
        }

        return pq.peek()
    }
}

fun main() {
    val a = KthLargest(3, intArrayOf(4, 5, 8, 2))
    println(a.add(3))
    println(a.add(5))
    println(a.add(10))
    println(a.add(9))
    println(a.add(4))
}