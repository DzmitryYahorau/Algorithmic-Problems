package dynamic

fun maximumProduct(nums: IntArray): Int {
    val sorted = nums.sortedDescending()

    val max = sorted.first()
    val min = sorted.last()
    val productOfMax = max * sorted[1] * sorted[2]
    val productOfMin = max * min * sorted[sorted.lastIndex - 1]

    return maxOf(productOfMax, productOfMin)
}

fun main() {
    val input = intArrayOf(-100, -98, -1, 2, 3, 4)
    println(maximumProduct(input))
}