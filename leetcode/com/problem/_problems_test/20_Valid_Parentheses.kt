import org.junit.jupiter.api.Test
import stack.isValid
import kotlin.test.assertTrue

class ValidParenthesesTest {
    @Test
    fun test1() {
        val input = "()"
        val actual = isValid(input)
        assertTrue(actual)
    }

    @Test
    fun test2() {
        val input = "{[]}"
        val actual = isValid(input)
        assertTrue(actual)
    }
}