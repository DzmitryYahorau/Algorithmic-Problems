package greedy

import java.io.File
import java.util.*
import kotlin.system.measureTimeMillis
import java.util.Arrays

//my stupid solution
fun numRescueBoats(people: IntArray, limit: Int): Int {
    people.sortDescending()

    if (people.isNotEmpty() && people.first() <= limit / 2) {
        return (people.size / 2) + (people.size % 2)
    }

    var result = 0
    var start = 0
    while (start <= people.lastIndex && people[start] == limit) {
        result += 1
        start++
    }

    while (start <= people.lastIndex) {
        if (people[start] == -1) {
            start++
            continue
        }

        val current = people[start]

        if (current <= limit / 2) {
            val otherPeopleSize: Int =
                    people.filterIndexed { index, i ->
                        index >= start && i != -1
                    }.size
            return result + (otherPeopleSize / 2) + (otherPeopleSize % 2)
        }

        var next = start + 1
        while (
                (next in people.indices)
                && ((people[next] + current) > limit || (people[next] == -1))
        ) {
            next++
        }

        if (next in people.indices) {
            people[next] = -1
        }

        result += 1
        start++
    }

    return result
}

private class `solution from question` {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()
        var i = 0
        var j = people.size - 1
        var ans = 0
        while (i <= j) {
            ans++
            if (people[i] + people[j] <= limit) i++
            j--
        }
        return ans
    }
}

fun main() {
//    println(numRescueBoats(intArrayOf(2, 1), 3))
//    println(numRescueBoats(intArrayOf(3, 5, 3, 4), 5))
//    println(numRescueBoats(intArrayOf(3, 2, 3, 2, 2), 6))
//    println(numRescueBoats(intArrayOf(4,3,6), 6))
    println(numRescueBoats(intArrayOf(5, 1, 7, 4, 2, 4), 7))

//    val a = mutableListOf<Int>()
//    File("/Users/dzmtr/IdeaProjects/Algorithmic-Problems/leetcode/leetcode/greedy/input73.txt")
//            .useLines { lines -> lines.forEach {
//        a.addAll(it.split(',').map { it.toInt() })
//    }}
//
////    println(numRescueBoats(a.toIntArray(), 50))
//    val time = measureTimeMillis {
//    println(numRescueBoats(a.toIntArray(), 1000))
//    }
//    println( time)
}