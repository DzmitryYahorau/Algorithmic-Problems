package array

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Plus_OneTest {

    @Test
    fun test1() {
        val input = intArrayOf(1)
        plusOne(input)

        assertEquals(expected = arrayOf(2).joinToString(), actual = input.joinToString())
    }

    @Test
    fun test2() {
        val input = intArrayOf(9)
        val actual = plusOne(input)

        assertEquals(expected = arrayOf(1, 0).joinToString(), actual = actual.joinToString())
    }

    @Test
    fun test3() {
        val input = intArrayOf(9, 9)
        val actual =plusOne(input)

        assertEquals(expected = arrayOf(1, 0, 0).joinToString(), actual = actual.joinToString())
    }

}