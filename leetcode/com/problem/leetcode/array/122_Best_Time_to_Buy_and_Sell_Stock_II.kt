package array

class Solution {

    private var lowPrice = -1 // not use 0!, can be in input set
    private var profit = 0

    fun maxProfit(prices: IntArray): Int {
        var prevPrice = prices.first()

        for (i in 1 until prices.size) {
            val price = prices[i]
            val isLastPrice = (i == prices.lastIndex)

            if ((price > prevPrice) && !hasStocks()) {
                buy(prevPrice)
            }

            if ((price < prevPrice) && hasStocks()) {
                sell(prevPrice)
            }


            if ((price >= prevPrice) && hasStocks() && isLastPrice) {
                sell(price)
            }

            prevPrice = price
        }
        return profit
    }

    private fun hasStocks(): Boolean = lowPrice != -1

    private fun buy(price: Int) {
        lowPrice = price
    }

    private fun sell(price: Int) {
        profit += (price - lowPrice)
        lowPrice = -1
    }
}

fun main() {

//    val input = intArrayOf(7, 1, 5, 3, 6, 4)
//    val input = intArrayOf(1, 2, 3, 4, 5)
//    val input = intArrayOf(7, 6, 4, 3, 1)
//    val input = intArrayOf(1, 2)
//    val input = intArrayOf(2, 1, 2, 0, 1)
    val input = intArrayOf(1, 9, 6, 9, 1, 7, 1, 1, 5, 9, 9, 9)

    println(Solution().maxProfit(input))
}