package design

import kotlin.test.assertFalse
import kotlin.test.assertTrue

sealed class TrieNode {

    data class ValueNode(val value: Char) : TrieNode() {
        val nodes = mutableListOf<TrieNode>()
    }

    object EndNode : TrieNode()
}

class Trie {

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

        val child = nodes.find {
            when (it) {
                is TrieNode.ValueNode -> it.value == firstLetter
                else -> false
            }
        }

        return when (child) {
            is TrieNode.ValueNode -> search(child.nodes, word.drop(1))
            else -> false
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
}

fun main() {
    val trie = Trie()

    trie.insert("apple")
    assertTrue(trie.search("apple"))
    assertFalse(trie.search("app"))
    assertTrue(trie.startsWith("app"))
    trie.insert("app")
    assertTrue(trie.search("app"))

    with(trie) {
        insert("abc")
        search("abc")
        search("ab")
        insert("ab")
        search("ab")
        insert("ab")
        search("ab")
    }
}

