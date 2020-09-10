import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import stack.Solution394
import kotlin.test.assertEquals

class DecodeStringTest {

    private lateinit var solution: Solution394

    @BeforeEach
    fun setUp() {
        solution = Solution394()
    }

    @Test
    fun input1() {
        val s = "3[a]2[bc]"
        val expected = "aaabcbc"
        val actual = solution.decodeString(s)
        assertEquals(expected, actual)
    }

    @Test
    fun input2() {
        val s = "3[a2[c]]"
        val expected = "accaccacc"
        val result = solution.decodeString(s)
        assertEquals(expected, result)
    }

    @Test
    fun input3() {
        val s = "2[abc]3[cd]ef"
        val result = solution.decodeString(s)
        assert(result == "abcabccdcdcdef")
    }
}