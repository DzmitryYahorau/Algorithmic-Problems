package graph

import kotlin.test.assertEquals

fun topologicalSortKahn(numCourses: Int, prerequisites: Array<IntArray>): Boolean {

    val g = buildGraph(prerequisites, numCourses)

    val nodes = calculateInDegreeOfNodes(g).toMutableMap()
    val leaders = nodes.filter { it.value == 0 }.map { it.key }.toMutableList()

    var l = 0
    while (l < leaders.size) {
        val edges: List<Int> = g.adj[leaders[l]] ?: emptyList()
        for (neighbor in edges) {
            val count = nodes[neighbor]
            nodes[neighbor] = count?.minus(1) ?: 0
            if (count == 1) {             // this leader was the last predecessor
                leaders.add(neighbor)  // so neighbor is now a leader itself
            }
        }
        l += 1
    }

    // Was there a cycle in the graph?
    if (leaders.size != g.nodes.size) {
//        print("Error: graphs with cycles are not allowed")
        return false
    }

    return true
}

fun buildGraph(prerequisites: Array<IntArray>, numCourses: Int): Digraph {
    val graph = Digraph(numCourses)

    for (p in prerequisites) {
        val from = p.last()
        val to = p.first()
        graph.addEdge(from, to)
    }
    return graph
}

fun calculateInDegreeOfNodes(graph: Digraph): Map<Int, Int> =
        graph.nodes.map { node -> node to graph.indegree[node] }.toMap()

class Digraph(V: Int) {
    var adj : Array<MutableList<Int>?> = Array(V){ mutableListOf<Int>() }
     var indegree  : IntArray = IntArray(V)
     val nodes: MutableSet<Int> = mutableSetOf()

    fun addEdge(from: Int, to: Int) {
        adj[from]?.add(to)
        indegree[to]++
        nodes.add(from)
        nodes.add(to)
    }
}

fun main() {
    println(
            topologicalSortKahn(20,
                    arrayOf(
                            intArrayOf(0, 10),
                            intArrayOf(3, 18),
                            intArrayOf(5, 5),
                            intArrayOf(6, 11),
                            intArrayOf(11, 14),
                            intArrayOf(13, 1),
                            intArrayOf(15, 1),
                            intArrayOf(17, 4)
                    )
            )
    )

    assertEquals(
            actual = topologicalSortKahn(5,
                    arrayOf(
                            intArrayOf(1, 4),
                            intArrayOf(2, 4),
                            intArrayOf(3, 1),
                            intArrayOf(3, 2)
                    )
            ),
            expected = true
    )
}

