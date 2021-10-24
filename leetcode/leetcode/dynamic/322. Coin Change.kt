package dynamic

import kotlin.system.measureTimeMillis

fun coinChange(coins: IntArray, amount: Int): Int {
    if (amount == 0) return 0

    coins.sortDescending()

    val result = mutableMapOf<Int, Int>()

    change(coins = coins, amount = amount, start = 0, temp = 0, result = result)

    return result.getOrDefault(0, -1)
}

private fun change(coins: IntArray, amount: Int, start: Int, temp: Int, result: MutableMap<Int, Int>) {
    if (amount < 0) {
        return
    }

    for (i in start..coins.lastIndex) {
        if (result.getOrDefault(amount - coins[i], Int.MAX_VALUE) <= temp + 1) {
            continue
        }

        result[amount - coins[i]] = temp + 1
        change(coins, amount - coins[i], i, temp + 1, result)
    }
}

fun main() {
    println(coinChange(intArrayOf(1, 2, 5), 11))
    println(coinChange(intArrayOf(2), 3))
    println(coinChange(intArrayOf(1), 0))
    println(coinChange(intArrayOf(1), 1))
    println(coinChange(intArrayOf(1), 2))
    println(coinChange(intArrayOf(186, 419, 83, 408), 6249))
    println(coinChange(intArrayOf(3, 7, 405, 436), 8839))
    measureTimeMillis {
        println(coinChange(intArrayOf(411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422), 9864)) // <- test #39
    }.also {
        print(it)
    }
}