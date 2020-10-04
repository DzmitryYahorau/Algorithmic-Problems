package _main_data_structure_impl.undericted_graph

import _main_data_structure_impl.bag.LinkedBag

/**
 * The `Graph` class represents an undirected graph of vertices
 * named 0 through *V* – 1.
 * It supports the following two primary operations: add an edge to the graph,
 * iterate over all of the vertices adjacent to a vertex. It also provides
 * methods for returning the degree of a vertex, the number of vertices
 * *V* in the graph, and the number of edges *E* in the graph.
 * Parallel edges and self-loops are permitted.
 * By convention, a self-loop *v*-*v* appears in the
 * adjacency list of *v* twice and contributes two to the degree
 * of *v*.
 *
 *
 * This implementation uses an *adjacency-lists representation*, which
 * is a vertex-indexed array of [Bag] objects.
 * It uses (*E* + *V*) space, where *E* is
 * the number of edges and *V* is the number of vertices.
 * All instance methods take (1) time. (Though, iterating over
 * the vertices returned by [.adj] takes time proportional
 * to the degree of the vertex.)
 * Constructing an empty graph with *V* vertices takes
 * (*V*) time; constructing a graph with *E* edges
 * and *V* vertices takes (*E* + *V*) time.
 *
 *
 * For additional documentation, see
 * [Section 4.1](https://algs4.cs.princeton.edu/41graph)
 * of *Algorithms, 4th Edition* by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
class Graph(
        /**
         * Initializes an empty graph with `V` vertices and 0 edges.
         * param V the number of vertices
         *
         * @param  V number of vertices
         */
        private val V: Int
) {
    private var E = 0
    private var adj: Array<LinkedBag<Int>?> = arrayOfNulls<LinkedBag<Int>>(V)

    init {
        for (v in 0 until V) {
            adj[v] = LinkedBag()
        }
    }

    /**
     * Returns the number of vertices in this graph.
     */
    fun V(): Int = V

    /**
     * Returns the number of edges in this graph.
     */
    fun E(): Int = E

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private fun validateVertex(v: Int) {
        require(!(v < 0 || v >= V)) { "vertex " + v + " is not between 0 and " + (V - 1) }
    }

    /**
     * Adds the undirected edge v-w to this graph.
     *
     * @param  v one vertex in the edge
     * @param  w the other vertex in the edge
     * @throws IllegalArgumentException unless both `0 <= v < V` and `0 <= w < V`
     */
    fun addEdge(v: Int, w: Int) {
        validateVertex(v)
        validateVertex(w)
        E++
        adj[v]?.add(w)
        adj[w]?.add(v)
    }

    /**
     * Returns the vertices adjacent to vertex `v`.
     *
     * @param  v the vertex
     * @return the vertices adjacent to vertex `v`, as an iterable
     * @throws IllegalArgumentException unless `0 <= v < V`
     */
    fun adj(v: Int): Iterable<Int>? {
        validateVertex(v)
        return adj[v]
    }

    /**
     * Returns the degree of vertex `v`.
     *
     * @param  v the vertex
     * @return the degree of vertex `v`
     * @throws IllegalArgumentException unless `0 <= v < V`
     */
    fun degree(v: Int): Int {
        validateVertex(v)
        return adj[v]?.size() ?: 0
    }
}
