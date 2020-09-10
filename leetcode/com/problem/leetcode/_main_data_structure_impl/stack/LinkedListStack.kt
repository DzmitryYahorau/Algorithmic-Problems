package _main_data_structure_impl.stack

class LinkedListStack : Stack {
    private var first: Node? = null

    override fun isEmpty(): Boolean =
            first == null

    override fun push(item: String) {
        val oldFirst = first
        first = Node(item = item, next = oldFirst)
    }

    override fun pop(): String? {
        val item = first?.item
        first = first?.next
        return item
    }
}

fun main() {
    val stack: Stack = LinkedListStack()

    stack.push("1")
    stack.push("2")

    println(stack.pop())
    println(stack.pop())
    println(stack.isEmpty())
}