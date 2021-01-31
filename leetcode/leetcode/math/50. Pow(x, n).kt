package math

fun myPow(x: Double, n: Int): Double =
        if (n < 0) {
            1 / (powerOf(x, -1 * n))
        } else {
            powerOf(x, n)
        }

private fun powerOf(x: Double, n: Int): Double {
    if (n == 0) return 1.0000
    if (n == 1) return x

    val h1 = powerOf(x, n / 2)

    var howManyTooAdd = 1.0
    if (n % 2 != 0) {
        howManyTooAdd = x * (n % 2)
    }

    return h1 * h1 * howManyTooAdd
}

fun main() {
    println(myPow(2.0, 10))
}