import _main_data_structure_impl.symbol_table.BST.BinarySearchTree
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

private const val TEST_KEY = "Test KEY"
private const val TEST_VALUE = "Test Value"

class BinarySearchTreeTest {

    private lateinit var bst: BinarySearchTree

    @BeforeEach
    fun setUp() {
        bst = BinarySearchTree()
    }

    @Test
    fun shouldPutKeyValuePair() {
        bst.put(key = TEST_KEY, value = TEST_VALUE)

        assert(bst.get(TEST_KEY) == TEST_VALUE)
    }

    @Test
    fun shouldDeleteValue() {
        bst.put(key = TEST_KEY, value = TEST_VALUE)
        bst.delete(TEST_KEY)

        assert(!bst.contains(TEST_KEY))
    }

    @Test
    fun shouldCalculateRank() {

        bst.put("A", TEST_VALUE)
        bst.put("B", TEST_VALUE)
        bst.put("C", TEST_VALUE)

        val rank = bst.rank("C")
        assertEquals(expected = 2, actual = rank)
    }
}