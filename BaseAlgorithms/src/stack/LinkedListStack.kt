package stack

import java.util.*

class LinkedListStack<Item> : Stack<Item>, Iterable<Item> {
    private var first: Node? = null

    override fun isEmpty(): Boolean =
            (first == null)

    override fun push(item: Item) {
        val oldFirst = first
        first = Node(item = item, next = oldFirst)
    }

    override fun pop(): Item? {
        val item = first?.item
        first = first?.next
        return item
    }

    inner class Node(val item: Item, var next: Node?)

    override fun iterator(): Iterator<Item> = LinkedIterator()

    private inner class LinkedIterator : Iterator<Item> {

        private var current: Node? = first

        override fun hasNext(): Boolean {
            return current != null
        }

        override fun next(): Item {
            val current = current
            if (current == null) {
                throw NoSuchElementException()
            } else {
                val item = current.item
                this.current = current.next
                return item
            }
        }
    }
}

fun main() {
    val stack: Stack<String> = LinkedListStack()

    stack.push("1")
    stack.push("2")

    println(stack.pop())
    println(stack.pop())
    println(stack.isEmpty())
}