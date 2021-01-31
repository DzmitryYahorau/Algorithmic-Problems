//package _main_data_structure_impl.symbol_table
//
//import _main_data_structure_impl.symbol_table.hash_table.Node
//
///**
// * The `SequentialSearchST` class represents an (unordered)
// * symbol table of generic key-value pairs.
// * It supports the usual *put*, *get*, *contains*,
// * *delete*, *size*, and *is-empty* methods.
// * It also provides a *keys* method for iterating over all of the keys.
// * A symbol table implements the *associative array* abstraction:
// * when associating a value with a key that is already in the symbol table,
// * the convention is to replace the old value with the new value.
// * The class also uses the convention that values cannot be `null`. Setting the
// * value associated with a key to `null` is equivalent to deleting the key
// * from the symbol table.
// *
// *
// * It relies on the `equals()` method to test whether two keys
// * are equal. It does not call either the `compareTo()` or
// * `hashCode()` method.
// *
// *
// * This implementation uses a *singly linked list* and
// * *sequential search*.
// * The *put* and *delete* operations take (*n*).
// * The *get* and *contains* operations takes (*n*)
// * time in the worst case.
// * The *size*, and *is-empty* operations take (1) time.
// * Construction takes (1) time.
// *
// *
// * For additional documentation, see
// * [Section 3.1](https://algs4.cs.princeton.edu/31elementary) of
// * *Algorithms, 4th Edition* by Robert Sedgewick and Kevin Wayne.
// *
// * @author Robert Sedgewick
// * @author Kevin Wayne
// */
//class SequentialSearchST<Key, Value> {
//    private var n = 0
//
//    // the linked list of key-value pairs
//    private var first: Node? = null
//
//    fun size(): Int = n
//
//    fun get(key: Key?): Value? {
//        var x: Node? = first
//        while (x != null) {
//            if (key == x.key) return x.value
//            x = x.next
//        }
//        return null
//    }
//
//    fun put(key: Key?, value: Value?) {
//        var x: Node? = first
//        while (x != null) {
//            if (key == x.key) {
//                x.value = value
//                return
//            }
//            x = x.next
//        }
//        first = Node(key, value, first)
//        n++
//    }
//
//    fun delete(key: Key?) {
//        first = delete(first, key)
//    }
//
//    private fun delete(x: Node?, key: Key?): Node? {
//        if (x == null) return null
//        if (key == x.key) {
//            n--
//            return x.next
//        }
//        x.next = delete(x.next, key)
//        return x
//    }
//}
//
