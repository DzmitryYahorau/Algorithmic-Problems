package queue

interface Queue<Item> {

    fun enqueue(item: Item)

    fun dequeue(): Item?

    fun isEmpty(): Boolean
}