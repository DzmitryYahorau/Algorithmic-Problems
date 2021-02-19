package array

import kotlin.test.assertEquals

//check Kadans' alg,
fun maxProfit(prices: IntArray): Int {
    if (prices.size < 2) return 0

    var maxProfit = 0
    var bestPriceToBuy = Int.MAX_VALUE

    prices.forEach { price ->
        when {
            (price < bestPriceToBuy) -> bestPriceToBuy = price
            ((price - bestPriceToBuy) > maxProfit) -> maxProfit = price - bestPriceToBuy
        }
    }

    return maxProfit
}


fun main() {
    assertEquals(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)), 5)
    assertEquals(maxProfit(intArrayOf(7, 6, 4, 3, 1)), 0)
    assertEquals(maxProfit(intArrayOf(2, 4, 1)), 2)
    assertEquals(maxProfit(intArrayOf(1, 2)), 1)
    assertEquals(actual = maxProfit(intArrayOf(2, 1, 2, 0, 1)), expected = 1)
}