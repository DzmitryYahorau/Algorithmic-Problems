package queue

class ArrayQueue<Item : Any> : Queue<Item> {

    private var q: Array<Item?> = arrayOfNulls<Any?>(1) as Array<Item?>
    private var head = 0
    private var tail = 0

    override fun enqueue(item: Item) {
        if (tail == q.size) {
            resize(newCapacity = q.size * 2)
        }

        q[tail++] = item
    }

    override fun dequeue(): Item? {
        val item = q[head]
        q[head++] = null

        if (tail > 0 && tail == q.size / 4) {
            resize(newCapacity = q.size / 2)
        }

        return item
    }

    override fun isEmpty(): Boolean = head == tail

    fun values(): List<Item> = q.mapNotNull { it }

    private fun resize(newCapacity: Int) {
        val copy: Array<Item?> = arrayOfNulls<Any?>(newCapacity) as Array<Item?>
        for (i in q.indices) {
            copy[i] = q[i]
        }
        q = copy
    }
}

fun main() {
    val queue: Queue<String> = ArrayQueue()

    queue.enqueue("1")
    queue.enqueue("2")
    queue.enqueue("3")

    println(queue.dequeue())
    println(queue.dequeue())
    println(queue.dequeue())

    println(queue.isEmpty())
}
