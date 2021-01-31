package hashtable

fun isValidSudoku(board: Array<CharArray>): Boolean {

    for (i in board.indices) {
        val column = (0..8).map { j -> board[j][i] }.toCharArray()
        val row = board[i]

        if (!isValid(row) || !isValid(column)) return false
    }

    board.asSequence()
            .chunked(3)
            .map { it.map { it.toList() } }
            .forEach { slice ->
                for (i in 0..8 step 3) {
                    val a = slice[0].subList(i, i + 3)
                    val b = slice[1].subList(i, i + 3)
                    val c = slice[2].subList(i, i + 3)

                    if (!isValid((a + b + c).toCharArray())) return false
                }
            }

    return true
}

fun isValid(chars: CharArray): Boolean =
        chars.filter { it.isDigit() }.distinct().size == chars.filter { it.isDigit() }.size
