package _main_data_structure_impl.graph_directed

import _main_data_structure_impl.bag.LinkedBag
import bag.Bag
import java.util.*

/**
 * The `Digraph` class represents a directed graph of vertices
 * named 0 through *V* - 1.
 * It supports the following two primary operations: add an edge to the digraph,
 * iterate over all of the vertices adjacent from a given vertex.
 * It also provides
 * methods for returning the indegree or outdegree of a vertex,
 * the number of vertices *V* in the digraph,
 * the number of edges *E* in the digraph, and the reverse digraph.
 * Parallel edges and self-loops are permitted.
 *
 *
 * This implementation uses an *adjacency-lists representation*, which
 * is a vertex-indexed array of [Bag] objects.
 * It uses (*E* + *V*) space, where *E* is
 * the number of edges and *V* is the number of vertices.
 * All instance methods take (1) time. (Though, iterating over
 * the vertices returned by [.adj] takes time proportional
 * to the outdegree of the vertex.)
 * Constructing an empty digraph with *V* vertices takes
 * (*V*) time; constructing a digraph with *E* edges
 * and *V* vertices takes (*E* + *V*) time.
 *
 *
 * For additional documentation,
 * see [Section 4.2](https://algs4.cs.princeton.edu/42digraph) of
 * *Algorithms, 4th Edition* by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
class Digraph {
    private val V // number of vertices in this digraph
            : Int
    private var E // number of edges in this digraph
            = 0
    private var adj // adj[v] = adjacency list for vertex v
            : Array<Bag<Int>?>
    private var indegree // indegree[v] = indegree of vertex v
            : IntArray

    /**
     * Initializes an empty digraph with *V* vertices.
     *
     * @param  V the number of vertices
     * @throws IllegalArgumentException if `V < 0`
     */
    constructor(V: Int) {
        this.V = V
        E = 0
        indegree = IntArray(V)
        adj = arrayOfNulls<LinkedBag<Int>>(V) as Array<Bag<Int>?>
        for (v in 0 until V) {
            adj[v] = LinkedBag<Int>()
        }
    }

    /**
     * Initializes a new digraph that is a deep copy of the specified digraph.
     *
     * @param  G the digraph to copy
     * @throws IllegalArgumentException if `G` is `null`
     */
    constructor(G: Digraph) {
        V = G.V()
        E = G.E()

        // update indegrees
        indegree = IntArray(V)
        for (v in 0 until V) indegree[v] = G.indegree(v)

        // update adjacency lists
        adj = arrayOfNulls<LinkedBag<Int>>(V) as Array<Bag<Int>?>
        for (v in 0 until V) {
            adj[v] = LinkedBag<Int>()
        }
        for (v in 0 until G.V()) {
            // reverse so that adjacency list is in same order as original
            val reverse: Stack<Int> = Stack<Int>()
            for (w in G.adj[v]!!) {
                reverse.push(w)
            }
            for (w in reverse) {
                adj[v]?.add(w)
            }
        }
    }

    /**
     * Returns the number of vertices in this digraph.
     */
    fun V(): Int = V

    /**
     * Returns the number of edges in this digraph.
     */
    fun E(): Int = E

    /**
     * Adds the directed edge v→w to this digraph.
     *
     * @param  v the tail vertex
     * @param  w the head vertex
     * @throws IllegalArgumentException unless both `0 <= v < V` and `0 <= w < V`
     */
    fun addEdge(v: Int, w: Int) {
        adj[v]?.add(w)
        indegree[w]++
        E++
    }

    /**
     * Returns the vertices adjacent from vertex `v` in this digraph.
     *
     * @param  v the vertex
     * @return the vertices adjacent from vertex `v` in this digraph, as an iterable
     * @throws IllegalArgumentException unless `0 <= v < V`
     */
    fun adj(v: Int): Iterable<Int>? = adj[v]

    /**
     * Returns the number of directed edges incident from vertex `v`.
     * This is known as the *outdegree* of vertex `v`.
     *
     * @param  v the vertex
     * @return the outdegree of vertex `v`
     * @throws IllegalArgumentException unless `0 <= v < V`
     */
    fun outdegree(v: Int): Int = adj[v]?.size() ?: 0

    /**
     * Returns the number of directed edges incident to vertex `v`.
     * This is known as the *indegree* of vertex `v`.
     *
     * @param  v the vertex
     * @return the indegree of vertex `v`
     * @throws IllegalArgumentException unless `0 <= v < V`
     */
    fun indegree(v: Int): Int = indegree[v]

    /**
     * Returns the reverse of the digraph.
     */
    fun reverse(): Digraph {
        val reverse = Digraph(V)
        for (v in 0 until V) {
            for (w in adj(v)!!) {
                reverse.addEdge(w, v)
            }
        }
        return reverse
    }
}