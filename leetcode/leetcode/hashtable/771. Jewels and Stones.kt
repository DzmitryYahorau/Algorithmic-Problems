package hashtable

import kotlin.test.assertEquals

fun numJewelsInStones(jewels: String, stones: String): Int {
    var count = 0
    val jevMap = jewels.associateBy { it }

    stones.forEach {
        if (jevMap.containsKey(it)) {
            count++
        }
    }
    return count
}

fun main() {
    assertEquals(expected = 3, actual = numJewelsInStones(jewels = "aA", stones = "aAAbbbb"))
}