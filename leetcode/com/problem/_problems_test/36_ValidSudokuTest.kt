import hashtable.isValidSudoku
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ValidSudokuTest {

    @Test
    fun testCase1() {
        val board = arrayOf(
                charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
                charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )

        val expected = true
        val actual = isValidSudoku(board)
        assert(expected == actual)
    }
    @Test
    fun testCase2() {
        val board = arrayOf(
                charArrayOf('8','3','.','.','7','.','.','.','.'),
                charArrayOf('6','.','.','1','9','5','.','.','.'),
                charArrayOf('.','9','8','.','.','.','.','6','.'),
                charArrayOf('8','.','.','.','6','.','.','.','3'),
                charArrayOf('4','.','.','8','.','3','.','.','1'),
                charArrayOf('7','.','.','.','2','.','.','.','6'),
                charArrayOf('.','6','.','.','.','.','2','8','.'),
                charArrayOf('.','.','.','4','1','9','.','.','5'),
                charArrayOf('.','.','.','.','8','.','.','7','9')
        )

        val expected = false
        val actual = isValidSudoku(board)
        assert(expected == actual)
    }

    @Test
    fun testSequenceValidationSuccess() {
        val actual = hashtable.isValid(charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'))
        assertTrue(actual)
    }

    @Test
    fun testSequenceValidationFails() {
        val actual = hashtable.isValid(charArrayOf('5', '3', '.', '.', '7', '.', '.', '3', '.'))
        assertFalse( actual)
    }
}
