package array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class _118_Pascals_TriangleKtTest {

    @Test
    fun test1() {
        val expected = listOf(
                listOf(1),
                listOf(1, 1),
                listOf(1, 2, 1),
                listOf(1, 3, 3, 1),
                listOf(1, 4, 6, 4, 1)
        )

        val actual = generate(5)

        assertEquals(expected.joinToString(), actual.joinToString())
    }
}