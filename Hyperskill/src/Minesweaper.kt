package utils

import java.util.*
import kotlin.random.Random

private const val MINE = "X"
private const val SPACE = "."

fun main(args: Array<String>) {

    val size = 9
    val board = Array(size) { Array(size) { SPACE } }
    val scanner = Scanner(System.`in`)

    var minesCount = scanner.nextInt()

    while (minesCount > 0 ){

        minesCount--
    }

    for (i in 0 until size) {
        val line = StringBuilder()
        val mineIndex = Random.nextInt(0, 9)
        for (j in 0 until size) {
            line.append(if (j == mineIndex){
                MINE
            } else {
                SPACE
            })
        }
        println(line.toString())
    }
//    .X.......
//    .....X..X
//    ....X....
//    ......X..
//    ..X......
//    ....X....
//    ..X......
//    ..X......
//    ......X..
}