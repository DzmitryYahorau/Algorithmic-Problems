package string

fun fizzBuzz(n: Int): List<String> =
        (1..n).map { i -> i.calculateString() }

private fun Int.calculateString(): String =
        when {
            this % 15 == 0 -> "FizzBuzz"
            this % 5 == 0 -> "Buzz"
            this % 3 == 0 -> "Fizz"
            else -> this.toString()
        }