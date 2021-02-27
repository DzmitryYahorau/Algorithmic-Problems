package string

import java.util.*

fun backspaceCompare(S: String, T: String): Boolean =
        fillStack(S) == fillStack(T)

private fun fillStack(string: String): Stack<Char> {
    val stack = Stack<Char>()

    string.forEach {
        if (it == '#') {
            if (stack.isNotEmpty()) {
                stack.pop()
            }
        } else {
            stack.push(it)
        }
    }
    return stack
}