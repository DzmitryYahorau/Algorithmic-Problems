package string

import kotlin.math.abs
import kotlin.test.assertEquals

fun shortestToChar(s: String, c: Char): IntArray {

    val result = IntArray(s.length)

    val list = mutableListOf<Int>()

    s.forEachIndexed { index, char ->
        if (char == c) {
            list.add(index)
        }
    }

    s.forEachIndexed { index, char ->
        val closest = list.minBy { abs(it - index) } ?: 0
        result[index] = abs(closest - index)

    }

    return result
}

fun main() {
    assertEquals(shortestToChar(s = "aaab", c = 'b').joinToString(), intArrayOf(3, 2, 1, 0).joinToString())
}