package string

import kotlin.test.assertEquals

fun buddyStrings(A: String, B: String): Boolean {
    if (A.length != B.length) return false

    val diff = A.zip(B).filter { it.first != it.second }

    return when {
        //if we have same strings,
        // we need to check if we can swap two chars,
        // to do that we can check that we have at least two same chars
        diff.isEmpty() -> A.groupBy { it }.map { it.value.size }.max() ?: 0 > 1
        diff.size != 2 -> false
        else -> (diff[0].first == diff[1].second) && (diff[1].first == diff[0].second)
    }
}

fun main() {
    assertEquals(actual = buddyStrings(A = "aaaaaaabc", B = "aaaaaaacb"), expected = true)
}