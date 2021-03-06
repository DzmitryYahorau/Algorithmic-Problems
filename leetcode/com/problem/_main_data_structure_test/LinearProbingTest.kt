import _main_data_structure_impl.symbol_table.SymbolTable
import _main_data_structure_impl.symbol_table.hash_table.LinearProbingHashST
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

private const val TEST_KEY = "Test KEY"
private const val TEST_VALUE = "Test Value"

class LinearProbingTest {

    private lateinit var hashMap: SymbolTable

    @BeforeEach
    fun setUp() {
        hashMap = LinearProbingHashST()
    }

    @Test
    fun shouldPutValueInHashTable() {
        hashMap.put(TEST_KEY, TEST_VALUE)

        val value = hashMap.get(TEST_KEY)

        assert(value == TEST_VALUE)
    }
}