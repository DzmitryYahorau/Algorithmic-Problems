package _main_data_structure_impl.symbol_table.BST

import _main_data_structure_impl.queue.ArrayQueue
import _main_data_structure_impl.queue.Queue
import _main_data_structure_impl.symbol_table.SymbolTable

/**
 * [BinarySearchTree] (BST) - binary tree in symmetric order.
 */
class BinarySearchTree : SymbolTable {

    private var root: Node? = null

    override fun put(key: Key, value: Value) {
        root = put(root, key, value)
    }

    override fun get(key: Key): Value? {
        var x: Node? = root
        while (x != null) {
            when {
                (key < x.key) -> x = x.left
                (key > x.key) -> x = x.right
                (key == x.key) -> return x.value
            }
        }
        return null
    }

    /**
     * Lazy approach: put(root, key, null)
     */
    override fun delete(key: Key) {
        root = delete(root, key)
    }

    override fun contains(key: Key): Boolean = get(key) != null

    override fun isEmpty(): Boolean = root == null

    override fun size(): Int = size(root)

    override fun keys(): List<Key> {
        val queue = ArrayQueue<Key>()
        inorderTraversal(root, queue)
        return queue.values()
    }

    /**
     * Returns the largest key ≤ a given key.
     * If no such entry exists, returns [null].
     */
    fun floor(key: Key): Key? = floor(root, key)?.key

    /**
     * How many keys < k.
     */
    fun rank(key: Key): Int = rank(root, key)

    fun deleteMin() {
        root = deleteMin(root)
    }

    private fun put(node: Node?, key: Key, value: Value?): Node {
        if (node == null) return Node(key = key, value = value, count = 0)

        when {
            (key < node.key) -> node.left = put(node.left, key, value)
            (key > node.key) -> node.right = put(node.right, key, value)
            (key == node.key) -> node.value = value
        }
        node.count = 1 + size(node.left) + size(node.right)
        return node
    }

    private fun floor(node: Node?, key: Key): Node? {
        if (node == null) return null

        when {
            key == node.key -> return node
            key < node.key -> return floor(node.left, key)
        }

        val t = floor(node.right, key)
        return t ?: node
    }

    private fun rank(node: Node?, key: Key): Int = when {
        (node == null) -> 0
        (key < node.key) -> rank(node.left, key)
        (key > node.key) -> rank(node.right, key) + size(node.left) + 1
        else -> size(node.left)
    }

    private fun size(node: Node?): Int = node?.count ?: 0

    private fun inorderTraversal(node: Node?, queue: Queue<Key>) {
        if (node == null) return
        inorderTraversal(node.left, queue)
        queue.enqueue(node.key)
        inorderTraversal(node.right, queue)
    }

    /**
     * Hibbard deletion
     */
    private fun delete(node: Node?, key: Key): Node? {
        when {
            (node == null) -> return null
            (key < node.key) -> node.left = delete(node.left, key)
            (key > node.key) -> node.right = delete(node.right, key)
            else -> {
                if (node.right == null) {
                    return node.left
                }

                val t = node
                val temp: Node? = min(t.right)
                temp?.right = deleteMin(t.right)
                temp?.left = t.left
            }
        }
        node.count = 1 + size(node.left) + size(node.right)
        return node
    }

    /**
     *  Loop down to find the leftmost leaf.
     */
    private fun min(node: Node?): Node? {
        var current = node

        while (current?.left != null) {
            current = current.left
        }
        return current
    }

    private fun deleteMin(x: Node?): Node? {
        if (x?.left == null) return x?.right
        x.left = deleteMin(x.left)
        x.count = 1 + size(x.left) + size(x.right)
        return x
    }
}