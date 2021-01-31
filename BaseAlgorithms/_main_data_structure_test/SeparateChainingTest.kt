//package _main_data_structure_test
//
//import org.junit.jupiter.api.BeforeEach
//import org.junit.jupiter.api.Test
//import symbol_table.SymbolTable
//import symbol_table.hash_table.SeparateChainingHashST
//
//private const val TEST_KEY = "Test KEY"
//private const val TEST_VALUE = "Test Value"
//
//class SeparateChainingTest {
//
//    private lateinit var hashMap: SymbolTable
//
//    @BeforeEach
//    fun setUp() {
//        hashMap = SeparateChainingHashST()
//    }
//
//    @Test
//    fun shouldPutValueInHashTable() {
//        hashMap.put(TEST_KEY, TEST_VALUE)
//
//        val value = hashMap.get(TEST_KEY)
//
//        assert(value == TEST_VALUE)
//    }
//}