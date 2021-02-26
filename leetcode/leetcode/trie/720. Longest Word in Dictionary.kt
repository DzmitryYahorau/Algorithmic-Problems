package trie

fun longestWord(words: Array<String>): String {
    var result = ""
    val trie = Trie(words)

    //iterate through words
    words.forEach { word ->

        //iterate through word characters
        for (i in word.indices) {

            if (!trie.containsKey(word.slice(0..i))) {
                break
            }

            //if it is in dictionary
            // and it's length is same or higher than result
            // and it's
            if (i == word.lastIndex) {

                val condition: Boolean = when {
                    (i > result.lastIndex) -> true
                    (i < result.lastIndex) -> false
                    (i == result.lastIndex) -> (word < result)
                    else -> false
                }

                if (condition) {
                    result = word
                }
            }
        }
    }

    return result
}

class Trie(words: Array<String>) {

    private var root: StringNode? = null

    init {
        //preprocess, create TST
        words.forEach { word ->
            root = put(root, word, word, 0)
        }
    }

    fun containsKey(key: String): Boolean = get(root, key, 0) != null

    private fun put(x: StringNode?, key: String, value: String, d: Int): StringNode {
        val c = key[d]
        val storedValue = if (d == key.lastIndex) {
            value
        } else {
            null
        }
        val node = x ?: StringNode(char = c, value = storedValue)

        when {
            c < node.char -> node.left = put(node.left, key, value, d)
            c > node.char -> node.right = put(node.right, key, value, d)
            d < key.lastIndex -> node.middle = put(node.middle, key, value, d + 1)
            else -> node.value = value
        }

        return node
    }

    private fun get(node: StringNode?, key: String, d: Int): StringNode? {
        if (node == null) return null

        val c = key[d]

        return when {
            c < node.char -> get(node.left, key, d)
            c > node.char -> get(node.right, key, d)
            d < key.lastIndex && node.value != null -> get(node.middle, key, d + 1)
            d == key.lastIndex && node.value != null -> node
            else -> null
        }
    }

    class StringNode(
            val char: Char,
            var value: String?,
            var left: StringNode? = null,
            var middle: StringNode? = null,
            var right: StringNode? = null
    )
}

/*

Faster and simpler solution
fun longestWord(words: Array<String>): String {

    val set = mutableSetOf<String>()

    words.sorted().forEach {
        if (it.length == 1 || set.contains(it.dropLast(1))) set.add(it)
    }

    return set.maxBy { it.length }!!
}
*/

fun main() {
    println("result:" + longestWord(words = arrayOf("w", "wo", "wor", "worl", "world")))
    println("result:" + longestWord(words = arrayOf("a", "banana", "app", "appl", "ap", "apply", "apple")))
    println("result:" + longestWord(words = arrayOf("m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca", "cat")))
}