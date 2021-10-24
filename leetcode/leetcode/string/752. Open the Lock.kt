package string

import java.util.*

fun openLock(deadends: Array<String>, target: String): Int {
    var count = 0
    val notValid = deadends.toSet()

    val queue: Queue<LockCode> = LinkedList()
    queue.offer(LockCode(0, 0, 0, 0))

    val used = mutableSetOf<LockCode>()

    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val newCode = queue.poll()
            if (newCode.toString() == target) {
                return count
            }
            if (newCode.toString() !in notValid) {
                val next = newCode.generateNextLevel()
                next.forEach { code ->
                    if (code.toString() == target) {
                        return count + 1
                    }

                    if (code.toString() !in notValid && used.add(code)) {
                        queue.add(code)
                    }
                }
            }
        }
        count++
    }

    return -1
}

private data class LockCode(val first: Int, val second: Int, val third: Int, val forth: Int) {
    override fun toString(): String {
        return "$first$second$third$forth"
    }
}

private fun LockCode.generateNextLevel(): List<LockCode> =
        listOf(
                copy(first = first.next()),
                copy(second = second.next()),
                copy(third = third.next()),
                copy(forth = forth.next()),
                copy(first = first.prev()),
                copy(second = second.prev()),
                copy(third = third.prev()),
                copy(forth = forth.prev())
        )

fun Int.next(): Int = if (this == 9) 0 else (this + 1)
fun Int.prev(): Int = if (this == 0) 9 else (this - 1)

fun main() {
    println(openLock(
            deadends = arrayOf("0201", "0101", "0102", "1212", "2002"),
            target = "0202"
    )) // 6
    println(openLock(
            deadends = arrayOf("8888"), target = "0009"
    )) // 1
    println(openLock(
            deadends = arrayOf("8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"),
            target = "8888"
    )) // -1

    println(openLock(
            deadends = arrayOf("0000"), target = "8888"
    )) // -1
}

