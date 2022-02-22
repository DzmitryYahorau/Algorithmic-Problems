package backtracking

import hashtable.isValidSudoku
import java.util.*

fun solveSudoku(board: Array<CharArray>) {
    val allDigits = "123456789".toCharArray()
    solve(board, allDigits, 0, 0)
}

fun solve(board: Array<CharArray>, allDigits: CharArray, i: Int, j: Int): Boolean {
    if (i > board.lastIndex) return true

    val changeRow = (j == board.lastIndex)
    val newI = if (changeRow) {
        i + 1
    } else {
        i
    }

    val newJ = if (changeRow) {
        0
    } else {
        j + 1
    }

    if (board[i][j] == '.') {
        val q = LinkedList<Char>()
        q.addAll(allDigits.toList())

        while (q.isNotEmpty()) {
            board[i][j] = q.poll()

            if (checkVertically(board, i) && checkHorizontally(board, j) && checkBox(board, i, j)) {
                val res = solve(board, allDigits, newI, newJ)

                if (res) {
                    return true
                }
            }
            board[i][j] = '.'
        }
    } else {
        val res = solve(board, allDigits, newI, newJ)

        if (res) {
            return true
        }
    }

    return false
}

fun checkBox(board: Array<CharArray>, row: Int, col: Int): Boolean {
    val startI = when(row){
        in 0..2 -> 0
        in 3..5 -> 3
        else -> 6
    }

    val startJ = when(col){
        in 0..2 -> 0
        in 3..5 -> 3
        else -> 6
    }

    val level = mutableSetOf<Char>()
    for (i in startI..startI + 2) {
        for (j in startJ..startJ + 2) {
            if (board[i][j] == '.') continue

            if  (!level.add(board[i][j])){
                return false
            }
        }
    }

    return true
}

fun checkVertically(board: Array<CharArray>, row: Int): Boolean {
    val set = mutableSetOf<Char>()
    val curr = board[row]

    for (char in curr) {
        if (char == '.') continue

        if (char in set) {
            return false
        }
        set.add(char)
    }

    return true
}

fun checkHorizontally(board: Array<CharArray>, col: Int): Boolean {
    val set = mutableSetOf<Char>()
    for (j in 0..board.lastIndex) {
        if (board[j][col] == '.') continue
        if (board[j][col] in set) {
            return false
        }
        set.add(board[j][col])
    }
    return true
}

fun Array<CharArray>.print() {
    println(this.joinToString("\n") { it.joinToString(" ") })
    println()
    println()
}

fun main() {
    val board = arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )
    solveSudoku(
            board = board
    )

    println(isValidSudoku(board))

//   board.forEach {
//       println(it.sorted().joinToString(""))
//   }


    board.print()
}