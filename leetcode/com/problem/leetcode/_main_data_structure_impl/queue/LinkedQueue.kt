package _main_data_structure_impl.queue

class LinkedQueue : Queue {

    private var first: Node? = null
    private var last: Node? = null

    override fun enqueue(item: String) {
        val oldLast = last
        last = Node(item = item, next = null)

        if (isEmpty()) {
            first = last
        } else {
            oldLast?.next = last
        }
    }

    override fun dequeue(): String? {
        val item = first?.item
        first = first?.next
        if (isEmpty()) {
            last = null
        }
        return item
    }

    override fun isEmpty(): Boolean = first == null
}

fun main() {
    val queue: Queue = LinkedQueue()

    queue.enqueue("1")
    queue.enqueue("2")
    queue.enqueue("3")

    println(queue.dequeue())
    println(queue.dequeue())
    println(queue.dequeue())

    println(queue.isEmpty())
}

