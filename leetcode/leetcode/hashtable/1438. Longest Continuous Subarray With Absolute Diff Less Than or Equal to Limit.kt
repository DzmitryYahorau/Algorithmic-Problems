package hashtable

import java.util.*
import kotlin.math.abs

// solved, same as accepted solution - just code cacn be simplified
fun longestSubarray(nums: IntArray, limit: Int): Int {
    var i = 0
    var j = 0
    var maxCount = 0

    val pq = PriorityQueue<Int>()
    val maxPQ = PriorityQueue<Int>(compareByDescending { it })

    while (i < nums.size) {
        val curr = nums[i]
        pq.add(curr)
        maxPQ.add(curr)

        if (abs(maxPQ.peek() - pq.peek()) <= limit) {
            i++
            maxCount = maxOf(maxCount, pq.size)
        } else {
            maxCount = maxOf(pq.size - 1, maxCount)

            var past = nums[j++]
            pq.remove(past)
            maxPQ.remove(past)

            while (j <= i && pq.isNotEmpty() && maxPQ.isNotEmpty() && abs(maxPQ.peek() - pq.peek()) > limit) {
                past = nums[j]
                pq.remove(past)
                maxPQ.remove(past)
                j++
            }
            i++
        }
    }

    return maxCount
}

fun main() {
    println(longestSubarray(intArrayOf(10, 1, 2, 4, 7, 2), limit = 5))  // 4
    println(longestSubarray(intArrayOf(8, 2, 4, 7), limit = 4)) // 2
    println(longestSubarray(intArrayOf(1, 5, 6, 7, 8, 10, 6, 5, 6), limit = 4)) // 5
    println(longestSubarray(intArrayOf(9, 10, 1, 7, 9, 3, 9, 9), limit = 7)) // 5
}