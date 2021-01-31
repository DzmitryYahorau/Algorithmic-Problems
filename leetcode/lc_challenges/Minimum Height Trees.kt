import java.util.*

fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
    val edgesList = edges.map { Edge(it[0], it[1]) }

    val graphs = mutableListOf<Graph>()


    for (i in 0..n) {
        val graph = Graph(n)
        graph.root = i

        edgesList.forEach {
            graph.addEdge(it)
        }

        graphs.add(graph)
    }

    return emptyList()
}

class Graph(V: Int) {

    private var adj: Array<LinkedList<Int>?> = arrayOfNulls(V)

    init {
        for (v in 0 until V) {
            adj[v] = LinkedList()
        }
    }

    var root = 0

    fun addEdge(edge: Edge) {
        adj[edge.either]?.add(edge.other(edge.either))
        adj[edge.other(edge.either)]?.add(edge.either)
    }

    fun adj(v: Int): Iterable<Int>? {
        return adj[v]
    }

    fun height(): Int {
        TODO("")
    }
}

class Edge(
        val either: Int,
        private val other: Int
) {

    fun other(vertex: Int): Int = when (vertex) {
        either -> other
        other -> vertex
        else -> throw IllegalArgumentException("Illegal endpoint")
    }
}

fun main() {

    findMinHeightTrees(
            n = 4,
            edges = arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(1, 2),
                    intArrayOf(1, 3)
            )
    )
}