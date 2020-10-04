package _main_data_structure_impl.undericted_graph

import _main_data_structure_impl.graph_undericted.EdgeWeightedGraph

/**
 * The `CC` class represents a data type for
 * determining the connected components in an undirected graph.
 * The *id* operation determines in which connected component
 * a given vertex lies; the *connected* operation
 * determines whether two vertices are in the same connected component;
 * the *count* operation determines the number of connected
 * components; and the *size* operation determines the number
 * of vertices in the connect component containing a given vertex.
 *
 * The *component identifier* of a connected component is one of the
 * vertices in the connected component: two vertices have the same component
 * identifier if and only if they are in the same connected component.
 *
 *
 *
 * This implementation uses depth-first search.
 * The constructor takes (*V* + *E*) time,
 * where *V* is the number of vertices and *E* is the
 * number of edges.
 * Each instance method takes (1) time.
 * It uses (*V*) extra space (not including the graph).
 *
 *
 * For additional documentation, see
 * [Section 4.1](https://algs4.cs.princeton.edu/41graph)
 * of *Algorithms, 4th Edition* by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
class CC {
    // marked[v] = has vertex v been marked?v
    private var marked: BooleanArray

    // id[v] = id of connected component containing v
    private var id: IntArray

    // size[id] = number of vertices in given component
    private var size: IntArray

    // number of connected components
    private var count = 0

    /**
     * Computes the connected components of the undirected graph `G`.
     * @param G the undirected graph
     */
    constructor(G: Graph) {
        marked = BooleanArray(G.V())
        id = IntArray(G.V())
        size = IntArray(G.V())
        for (v in 0 until G.V()) {
            if (!marked[v]) {
                dfs(G, v)
                count++
            }
        }
    }

    /**
     * Computes the connected components of the edge-weighted graph `G`.
     * @param G the edge-weighted graph
     */
    constructor(G: EdgeWeightedGraph) {
        marked = BooleanArray(G.V())
        id = IntArray(G.V())
        size = IntArray(G.V())
        for (v in 0 until G.V()) {
            if (!marked[v]) {
                dfs(G, v)
                count++
            }
        }
    }

    // depth-first search for a Graph
    private fun dfs(G: Graph, v: Int) {
        marked[v] = true
        id[v] = count
        size[count]++
        for (w in G.adj(v)!!) {
            if (!marked[w]) {
                dfs(G, w)
            }
        }
    }

    // depth-first search for an EdgeWeightedGraph
    private fun dfs(G: EdgeWeightedGraph, v: Int) {
        marked[v] = true
        id[v] = count
        size[count]++
        for (e in G.adj(v)!!) {
            val w: Int = e.other(v)
            if (!marked[w]) {
                dfs(G, w)
            }
        }
    }

    /**
     * Returns the component id of the connected component containing vertex `v`.
     *
     * @param  v the vertex
     * @return the component id of the connected component containing vertex `v`
     * @throws IllegalArgumentException unless `0 <= v < V`
     */
    fun id(v: Int): Int = id[v]

    /**
     * Returns the number of vertices in the connected component containing vertex `v`.
     *
     * @param  v the vertex
     * @return the number of vertices in the connected component containing vertex `v`
     * @throws IllegalArgumentException unless `0 <= v < V`
     */
    fun size(v: Int): Int = size[id[v]]

    /**
     * Returns the number of connected components in the graph `G`.
     */
    fun count(): Int = count

    /**
     * Returns true if vertices `v` and `w` are in the same
     * connected component.
     *
     * @param  v one vertex
     * @param  w the other vertex
     * @return `true` if vertices `v` and `w` are in the same
     * connected component; `false` otherwise
     * @throws IllegalArgumentException unless `0 <= v < V`
     * @throws IllegalArgumentException unless `0 <= w < V`
     */
    fun connected(v: Int, w: Int): Boolean = (id(v) == id(w))
}