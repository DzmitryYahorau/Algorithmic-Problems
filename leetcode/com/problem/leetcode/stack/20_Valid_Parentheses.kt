package stack

import java.util.*

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    for (char in s) {
        when {
            char == '(' -> stack.push(')')
            char == '{' -> stack.push('}')
            char == '[' -> stack.push(']')
            (stack.isEmpty() || stack.pop() != char) -> return false
        }
    }
    return stack.isEmpty()
}