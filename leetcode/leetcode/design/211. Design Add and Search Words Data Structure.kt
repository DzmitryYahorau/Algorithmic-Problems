package design

//trie with wildcard
class WordDictionary() {

    /** Initialize your data structure here. */
    private val trie = TrieST()

    fun addWord(word: String) {
        trie.insert(word)
    }

    fun search(word: String): Boolean {
        return trie.keysThatMatch(word)
    }

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

        /**
         * Returns true if there is any string that matches pattern or false otherwise.
         * word may contain dots '.' where dots can be matched with any letter.
         * */
        fun keysThatMatch(pattern: String): Boolean =
                keysThatMatch(rootNodes, pattern)

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

        private fun keysThatMatch(
                nodes: List<TrieNode>,
                pattern: String
        ): Boolean {
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

}