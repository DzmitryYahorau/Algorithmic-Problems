package string

import java.util.*

fun reorganizeString(s: String): String {
    // Create map of each char to its count
    val counts = s.groupingBy { it }.eachCount().toMutableMap()

    // check if it's possible t get solution
    if (counts.any { it.value > (s.length + 1) / 2 }){
        return ""
    }

    // Greedy: fetch char of max count as next char in the result.
    // Use PriorityQueue to store pairs of (chars) and sort by count DESC.
    val maxHeap = PriorityQueue<Char>(compareByDescending { counts[it] })
    maxHeap.addAll(counts.keys)

    // Build the result.
    val sb = StringBuilder()
    while (maxHeap.size > 1) {

        val firstMax  = maxHeap.poll()
        val secondMax  = maxHeap.poll()

        sb.append(firstMax)
        sb.append(secondMax)

        counts[firstMax] = counts[firstMax]?.minus(1) ?: 0
        counts[secondMax] = counts[secondMax]?.minus(1) ?: 0

        if (counts.getValue(firstMax) > 0){
            maxHeap.offer(firstMax)
        }

        if (counts.getValue(secondMax) > 0){
            maxHeap.offer(secondMax)
        }
    }

    if (maxHeap.isNotEmpty()){
        val last = maxHeap.last()
        if (counts.getValue(last) > 1){
            return ""
        }
        sb.append(last)
    }

    return sb.toString()
}

fun main() {
    println(reorganizeString(s = "aab"))
    println(reorganizeString(s = "ab"))
    println(reorganizeString(s = "aaab"))
    println(reorganizeString(s = "a"))
    println(reorganizeString(s = "fsfdsjklfdsjklfasdjkldsflkjldfsjkldfkjlldfjkldfsjkldfsjklsdfkdfsksdfjkldfskjldfsjkldfsljkdfsjk"))
    println(reorganizeString(s = "fffffffffffffff"))
    println(reorganizeString(s = "aaabbb"))
    println(reorganizeString(s = "baaba")) // expected "ababa"
}