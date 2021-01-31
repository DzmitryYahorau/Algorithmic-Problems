import array.rotate
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class `48_RotateImageTest` {

    @Test
    fun test1() {
        val actual = arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9)
        )

        rotate(actual)
        val expected = arrayOf(
                intArrayOf(7, 4, 1), intArrayOf(8, 5, 2), intArrayOf(9, 6, 3)
        )
        assertEquals(
                actual = actual.joinToString(",") { it.joinToString(",") },
                expected = expected.joinToString(",") { it.joinToString(",") }
        )
    }
}