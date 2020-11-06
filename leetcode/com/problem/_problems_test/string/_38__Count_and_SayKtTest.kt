package string

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class _38__Count_and_SayKtTest {

    @Test
    fun test1() {
        val actual = countAndSay(1)
        val expected = "1"

        assertEquals(expected = expected, actual = actual)
    }

    @Test
    fun test2() {
        val actual = countAndSay(2)
        val expected = "11"

        assertEquals(expected = expected, actual = actual)
    }

    @Test
    fun test4() {
        val actual = countAndSay(4)
        val expected = "1211"

        assertEquals(expected = expected, actual = actual)
    }

    @Test
    fun test5() {
        val actual = countAndSay(5)
        val expected = "111221"

        assertEquals(expected = expected, actual = actual)
    }
}