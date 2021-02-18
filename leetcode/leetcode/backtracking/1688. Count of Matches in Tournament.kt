package backtracking

fun numberOfMatches(n: Int, result: Int = 0): Int {
    if (n == 1) return result
    return if (n % 2 == 0) {
        numberOfMatches(n / 2, result + n / 2)
    } else {
        numberOfMatches(n / 2 + 1, result + n / 2)
    }
}