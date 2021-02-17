package backtracking

fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) return emptyList()

    val result = mutableSetOf<String>()

    backtracking(digits, 0, "", result)

    return result.toList()
}

private fun backtracking(digits: String, index: Int, current: String, result: MutableSet<String>) {
    if (index == digits.length) {
        result.add(current)
        return
    }

    val letters: String = mapping[digits[index]] ?: return

    for (i in 0..letters.lastIndex) {
        backtracking(
                digits,
                index + 1,
                current + letters[i],
                result
        )
    }
}

private val mapping: Map<Char, String> =
        mapOf(
                '0' to "",
                '1' to "",
                '2' to "abc",
                '3' to "def",
                '4' to "ghi",
                '5' to "jkl",
                '6' to "mno",
                '7' to "pqrs",
                '8' to "tuv",
                '9' to "wxyz"
        )

fun main() {
    println(letterCombinations("23"))
}
