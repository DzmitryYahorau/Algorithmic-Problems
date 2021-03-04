package linkedlist

fun flatten(root: ChildNode?): ChildNode? {
    dfs(root)
    return root
}

private fun dfs(root: ChildNode?) {
    if (root == null) return

    if (root.child != null) {
        //find tail
        var tail = root.child
        while (tail?.next != null) {
            tail = tail.next
        }

        //connect nodes
        val oldNext = root.next
        tail?.next = oldNext
        oldNext?.prev = tail
        root.next = root.child
        root.child?.prev = root
        root.child = null

        dfs(root.next)
    } else {
        dfs(root.next)
    }
}

class ChildNode(var `val`: Int) {
    var prev: ChildNode? = null
    var next: ChildNode? = null
    var child: ChildNode? = null

    override fun toString(): String {
        return "${this.`val`} -> ${this.next?.toString()}"
    }
}

fun main() {
    val node1 = 1.cn()
    val node2 = 2.cn()
    val node3 = 3.cn()
    val node4 = 4.cn()
    val node5 = 5.cn()
    val node6 = 6.cn()
    val node7 = 7.cn()
    val node8 = 8.cn()
    val node9 = 9.cn()
    val node10 = 10.cn()
    val node11 = 11.cn()
    val node12 = 12.cn()

    node1.next = node2

    node2.prev = node1
    node2.next = node3

    node3.prev = node2
    node3.next = node4
    node3.child = node7

    node4.next = node5
    node4.prev = node3

    node5.apply {
        next = node6
        prev = node4
    }

    node7.prev = node3
    node7.next = node8

    node8.prev = node7
    node8.next = node9
    node8.child = node11

    node9.next = node10
    node9.prev = node8

    node10.prev = node9

    node11.prev = node8
    node11.next = node12

    node12.prev = node11

    flatten(node1)

    println("$node1")
}

fun Int.cn(): ChildNode = ChildNode(this)
