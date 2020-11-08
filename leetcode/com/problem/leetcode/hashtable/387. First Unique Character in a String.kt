package hashtable

fun firstUniqChar(s: String): Int {
    val map = mutableMapOf<Char, Int>()

    s.forEachIndexed { index, ch ->
        if (!map.contains(ch)) {
            map[ch] = index
        } else {
            map[ch] = -1
        }
    }

    return map.mapNotNull { it.value.takeIf { it >= 0 } }.firstOrNull() ?: -1
}