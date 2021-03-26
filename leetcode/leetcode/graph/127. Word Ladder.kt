package graph

import java.util.*

class Solution_127 {

    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val graph = Graph(
                if (wordList.contains(beginWord)) {
                    wordList
                } else {
                    wordList + listOf(beginWord)
                }
        )
        val root = graph.nodeList.first { it.value == beginWord }
        root.visited = true

        return ladderLength(root, endWord)
    }

    private fun ladderLength(root: Node, endWord: String): Int {
        val q: Queue<Node> = LinkedList()
        q.offer(root)

        while (q.isNotEmpty()) {
            val node = q.poll()

            node.neighbors.forEach { neighbor ->
                if (!neighbor.visited) {
                    neighbor.level = node.level + 1

                    if (neighbor.value == endWord) {
                        return neighbor.level
                    } else {
                        neighbor.visited = true
                        q.offer(neighbor)
                    }
                }
            }
        }

        return 0
    }

    class Graph(nodes: List<String>) {

        val nodeList: List<Node>

        init {
            val list = nodes.map { Node(it) }
            list.forEach { node -> node.neighbors = list.filter { hasDiffInOneChar(it.value, node.value) } }
            nodeList = list
        }

        private fun hasDiffInOneChar(s1: String, s2: String): Boolean {
            var count = 0

            for (i in 0 until minOf(s1.length, s2.length)) {
                if (s1[i] != s2[i]) {
                    count++
                    if (count >= 2) return false
                }
            }

            return count == 1
        }
    }

    class Node(val value: String) {
        var visited: Boolean = false
        var neighbors: List<Node> = emptyList()
        var level = 1
    }
}