package stack

class FixedSizeArrayStack(capacity: Int) : Stack<String> {
    private var s = Array<String?>(capacity) { null }
    private var N = 0

    override fun push(item: String) {
        s[N++] = item
    }

    override fun pop(): String? = s[--N]

    override fun isEmpty(): Boolean = N == 0
}

fun main() {
    val stack: Stack<String> = FixedSizeArrayStack(2)

    stack.push("1")
    stack.push("2")

    println(stack.pop())
    println(stack.pop())
    println(stack.isEmpty())
}