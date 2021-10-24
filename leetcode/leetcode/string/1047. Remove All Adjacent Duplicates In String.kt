package string

import java.util.*

// #time_out > 15 min, wrong understand condition, should be like brackets,
// not just closest
// second try with stack, ~1-2 min to implement
fun removeDuplicates(s: String): String {
    val st = Stack<Char>()
    for (char in s) {
        if (st.isNotEmpty() && st.peek() == char) {
            st.pop()
        } else {
            st.push(char)
        }
    }
    return st.joinToString("") {
        it.toString()
    }

}

fun main() {
    println(removeDuplicates("aababaab"))
    println(removeDuplicates("abbaca"))
}