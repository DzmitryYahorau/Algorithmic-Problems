package linkedlist

data class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        return " val= $`val`, next= ${next.toString()}"
    }

}