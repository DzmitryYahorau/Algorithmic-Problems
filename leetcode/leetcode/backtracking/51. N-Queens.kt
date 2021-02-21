package backtracking

fun solveNQueens(n: Int): List<List<String>> {
    val result = mutableListOf<List<String>>()
    backtracking(n, result, MutableList(n) { CharArray(n) { '.' } }, 0, 0)
    return result
}

private fun backtracking(n: Int, result: MutableList<List<String>>, current_board: MutableList<CharArray>, index: Int, queensAdded: Int) {

    if (n == queensAdded) {
        result.add(current_board.map { it.joinToString("") })
        return
    }

    for (i in index..current_board.lastIndex) {
        for (j in 0..current_board.lastIndex) {
            current_board[i][j] = 'Q'
            if (isValid(current_board, i, j)) {
                backtracking(n, result, current_board.toMutableList(), i + 1, queensAdded + 1)
            }
            current_board[i][j] = '.'
        }
    }
}

fun isValid(current_board: List<CharArray>, i: Int, j: Int): Boolean {
    if (current_board[i][j] != 'Q') return false

    //check row
    for (rowIndex in 0..current_board[i].lastIndex) {
        if (rowIndex != j && current_board[i][rowIndex] == 'Q') {
            return false
        }
    }

    //check column
    for (columnIndex in 0..i) {
        if (columnIndex != i && current_board[columnIndex][j] == 'Q') {
            return false
        }
    }

    //check diagonals

    var startI = i - 1
    var leftJ = j - 1
    var rightJ = j + 1

    while (startI >= 0) {
        if (leftJ >= 0 && current_board[startI][leftJ] == 'Q') {
            return false
        }

        if (rightJ <= current_board.lastIndex && current_board[startI][rightJ] == 'Q') {
            return false
        }

        leftJ--
        rightJ++
        startI--
    }

    return true
}

fun main() {
    println(solveNQueens(4).joinToString("\n\n") { it.joinToString("\n") })
}