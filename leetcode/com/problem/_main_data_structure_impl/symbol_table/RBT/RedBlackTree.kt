package _main_data_structure_impl.symbol_table.RBT

import _main_data_structure_impl.symbol_table.RBT.LeafColor.*
import _main_data_structure_impl.symbol_table.SymbolTable

class RedBlackTree : SymbolTable {

    private var root: Node? = null

    override fun put(key: Key, value: Value) {
        root = put(root, key, value)
    }

    override fun get(key: Key): Value? {
        var x = root
        while (x != null) {
            when {
                (key < x.key) -> x = x.left
                (key > x.key) -> x = x.right
                (key == x.key) -> return x.value
            }
        }
        return null
    }

    override fun delete(key: Key) {
        root = delete(root, key)
    }

    override fun contains(key: Key): Boolean = (get(key) != null)

    override fun isEmpty(): Boolean = (root == null)

    override fun size(): Int {
        TODO("Not yet implemented")
    }

    override fun keys(): List<Key> {
        TODO("Not yet implemented")
    }

    private fun put(node: Node?, key: Key, value: Value): Node? {
        when {
            (node == null) -> return Node(key = key, value = value, color = RED)
            (key < node.key) -> node.left = put(node.left, key, value)
            (key > node.key) -> node.right = put(node.right, key, value)
            else -> node.value = value
        }

        return when {
            !(node.left.isRed()) && (node.right.isRed()) -> node.rotateLeft()
            (node.left.isRed()) && (node.left?.left.isRed()) -> node.rotateRight()
            (node.left.isRed()) && (node.right.isRed()) -> node.flipColors()
            else -> null
        }
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
        return x
    }
}

private fun Node.rotateLeft(): Node? {
    assert(this.right.isRed())

    val x = this.right
    this.right = x?.left
    x?.left = this
    x?.color = this.color
    this.color = RED

    return x
}

private fun Node.rotateRight(): Node? {
    assert(this.left.isRed())

    val x = this.left
    this.left = x?.right
    x?.right = this
    x?.color = this.color
    this.color = RED

    return x
}

private fun Node?.flipColors(): Node? {
    assert(!this.isRed())
    assert(this?.left.isRed())
    assert(this?.right.isRed())

    this?.color = RED
    this?.left?.color = BLACK
    this?.right?.color = BLACK

    return this
}
