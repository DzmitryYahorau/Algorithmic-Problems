package hashtable

fun isValidSudoku(board: Array<CharArray>): Boolean {

    for (i in board.indices) {
        val column = (0..8).map { j -> board[j][i] }.toCharArray()
        val row = board[i]

        if (!isValid(row) || !isValid(column)) return false
    }

    val slices = board.asSequence().chunked(3)

    slices.forEach { slice ->
        for (i in 0..8 step 3) {
            val a = slice[0].toList().subList(i, i + 3)
            val b = slice[1].toList().subList(i, i + 3)
            val c = slice[2].toList().subList(i, i + 3)

            if (!isValid((a + b + c).toCharArray())) return false
        }
    }

    return true
}

fun isValid(sequence: CharArray): Boolean {
    val rowSet = mutableSetOf<Int>()
    sequence.asSequence()
            .filter { it.isDigit() }
            .map { Character.getNumericValue(it) }
            .forEach { num ->
                if (!rowSet.contains(num)) {
                    rowSet.add(num)
                } else {
                    return false
                }
            }

    return true
}