package linkedlist

data class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        return "$`val`->${next?.toValueString()}"
    }

    fun toValueString(): String {
        return "$`val`->${next?.toValueString()}"
    }

}

fun Iterable<Int>.toLinkedList(): ListNode? {
    val root = ListNode(0)
    var tail = root
    this.forEach {
        val node = ListNode(it)
        tail.next = node
        tail = node
    }

    return root.next
}