package _main_data_structure_impl.stack

class ResizingArrayStack : Stack {

    private var s = Array<String?>(size = 1) { null }
    private var N: Int = 0

    override fun push(item: String) {
        if (N == s.size) {
            resize(newCapacity = s.size * 2)
        }
        s[N++] = item
    }

    override fun pop(): String? {
        val item = s[--N]
        s[N] = null
        if (N > 0 && N == s.size / 4) {
            resize(newCapacity = s.size / 2)
        }

        return item
    }

    override fun isEmpty(): Boolean = N == 0

    private fun resize(newCapacity: Int) {
        val copy = Array<String?>(newCapacity) { null }
        for (i in 0 until N) {
            copy[i] = s[i]
        }
        s = copy
    }
}

fun main() {
    val stack: Stack = ResizingArrayStack()

    stack.push("1")
    stack.push("2")

    println(stack.pop())
    println(stack.pop())
    println(stack.isEmpty())
}