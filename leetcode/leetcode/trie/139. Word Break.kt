package trie

import kotlin.test.assertFalse
import kotlin.test.assertTrue

fun wordBreak(s: String, wordDict: List<String>): Boolean = BreakTrie(dic = wordDict).canBreak(s)

class BreakTrie(dic: List<String>) {
    private var root: Node? = null

    init {
        dic.forEach { word -> root = this.put(root, word, 0) }
    }

    private fun put(x: Node?, key: String, d: Int): Node {
        val c = key[d]
        val storedValue = if (d == key.lastIndex) {
            key
        } else {
            null
        }

        val node = x ?: Node(char = c, value = storedValue)

        when {
            c < node.char -> node.left = put(node.left, key, d)
            c > node.char -> node.right = put(node.right, key, d)
            d < key.lastIndex -> node.center = put(node.center, key, d + 1)
            else -> node.value = key
        }

        return node
    }

    fun canBreak(s: String): Boolean =
            get(root, s, 0, mutableMapOf())

    private fun get(node: Node?, key: String, d: Int, checked: MutableMap<Int, MutableSet<Node>>): Boolean {
        if (node == null || d > key.lastIndex) return false

        val c = key[d]

        if (checked[d]?.contains(node) == true) {
            return false
        }

        return when {
            c < node.char -> get(node.left, key, d, checked)
            c > node.char -> get(node.right, key, d, checked)
            (c == node.char && node.value == null && d < key.lastIndex) -> get(node.center, key, d + 1, checked)
            (c == node.char && node.value != null && d < key.lastIndex) -> {
                if (!get(node.center, key, d + 1, checked)) {
                    val old = checked[d]?.toMutableSet() ?: mutableSetOf()
                    old.add(node)
                    checked[d] = old
                    get(root, key, d + 1, checked)
                } else {
                    true
                }
            }
            c == node.char && node.value != null && d == key.lastIndex -> true
            else -> false
        }
    }

    private data class Node(
            val char: Char,
            var value: String?,
            var left: Node? = null,
            var right: Node? = null,
            var center: Node? = null
    )
}

fun main() {
    assertTrue(wordBreak(s = "applepenapple", wordDict = listOf("apple", "pen"))) // true
    assertTrue(wordBreak(s = "leetcode", wordDict = listOf("leet", "code"))) // true
    assertTrue(wordBreak(s = "cars", wordDict = listOf("car", "ca", "rs"))) // true
    assertFalse(wordBreak(s = "aaaaaaa", wordDict = listOf("aaaa", "aa"))) // false
    assertTrue(wordBreak(s = "aaaaaaa", wordDict = listOf("aaaa", "aaa"))) // true

    assertFalse(wordBreak(
            s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
            wordDict = listOf("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"
            ))) // false

    assertTrue(wordBreak(s = "catsandogcat", wordDict = listOf("cats", "dog", "sand", "and", "cat", "an"))) // true
    assertTrue(wordBreak(s = "ab", wordDict = listOf("a", "b"))) // true
}