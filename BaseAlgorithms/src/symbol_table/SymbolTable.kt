package symbol_table

import _main_data_structure_impl.symbol_table.BST.Key
import _main_data_structure_impl.symbol_table.BST.Value

interface SymbolTable {
    /**
     * Overrides old value with new. [Value] can't be null.
     */
    fun put(key: Key, value: Value)

    /**
     * Returns [null] if not present.
     */
    fun get(key: Key) : Value?

    fun delete(key: Key)

    fun contains(key: Key) : Boolean

    fun isEmpty(): Boolean

    fun size(): Int

    fun keys(): List<Key>
}