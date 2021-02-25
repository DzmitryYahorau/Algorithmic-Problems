package linkedlist

typealias Node = CloneNode

val node_cache = mutableMapOf<Node, Node>()

fun copyRandomList(node: Node?): Node? {
    node ?: return null

    var head = node
    var clone_node: Node = Node(0)
    val clone: Node = clone_node

    //iterate through all nodes
    while (head != null) {

        //is in not in cache?
        if (node_cache[head] == null) {

            //create new node and put in cache
            val node_to_clone = Node(head.`val`)
            node_cache[head] = node_to_clone
            clone_node.next = node_to_clone
            clone_node = node_to_clone

            //check if there node has random node
            head.random?.let {
                //if he has, take node from cache or create new
                clone_node.random = if (node_cache[it] != null) {
                    node_cache[it]
                } else {
                    copyRandomList(it)
                }
            }
        } else {
            //get node from cache
            val node_from_cache = node_cache[head]!!
            clone_node.next = node_from_cache
            clone_node = node_from_cache
        }

        head = head.next
    }
    return clone.next
}

fun main() {
//    [[7,null] -> [13, 7] -> [11, 1] -> [10,2],[1,0]]
    val node1 = Node(7)
    val node2 = Node(13)
    val node3 = Node(11)
    val node4 = Node(10)
    val node5 = Node(1)

    node1.next = node2

    node2.next = node3
    node2.random = node1

    node3.next = node4
    node3.random = node5

    node4.next = node5
    node4.random = node3

    node5.random = node1

    val result = copyRandomList(node1)
    println(result.toString())
}

class CloneNode(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null

    override fun toString(): String {
        return "${this.`val`} ${next?.toString()}"
    }
}