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

//iterative solution - #time_out #checked_solution
fun backspaceCompare2(S: String, T: String): Boolean {
    var i = S.length - 1
    var j = T.length - 1
    var skipS = 0
    var skipT = 0
    while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
        while (i >= 0) { // Find position of next possible char in build(S)
            if (S[i] == '#') {
                skipS++
                i--
            } else if (skipS > 0) {
                skipS--
                i--
            } else break
        }
        while (j >= 0) { // Find position of next possible char in build(T)
            if (T[j] == '#') {
                skipT++
                j--
            } else if (skipT > 0) {
                skipT--
                j--
            } else break
        }
        // If two actual characters are different
        if (i >= 0 && j >= 0 && S[i] != T[j]) return false
        // If expecting to compare char vs nothing
        if (i >= 0 != j >= 0) return false
        i--
        j--
    }
    return true
}

fun main() {
    println(backspaceCompare2("ab##", "c#d#"))
}