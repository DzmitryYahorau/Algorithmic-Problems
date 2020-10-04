package bag

import java.util.*

/**
 * The `Bag` class represents a bag (or multiset) of
 * generic items. It supports insertion and iterating over the
 * items in arbitrary order.
 *
 *
 * This implementation uses a singly linked list with a static nested class Node.
 * The *add*, *isEmpty*, and *size* operations
 * take constant time. Iteration takes time proportional to the number of items.
 *
 *
 * For additional documentation, see [Section 1.3](https://algs4.cs.princeton.edu/13stacks) of
 * *Algorithms, 4th Edition* by Robert Sedgewick and Kevin Wayne.
 *
 * @param <Item> the generic type of an item in this bag
 * @author Robert Sedgewick
 * @author Kevin Wayne
</Item> */
interface Bag<Item> : Iterable<Item> {

    val isEmpty: Boolean

    fun size(): Int

    fun add(item: Item)

    override fun iterator(): Iterator<Item>
}