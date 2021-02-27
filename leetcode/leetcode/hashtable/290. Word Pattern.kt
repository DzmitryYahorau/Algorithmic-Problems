package hashtable

fun wordPattern(pattern: String, s: String): Boolean {
    val map_word = mutableMapOf<String, Char>()
    val map_char = mutableMapOf<Char, String>()

    val words = s.split(' ', ignoreCase = true)

    if (words.size != pattern.length) return false

    for (i in words.indices) {
        val c: Char = pattern[i]
        val w = words[i]
        if (!map_char.containsKey(c)) {
            if (map_word.containsKey(w)) {
                return false
            } else {
                map_char.put(c, w)
                map_word.put(w, c)
            }
        } else {
            val mapped_word: String? = map_char.get(c)
            if (mapped_word != w) return false
        }
    }

    return true
}

fun main() {
    println(wordPattern(pattern = "abba", s = "dog cat cat dog"))
    println(wordPattern(pattern = "abba", s = "dog cat cat fish"))
    println(wordPattern("abba", "dog dog dog dog"))
}
