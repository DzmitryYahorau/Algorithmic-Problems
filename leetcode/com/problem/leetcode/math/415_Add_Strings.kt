package math

import java.lang.StringBuilder

class Solution415 {

    fun addStrings(num1: String, num2: String): String {
        var i = minOf(num1.length, num2.length)
        val result = StringBuilder()

        while (i >= 0) {

            i--
        }
        return result.toString()
    }
}

fun main() {
    val input = "1"
    val input2 = "1"
    println(Solution415().addStrings(input, input2))
}