package backtracking

fun exist(board: Array<CharArray>, word: String): Boolean {
    for (i in board.indices) {
        for (j in board[i].indices) {
            if (backtracking(board, i, j, word, 0)) return true
        }
    }
    return false
}

private fun backtracking(board: Array<CharArray>, i: Int, j: Int, word: String, letterIndex: Int): Boolean {
    if (letterIndex == word.length) return true

    if ((i !in board.indices) || (j !in board[i].indices) || board[i][j] != word[letterIndex]) return false

    board[i][j] = '*'

//    condition1 || condition2 || condition3 || condition4
//    will return true as soon as a condition returned true, and the rest conditions are not even calculated.
    val result = backtracking(board, i, j + 1, word, letterIndex + 1)
            || backtracking(board, i, j - 1, word, letterIndex + 1)
            || backtracking(board, i + 1, j, word, letterIndex + 1)
            || backtracking(board, i - 1, j, word, letterIndex + 1)

    board[i][j] = word[letterIndex]

    return result
}

