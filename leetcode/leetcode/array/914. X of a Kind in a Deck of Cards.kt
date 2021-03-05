package array

import kotlin.test.assertEquals

fun hasGroupsSizeX(deck: IntArray): Boolean =
        deck.toList().groupingBy { it }.eachCount().map { it.value }.reduce { x: Int, y: Int -> gcd(x, y) } >= 2

//!!!need explanation!!!
private fun gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)

fun main() {
    assertEquals(actual = hasGroupsSizeX(intArrayOf(1, 2, 3, 4, 4, 3, 2, 1)), expected = true)
    assertEquals(actual = hasGroupsSizeX(intArrayOf(1, 1, 1, 2, 2, 2, 3, 3)), expected = false)
    assertEquals(actual = hasGroupsSizeX(intArrayOf(1)), expected = false)
    assertEquals(actual = hasGroupsSizeX(intArrayOf(1, 1)), expected = true)
    assertEquals(actual = hasGroupsSizeX(intArrayOf(1, 1, 2, 2, 2, 2)), expected = true)
}