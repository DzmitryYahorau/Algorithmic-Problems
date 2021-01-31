package graph_undericted

import bag.Bag
import bag.LinkedBag

/**
 * The `EdgeWeightedGraph` class represents an edge-weighted
 * graph of vertices named 0 through *V* – 1, where each
 * undirected edge is of type [Edge] and has a real-valued weight.
 * It supports the following two primary operations: add an edge to the graph,
 * iterate over all of the edges incident to a vertex. It also provides
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
 * the edges returned by [.adj] takes time proportional
 * to the degree of the vertex.)
 * Constructing an empty edge-weighted graph with *V* vertices takes
 * (*V*) time; constructing a edge-weighted graph with
 * *E* edges and *V* vertices takes
 * (*E* + *V*) time.
 *
 *
 * For additional documentation,
 * see [Section 4.3](https://algs4.cs.princeton.edu/43mst) of
 * *Algorithms, 4th Edition* by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
class EdgeWeightedGraph(private val V: Int) {

    private var E = 0
    private var adj: Array<Bag<Edge>?> = arrayOfNulls<Bag<Edge>?>(V)

    init {
        for (v in 0 until V) {
            adj[v] = LinkedBag()
        }
    }

    /**
     * Returns the number of vertices in this edge-weighted graph.
     */
    fun V(): Int = V

    /**
     * Returns the number of edges in this edge-weighted graph.
     */
    fun E(): Int = E

    /**
     * Adds the undirected edge `e` to this edge-weighted graph.
     *
     * @param  e the edge
     * @throws IllegalArgumentException unless both endpoints are between `0` and `V-1`
     */
    fun addEdge(e: Edge) {
        val v: Int = e.either()
        val w: Int = e.other(v)
        adj[v]?.add(e)
        adj[w]?.add(e)
        E++
    }

    /**
     * Returns the edges incident on vertex `v`.
     *
     * @param  v the vertex
     * @return the edges incident on vertex `v` as an Iterable
     * @throws IllegalArgumentException unless `0 <= v < V`
     */
    fun adj(v: Int): Iterable<Edge>? = adj[v]

    /**
     * Returns the degree of vertex `v`.
     * @param  v the vertex
     * @return the degree of vertex `v`
     */
    fun degree(v: Int): Int = adj[v]?.size() ?: 0

    /**
     * Returns all edges in this edge-weighted graph.
     * To iterate over the edges in this edge-weighted graph, use foreach notation:
     * `for (Edge e : G.edges())`.
     *
     * @return all edges in this edge-weighted graph, as an iterable
     */
    fun edges(): Iterable<Edge> {
        val list: Bag<Edge> = LinkedBag()
        for (v in 0 until V) {
            var selfLoops = 0
            for (e in adj(v)!!) {
                when {
                    (e.other(v) > v) -> list.add(e)
                    (e.other(v) == v) -> {
                        if (selfLoops % 2 == 0) list.add(e)
                        selfLoops++
                    }
                }
            }
        }
        return list
    }
}