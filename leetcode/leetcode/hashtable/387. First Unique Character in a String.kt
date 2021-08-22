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

/**
 * since @param [s] consists of only lowercase English letters.
 * Can be done without hashmap.
 * Works faster, O(26) = O(1)
 */
fun firstUniqChar2(s: String): Int {
    val arr = Array<Int>(26) { 0 }

    for (i in s.indices){
        val charIndex = s[i] - 'a'
        arr[charIndex]++
    }

    for (i in s.indices){
        val charIndex = s[i] - 'a'
        if (arr[charIndex] == 1){
            return i
        }
    }

    return -1
}
fun main() {
    println(firstUniqChar2("loveleetcode"))
}