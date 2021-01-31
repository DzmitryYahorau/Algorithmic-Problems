package symbol_table.hash_table

import symbol_table.SymbolTable
import kotlin.math.abs

class LinearProbingHashST : SymbolTable {

    private val M = 30001
    private val values = Array<Value?>(M){ null }
    private val keys = Array<Key?>(M){ null }

    override fun put(key: Key, value: Value) {
        var i = hashCode(key)
        while (keys[i] != null) {
            if (keys[i] == key) {
                break
            } else {
                i = (i + 1) / M
            }
        }
            keys[i] = key
            values[i] = value
    }

    override fun get(key: Key): Value? {
        var i = hashCode(key)
        while (keys[i] != null) {
            if (key == keys[i]) {
                return values[i]
            } else {
                i = (i + 1) / M
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

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun size(): Int {
        TODO("Not yet implemented")
    }

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