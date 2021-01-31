package math

import java.lang.StringBuilder
import java.util.*

class Solution415 {

    fun addStrings(num1: String, num2: String): String {
        val newStack = fillStack(num1, num2)
        return newStack.creteString()
    }

    private fun fillStack(str: String, str2: String): Stack<Int> {
        val stack = Stack<Int>()
        var addOne = 0

        var j = str.lastIndex
        var k = str2.lastIndex

        while (addOne > 0 || j >= 0 || k >= 0) {
            val first = if (j >= 0) str[j].intValue else 0
            val second = if (k >= 0) str2[k].intValue else 0

            val result = first + second + addOne
            addOne = 0

            if (result >= 10) {
                stack.push(result % 10)
                addOne++
            } else {
                stack.push(result)
            }

            j--
            k--
        }
        return stack
    }

    private fun Stack<Int>.creteString(): String {
        val result = StringBuilder()
        while (this.isNotEmpty()) {
            result.append(this.pop())
        }

        return result.toString()
    }

    private val Char.intValue: Int
        get() = Character.getNumericValue(this)
}

fun main() {
    val input = "98"
    val input2 = "9"
    println(Solution415().addStrings(input, input2))
}