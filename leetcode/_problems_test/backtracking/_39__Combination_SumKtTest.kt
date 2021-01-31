package backtracking

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class _39__Combination_SumKtTest {

    @Test
    fun test1() {

        assertEquals(
                expected = setOf(setOf(2, 2, 2, 2), setOf(2, 3, 3), setOf(3, 5)),
                actual = combinationSum(intArrayOf(2, 3, 5), 8).map { it.toSet() }.toSet()
        )
    }

    @Test
    fun test2() {
        assertEquals(
                expected = listOf(),
                actual = combinationSum(intArrayOf(2), 1)
        )
    }

    @Test
    fun test3() {
        assertEquals(
                expected = listOf(listOf(1, 1)),
                actual = combinationSum(intArrayOf(1), 2)
        )
    }

    @Test
    fun test4() {
        assertEquals(
                expected = listOf(listOf(1)),
                actual = combinationSum(intArrayOf(1), 1)
        )
    }

    @Test
    fun test5() {

        assertEquals(
                expected = setOf(setOf(2, 2, 3), setOf(7)),
                actual = combinationSum(intArrayOf(2, 3, 6, 7), 7).map { it.toSet() }.toSet()
        )
    }

    @Test
    fun test6() {
        assertEquals(
                expected = setOf(setOf(3, 3, 5), setOf(3, 8)),
                actual = combinationSum(intArrayOf(3, 5, 8), 11).map { it.toSet() }.toSet()
        )
    }
}