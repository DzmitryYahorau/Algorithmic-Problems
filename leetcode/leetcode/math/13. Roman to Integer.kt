package math

/*
*

I             1
V             5
X             10
L             50
C             100
D             500
M             1000

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.

* * */

fun romanToInt(s: String): Int {
    val result = mutableListOf<Int>()

    var i = 0
    while (i in s.indices) {
        val num = s[i].toArabic()
        val next = s.getOrNull(i + 1)?.toArabic()

        when {
            (num == 1) && (next == 5) -> result.add(4).also { i++ }
            (num == 1) && (next == 10) -> result.add(9).also { i++ }
            (num == 10) && (next == 50) -> result.add(40).also { i++ }
            (num == 10) && (next == 100) -> result.add(90).also { i++ }
            (num == 100) && (next == 500) -> result.add(400).also { i++ }
            (num == 100) && (next == 1000) -> result.add(900).also { i++ }
            else -> result.add(num)
        }

        i++
    }

    return result.sum()
}

fun Char.toArabic(): Int =
        when (this) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> 0
        }

fun main() {
//    println(romanToInt("IX"))
    println(romanToInt("III"))
}