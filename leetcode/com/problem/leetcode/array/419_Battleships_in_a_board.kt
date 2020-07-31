package array

class BattleShipsInABoard {

    fun countBattleships(board: Array<CharArray>): Int {
        var shipsInABoard = 0
        for (i in board.indices) {
            for (j in board[i].indices) {
                if (board[i][j].isShip()) {
                    if (
                            ((i == 0) || (!board[i - 1][j].isShip()))
                            && ((j == 0) || (!board[i][j - 1].isShip()))
                    ) {
                        shipsInABoard++
                    }
                }
            }
        }
        return shipsInABoard
    }

    private fun Char.isShip(): Boolean =
            this == 'X'
}

fun main() {
    val input = arrayOf(
            charArrayOf('X', '.', '.', 'X'),
            charArrayOf('.', '.', '.', 'X'),
            charArrayOf('.', '.', '.', 'X')
    )
    println(BattleShipsInABoard().countBattleships(input))
}