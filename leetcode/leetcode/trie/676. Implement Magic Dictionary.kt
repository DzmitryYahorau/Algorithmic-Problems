package trie

class MagicDictionary() {

    /** Initialize your data structure here. */
    lateinit var trie: Trie

    fun buildDict(dictionary: Array<String>) {
        trie = Trie(dictionary)
    }

    fun search(searchWord: String): Boolean {
        return false
    }

}