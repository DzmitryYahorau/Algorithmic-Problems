package backtracking

fun partition(s: String): List<List<String>> {
    val result = mutableListOf<List<String>>()
    backtracking(s, result, mutableListOf(), 0)
    return result
}

private fun backtracking(s: String, result: MutableList<List<String>>, current: MutableList<String>, start: Int) {
    if (start == s.length) {
        result.add(current.toList())
        return
    }

    for (end in start until s.length) {

        if (s.isPalindrome(start, end)) {
            current.add(s.substring(start, end + 1))
            backtracking(s, result, current, end + 1)
            // backtrack and remove the current substring from current
            current.removeAt(current.size - 1)
        }
    }
}

private fun String.isPalindrome(start: Int, end: Int): Boolean {
    if (this.isEmpty()) return false
    var lo = start
    var hi = end

    while (lo < hi) {
        if (this[lo] != this[hi]) {
            return false
        }
        lo++
        hi--
    }

    return true
}

fun main() {
    val input = "aab"

    println(partition(input).joinToString())
}