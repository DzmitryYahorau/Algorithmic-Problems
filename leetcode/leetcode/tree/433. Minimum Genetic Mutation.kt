package hashtable

import java.util.*

val ALL_CHARS = setOf('A', 'C', 'G', 'T')

fun minMutation(start: String, end: String, bank: Array<String>): Int {
    if (start == end) return 0

    val bankSet = bank.toMutableSet()
    val visited = mutableSetOf<String>()
    val queue: Queue<String> = LinkedList<String>()

    queue.offer(start)
    visited.add(start)

    return bfs(queue, visited, end, bankSet)
}

private fun bfs(queue: Queue<String>, visited: MutableSet<String>, end: String, bankSet: Set<String>): Int {
    var level = 0

    while (queue.isNotEmpty()) {
        var size: Int = queue.size

        while (size > 0) {

            val curr: String = queue.poll()
            if (curr == end) return level

            val currArray = curr.toCharArray()

            //each character we replace with all possible characters and look up in bank,
            //and look if it was already visited
            for (i in curr.indices) {
                val old = currArray[i]

                for (char in ALL_CHARS) {
                    currArray[i] = char
                    val next = currArray.joinToString("")
                    if (!visited.contains(next) && bankSet.contains(next)) {
                        visited.add(next)
                        queue.offer(next)
                    }
                }
                currArray[i] = old
            }
            size--
        }
        level++
    }
    return -1
}


fun main() {
//    start: "AACCGGTT"
//    end:   "AACCGGTA"
//    bank: ["AACCGGTA"]

//    "AACCGGTT"
//    "AAACGGTA"
//    ["AACCGATT","AACCGATA","AAACGATA","AAACGGTA"]

    println(minMutation("CCGGTT", "ACGGTA", arrayOf("CCGATT", "CCGATA", "ACGATA", "ACGGTA")))
}