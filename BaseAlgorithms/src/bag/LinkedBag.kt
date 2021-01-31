package bag

/**
 * The `LinkedBag` class represents a bag (or multiset) of
 * generic items. It supports insertion and iterating over the
 * items in arbitrary order.
 *
 *
 * This implementation uses a singly linked list with a non-static nested class Node.
 * See [Bag] for a version that uses a static nested class.
 * The *add*, *isEmpty*, and *size* operations
 * take constant time. Iteration takes time proportional to the number of items.
 *
 *
 * For additional documentation, see [Section 1.3](https://algs4.cs.princeton.edu/13stacks) of
 * *Algorithms, 4th Edition* by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
class LinkedBag<Item> : Bag<Item> {
    private var first: Node<Item>? = null
    private var n = 0

    override val isEmpty: Boolean = first == null

    override fun size(): Int = n

    override fun add(item: Item) {
        val oldFirst: Node<Item>? = first
        first = Node()
        first?.item = item
        first?.next = oldFirst
        n++
    }

    override fun iterator(): Iterator<Item> = LinkedIterator()

    private inner class LinkedIterator : Iterator<Item> {
        private var current: Node<Item>?

        // is there a next item in the iterator?
        override fun hasNext(): Boolean {
            return current != null
        }

        // returns the next item in the iterator (and advances the iterator)
        override fun next(): Item {
            if (!hasNext()) throw NoSuchElementException()
            val item: Item? = current?.item
            current = current?.next
            return item ?: throw NoSuchElementException()
        }

        // creates a new iterator
        init {
            current = first
        }
    }
}
