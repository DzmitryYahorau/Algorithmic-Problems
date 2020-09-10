package _main_data_structure_impl.queue

interface Queue {

    fun enqueue(item: String)

    fun dequeue(): String?

    fun isEmpty(): Boolean
}