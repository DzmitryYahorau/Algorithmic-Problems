package hashtable

fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val map = mutableMapOf<Char, Int>()
    for (char in s) {
        map[char] = map[char]?.plus(1) ?: 1
    }

    for (char in t) {
        map[char] = map[char]?.minus(1) ?: 0
    }

    return !map.any { (_, v) -> v != 0 }
}

// with lambda
fun isAnagram1(s: String, t: String): Boolean {
    val countChars: (input: String) -> Map<Char, Int> = {
        val charMap = mutableMapOf<Char, Int>()
        it.forEach { c -> charMap[c] = charMap[c]?.plus(1) ?: 1 }
        charMap
    }

    return countChars(s) == countChars(t)
}