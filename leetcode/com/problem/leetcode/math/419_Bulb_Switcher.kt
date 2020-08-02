package math

import kotlin.math.sqrt

//https://leetcode.com/problems/bulb-switcher/discuss/77112/share-my-o1-solution-with-explanation
fun bulbSwitch(n: Int): Int = sqrt(n.toDouble()).toInt()

//too slow, answer is correct, but time limit exception
fun bulbSwitch2(n: Int): Int {
    if (n == 0) return 0

    val arr = BooleanArray(n) { true }


    var step = 1
    for (i in 2..n) {
        while (step <= n) {
            arr[step - 1] = !arr[step - 1]
            step += i
        }
    }
    return arr.getTrueCount()
}

private fun BooleanArray.getTrueCount(): Int {
    var count = 0
    for (i in this.indices) {
        if (this[i]) {
            count++
        }
    }
    return count
}

fun main() {
//    val input = 3
    val input = 99999999
    println(bulbSwitch(input))
}