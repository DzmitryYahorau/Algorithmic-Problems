package stack

import java.util.*

fun minOperations(logs: Array<String>): Int {
    val stack = Stack<String>()

    logs.forEach { log ->
        when (log) {
            "../" -> if (stack.isNotEmpty()) stack.pop()
            "./" -> {
            }
            else -> {
                stack.push(log)
            }
        }
    }

    return stack.size
}

/**
// Same solution, butt without stack

fun minOperations(logs: Array<String>): Int {
var counter = 0

logs.forEach { log ->
when (log) {
"../" -> counter = maxOf(0, counter - 1)
"./" -> Unit // Do nothing
else -> counter++
}
}

return counter
}
 */