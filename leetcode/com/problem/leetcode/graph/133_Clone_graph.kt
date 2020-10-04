package graph

import kotlin.collections.ArrayList

class Solution {

    fun cloneGraph(node: Node?): Node? {
        val map = hashMapOf<Int, Node>()
        return dfs(node, map)
    }

    fun dfs(node: Node?, map: HashMap<Int, Node>): Node? {
        if (node == null) return null
        map[node.`val`]?.let { return it }

        val copy = Node(`val` = node.`val`)
        map[node.`val`] = copy

        for (neighbor in node.neighbors) {
            dfs(neighbor, map)?.let {
                copy.neighbors.add(it)
            }
        }

        return map[node.`val`]
    }
}

class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
