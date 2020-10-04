package _main_data_structure_impl.stack

import java.util.*

/**
 * The `ResizingArrayStack` class represents a last-in-first-out (LIFO) stack
 * of generic items.
 * It supports the usual *push* and *pop* operations, along with methods
 * for peeking at the top item, testing if the stack is empty, and iterating through
 * the items in LIFO order.
 *
 *
 * This implementation uses a resizing array, which double the underlying array
 * when it is full and halves the underlying array when it is one-quarter full.
 * The *push* and *pop* operations take constant amortized time.
 * The *size*, *peek*, and *is-empty* operations takes
 * constant time in the worst case.
 *
 *
 * For additional documentation,
 * see [Section 1.3](https://algs4.cs.princeton.edu/13stacks) of
 * *Algorithms, 4th Edition* by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
class ResizingArrayStack<Item> : Stack<Item>, Iterable<Item> {

    private var a: Array<Item?> = arrayOfNulls<Any>(2) as Array<Item?>

    /**
     *   number of elements on stack
     */
    private var n: Int = 0

    override fun isEmpty(): Boolean = (n == 0)

    override fun push(item: Item) {
        if (n == a.size) resize(2 * a.size) // double size of array if necessary
        a[n++] = item // add item
    }

    override fun pop(): Item? {
        if (isEmpty()) throw NoSuchElementException("Stack underflow")
        val item = a[n - 1]
        a[n - 1] = null // to avoid loitering
        n--
        // shrink size of array if necessary
        if (n > 0 && n == a.size / 4) resize(a.size / 2)
        return item
    }

    private fun resize(capacity: Int) {
        assert(capacity >= n)
        a = a.copyOf(capacity)
    }

    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     */
    override fun iterator(): Iterator<Item> = ReverseArrayIterator()

    private inner class ReverseArrayIterator : Iterator<Item> {
        private var i: Int = n - 1

        override fun hasNext(): Boolean {
            return i >= 0
        }

        override fun next(): Item {
            if (!hasNext()) throw NoSuchElementException()
            return a[i--]!!
        }
    }
}

fun main() {
    val stack: Stack<String> = ResizingArrayStack<String>()

    stack.push("1")
    stack.push("2")

    println(stack.pop())
    println(stack.pop())
    println(stack.isEmpty())
}