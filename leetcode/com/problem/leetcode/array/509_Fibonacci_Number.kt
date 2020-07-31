package array

class FibonacciNumber {

    fun fib(N: Int): Int =
            when (N) {
                0    -> 0
                1    -> 1
                else -> (fib(N - 1) + fib(N - 2))
            }
}

fun main() {
    val input = 2
    println(FibonacciNumber().fib(input))
}


