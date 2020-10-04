package _main_data_structure_impl.queue

interface Queue<Item> {

    fun enqueue(item: Item)

    fun dequeue(): Item?

    fun isEmpty(): Boolean
}