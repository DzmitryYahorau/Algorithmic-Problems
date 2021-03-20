package graph

class `Solution 210` {

    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        return topologicalSortKahn(numCourses, prerequisites)
    }

    private fun topologicalSortKahn(numCourses: Int, prerequisites: Array<IntArray>): IntArray {

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
        // print("Error: graphs with cycles are not allowed")
            return IntArray(0)
        }

        val withPrerequisites = leaders
        val allCourses = (0 until numCourses).toList()

        val withoutPrerequisites = allCourses.filter { !withPrerequisites.contains(it) }

        return (withoutPrerequisites + withPrerequisites).toIntArray()
    }

    private fun buildGraph(prerequisites: Array<IntArray>, numCourses: Int): Digraph {
        val graph = Digraph(numCourses)

        for (p in prerequisites) {
            val from = p.last()
            val to = p.first()
            graph.addEdge(from, to)
        }
        return graph
    }

    private fun calculateInDegreeOfNodes(graph: Digraph): Map<Int, Int> =
            graph.nodes.map { node -> node to graph.indegree[node] }.toMap()

    private class Digraph(V: Int) {
        var adj: Array<MutableList<Int>?> = Array(V) { mutableListOf<Int>() }
        var indegree: IntArray = IntArray(V)
        val nodes: MutableSet<Int> = mutableSetOf()

        fun addEdge(from: Int, to: Int) {
            adj[from]?.add(to)
            indegree[to]++
            nodes.add(from)
            nodes.add(to)
        }

        fun outdegree(v: Int): Int = adj[v]?.size ?: 0
    }
}


fun main() {
    println(`Solution 210`().findOrder(1, emptyArray()).joinToString())
}