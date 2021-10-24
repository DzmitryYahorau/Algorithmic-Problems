package stack

import java.util.*

//Smart and clean solution!
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

//took ~ 15 min, test case forgot to check - "["
fun isValid2(s: String): Boolean {
    var stack = Stack<Char>()

    for(char in s){
        when(char){
            '(', '[', '{' -> stack.push(char)
            ')' -> {
                var isValid = checkChar(stack, '(')
                if (!isValid){
                    return false
                }
            }
            ']' -> {
                var isValid = checkChar(stack, '[')
                if (!isValid){
                    return false
                }

            }
            '}' -> {
                var isValid = checkChar(stack, '{')
                if (!isValid){
                    return false
                }
            }
        }
    }

    return stack.isEmpty()
}

private fun checkChar(stack: Stack<Char>, openChar: Char) : Boolean {
    if (stack.isEmpty()){
        return false
    }

    var last = stack.pop()

    return (openChar == last)
}