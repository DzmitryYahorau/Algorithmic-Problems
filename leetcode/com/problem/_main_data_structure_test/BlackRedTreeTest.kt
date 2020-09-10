import _main_data_structure_impl.symbol_table.RBT.RedBlackTree
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

private const val TEST_KEY = "Test KEY"
private const val TEST_VALUE = "Test Value"

class BlackRedTreeTest {

    private lateinit var blackRedTree: RedBlackTree

    @BeforeEach
    fun setUp() {
        blackRedTree = RedBlackTree()
    }

    @Test
    fun shouldPutValueInTree() {
        blackRedTree.put(TEST_KEY, TEST_VALUE)

        assert(blackRedTree.contains(TEST_KEY))
    }
}