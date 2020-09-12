package stack

import java.util.*

class Solution394 {

    fun decodeString(s: String): String {
        var res = ""
        val numbers = ArrayDeque<Int>()
        val resultStack = ArrayDeque<String>()

        var i = 0
        while (i in s.indices) {
            when {
                s[i].isDigit() -> {
                    var number = ""
                    while (s[i].isDigit()) {
                        number += s[i]
                        i++
                    }
                    numbers.push(number.toInt())
                }
                s[i].isLetter() -> res += s[i++]
                (s[i] == '[') -> {
                    resultStack.push(res)
                    res = ""
                    i++
                }
                (s[i] == ']') -> {
                    val substring = resultStack.pop()
                    val repeatTimes = numbers.pop()

                    val temp = StringBuilder().apply {

                        append(substring)

                        repeat(repeatTimes) {
                            append(res)
                        }
                    }.toString()

                    res = temp
                    i++
                }
            }
        }

        return res
    }
}