package priority_queue

interface PriorityQueue {

    fun insert(key: Int)

    fun deleteMax(): Int

    fun isEmpty(): Boolean
}