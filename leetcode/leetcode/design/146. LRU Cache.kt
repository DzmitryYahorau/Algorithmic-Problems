package design

class LRUCache(private val capacity: Int) {

    private val mapCache: HashMap<Int, Node?> = HashMap(capacity)

    private val head: Node? = Node(-1, -1)
    private var tail: Node? = Node(-1, -1)

    init {
        head?.next = tail
        tail?.prev = head
    }

    fun get(key: Int): Int {
        val node = mapCache[key]

        node?.increaseUseOrder()

        return node?.value ?: -1
    }

    fun put(key: Int, value: Int) {
        val node = mapCache[key]

        if (node != null) {
            node.value = value
            node.increaseUseOrder()
        } else {
            if (mapCache.size == capacity) {
                mapCache.remove(tail?.prev?.key)
                remove(tail?.prev)
            }

            val newNode = Node(key, value)
            mapCache[key] = newNode

            add(newNode)
        }
    }

    private fun Node.increaseUseOrder() {
        remove(this)
        add(this)
    }

    private fun add(node: Node) {
        val oldNext = head?.next

        head?.next = node
        oldNext?.prev = node

        node.prev = head
        node.next = oldNext
    }

    private fun remove(node: Node?) {
        val prev = node?.prev
        val next = node?.next

        prev?.next = next
        next?.prev = prev
    }

    private class Node(val key: Int, var value: Int, var prev: Node? = null, var next: Node? = null)
}

fun main() {
    val lruCache = LRUCache(2)
    /*
    ["LRUCache","put","put","get","put","get","put","get","get","get"]
    [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
    */
    with(lruCache) {
        put(1, 1)
        put(2, 2)
        get(1)
        put(3, 3)
        get(2)
        put(4, 4)
        get(1)
        get(3)
        get(4)
    }

}