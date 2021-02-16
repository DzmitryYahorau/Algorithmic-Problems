package backtracking

fun generateParenthesis(n: Int): List<String> {
    val result = mutableListOf<String>()

    generateParenthesis(n, "", result, 0, 0)
    return result
}

fun generateParenthesis(
        n: Int,
        current: String,
        result: MutableList<String>,
        open: Int,
        close: Int
) {
    //GOAL
    if (current.length == n * 2) {
        result.add(current)
        return
    }

    if (open < n) {
        generateParenthesis(n, current + "(", result, open + 1, close)
    }

    if (close < open) {
        generateParenthesis(n, current + ")", result, open, close + 1)
    }
}