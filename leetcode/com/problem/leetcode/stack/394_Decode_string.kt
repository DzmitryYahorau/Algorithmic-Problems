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
                s[i].isDigit() -> numbers.push(Character.getNumericValue(s[i++]))
                s[i].isLetter() -> res += s[i++]
                (s[i] == '[') -> {
                    resultStack.push(res)
                    res = ""
                    i++
                }
                (s[i] == ']') -> {
                    val temp = StringBuilder()

                    val substring = resultStack.pop()
                    val repeatTimes = numbers.pop()

                    temp.append(substring)

                    repeat(repeatTimes) {
                        temp.append(res)
                    }

                    res = temp.toString()
                    i++
                }
            }
        }

        return res
    }
}