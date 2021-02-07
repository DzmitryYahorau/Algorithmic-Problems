package symbol_table

import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * The `TrieST` class represents an symbol table of key-value
 * pairs, with string keys and generic values.
 * It supports the usual *put*, *get*, *contains*,
 * *delete*, *size*, and *is-empty* methods.
 * It also provides character-based methods for finding the string
 * in the symbol table that is the *longest prefix* of a given prefix,
 * finding all strings in the symbol table that *start with* a given prefix,
 * and finding all strings in the symbol table that *match* a given pattern.
 * A symbol table implements the *associative array* abstraction:
 * when associating a value with a key that is already in the symbol table,
 * the convention is to replace the old value with the new value.
 * Unlike [java.util.Map], this class uses the convention that
 * values cannot be `null`—setting the
 * value associated with a key to `null` is equivalent to deleting the key
 * from the symbol table.
 *
 *
 * This implementation uses a 256-way trie.
 * The *put*, *contains*, *delete*, and
 * *longest prefix* operations take time proportional to the length
 * of the key (in the worst case). Construction takes constant time.
 * The *size*, and *is-empty* operations take constant time.
 * Construction takes constant time.
 *
 *
 * For additional documentation, see [Section 5.2](https://algs4.cs.princeton.edu/52trie) of
 * *Algorithms, 4th Edition* by Robert Sedgewick and Kevin Wayne.
 */

sealed class TrieNode {

    data class ValueNode(val value: Char) : TrieNode() {
        val nodes = mutableListOf<TrieNode>()
    }

    object EndNode : TrieNode()
}

class TrieST {

    /** Initialize your data structure here. */
    private val rootNodes = mutableListOf<TrieNode>()

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        put(rootNodes, word)
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean = search(rootNodes, word)

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean = startsWith(rootNodes, prefix)

    /** Returns if the word with wildcard is in the trie. */
    fun keysThatMatch(pattern: String): Boolean = keysThatMatch(rootNodes, pattern)

    /**
     * PRIVATE
     */

    private fun put(nodes: MutableList<TrieNode>, word: String) {
        if (word.isEmpty() && nodes.none { it == TrieNode.EndNode }) {
            nodes.add(TrieNode.EndNode)
            return
        }

        if (word.isEmpty()) return

        val letter = word.first()
        val rest = word.drop(1)

        val child: TrieNode.ValueNode? = nodes.filterIsInstance<TrieNode.ValueNode>()
                .find { it.value == letter }

        if (child != null) {
            put(child.nodes, rest)
        } else {
            val nextNode = TrieNode.ValueNode(letter)
            put(nextNode.nodes, rest)
            nodes.add(nextNode)
        }
    }

    private fun search(nodes: List<TrieNode>, word: String): Boolean {
        if (word.isEmpty()) {
            return nodes.any { it == TrieNode.EndNode }
        }

        val firstLetter = word.first()

        val child = nodes.filterIsInstance<TrieNode.ValueNode>().find { it.value == firstLetter }

        return if (child != null) {
            search(child.nodes, word.drop(1))
        } else {
            false
        }
    }

    private fun startsWith(nodes: List<TrieNode>, word: String): Boolean {
        if (word.isEmpty()) return true

        val firstLetter = word.first()

        val child = nodes.filterIsInstance<TrieNode.ValueNode>().find { it.value == firstLetter }

        return if (child != null) {
            startsWith(child.nodes, word.drop(1))
        } else {
            false
        }
    }

    private fun keysThatMatch(nodes: List<TrieNode>, pattern: String): Boolean {
        if (pattern.isEmpty()) {
            return nodes.any { it == TrieNode.EndNode }
        }

        val firstLetter = pattern.first()

        val search: (TrieNode.ValueNode) -> Boolean = {
            if (firstLetter != '.') {
                it.value == firstLetter
            } else {
                true
            }
        }

        val children = nodes.filterIsInstance<TrieNode.ValueNode>().filter(search)

        return if (children.isNotEmpty()) {
            children.any { keysThatMatch(it.nodes, pattern.drop(1)) }
        } else {
            false
        }
    }
}

fun main() {
    val trieST = TrieST()

    with(trieST) {
        insert("at")
        insert("and")
        insert("an")
        insert("add")

        assertEquals(actual = keysThatMatch("a"), expected = false)
        assertEquals(actual = keysThatMatch(".at"), expected = false)

        insert("bat")

        assertEquals(actual = keysThatMatch(".at"), expected = true)
        assertEquals(actual = keysThatMatch("an."), expected = true)

        assertEquals(actual = keysThatMatch("a.d."), expected = false)
        assertEquals(actual = keysThatMatch("b."), expected = false)

        assertEquals(actual = keysThatMatch("a.d"), expected = true)
        assertEquals(actual = keysThatMatch("."), expected = false)
    }

}