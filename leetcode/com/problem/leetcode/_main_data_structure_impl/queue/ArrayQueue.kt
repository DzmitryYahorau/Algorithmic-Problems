package _main_data_structure_impl.queue

class ArrayQueue : Queue {

    private var q = Array<String?>(1) { null }
    private var head = 0
    private var tail = 0

    override fun enqueue(item: String) {
        if (tail == q.size) {
            resize(newCapacity = q.size * 2)
        }

        q[tail++] = item
    }

    override fun dequeue(): String? {
        val item = q[head]
        q[head++] = null

        if (tail > 0 && tail == q.size / 4) {
            resize(newCapacity = q.size / 2)
        }

        return item
    }

    override fun isEmpty(): Boolean = head == tail

    fun values(): List<String> = q.mapNotNull { it }

    private fun resize(newCapacity: Int) {
        val copy = Array<String?>(newCapacity) { null }
        for (i in q.indices) {
            copy[i] = q[i]
        }
        q = copy
    }
}

fun main() {
    val queue: Queue = ArrayQueue()

    queue.enqueue("1")
    queue.enqueue("2")
    queue.enqueue("3")

    println(queue.dequeue())
    println(queue.dequeue())
    println(queue.dequeue())

    println(queue.isEmpty())
}
