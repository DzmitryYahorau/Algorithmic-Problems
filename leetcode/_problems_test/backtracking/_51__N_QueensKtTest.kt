package backtracking

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class _51__N_QueensKtTest {

    @Test
    fun `isValid 1`() {
        val board = mutableListOf(
                charArrayOf('Q', '.', '.', '.'),
                charArrayOf('.', '.', '.', '.'),
                charArrayOf('.', '.', '.', 'Q'),
        )

        assertEquals(isValid(board, 0, 0), true)
    }

    @Test
    fun `isValid 2`() {
        val board = mutableListOf(
                charArrayOf('Q', '.', '.', '.'),
                charArrayOf('Q', '.', '.', '.'),
                charArrayOf('.', '.', '.', 'Q'),
        )

        assertEquals(isValid(board, 1, 0), false) { "" }
    }

    @Test
    fun `isValid 3`() {
        val board = mutableListOf(
                charArrayOf('Q', '.', '.', '.'),
                charArrayOf('.', 'Q', '.', '.'),
                charArrayOf('.', '.', '.', 'Q'),
        )

        assertEquals(isValid(board, 1, 1), false) { "" }
    }

    @Test
    fun `isValid 4`() {
        val board = mutableListOf(
                charArrayOf('Q', '.', '.', '.'),
                charArrayOf('.', 'Q', '.', '.'),
                charArrayOf('Q', '.', '.', 'Q'),
        )

        assertEquals(isValid(board, 2, 0), false) { "" }
    }

    @Test
    fun `isValid 5`() {
        val board = mutableListOf(
                charArrayOf('.', 'Q', '.', 'Q'),
                charArrayOf('.', '.', '.', '.'),
                charArrayOf('.', '.', '.', '.'),
                charArrayOf('Q', '.', '.', '.'),
        )

        assertEquals(isValid(board, 3, 0), false) { "" }
    }

    @Test
    fun `isValid 6`() {
        val board = mutableListOf(
                charArrayOf('Q'),
        )

        assertEquals(isValid(board, 0, 0), true) { "" }
    }
}