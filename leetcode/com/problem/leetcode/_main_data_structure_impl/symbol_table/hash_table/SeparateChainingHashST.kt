package _main_data_structure_impl.symbol_table.hash_table

import _main_data_structure_impl.symbol_table.BST.Key
import _main_data_structure_impl.symbol_table.BST.Value
import _main_data_structure_impl.symbol_table.SymbolTable
import kotlin.math.abs

class SeparateChainingHashST : SymbolTable {

    private var M = 97
    private var st = Array<Node?>(M) { null }

    override fun put(key: Key, value: Value) {
        val i = hashCode(key)
        var x = st[i]
        while (x != null) {
            if (key == x.key) {
                x.value = value
                return
            } else {
                x = x.next
            }
        }

        st[i] = Node(key = key, value = value, next = st[i])
    }

    override fun get(key: Key): Value? {
        val i = hashCode(key)
        var x = st[i]
        while (x != null) {
            if (key == x.key) {
                return x.value
            } else {
                x = x.next
            }
        }
        return null
    }

    override fun delete(key: Key) {
        TODO("Not yet implemented")
    }

    override fun contains(key: Key): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean = st.isEmpty()

    override fun size(): Int = st.size

    override fun keys(): List<Key> {
        TODO("Not yet implemented")
    }

    private fun hashCode(s: String): Int {
        var hash = 0
        for (i in s.indices) {
            hash = Character.getNumericValue(s[i]) + (hash * 31)
        }

        return abs(hash) % M
    }
}

