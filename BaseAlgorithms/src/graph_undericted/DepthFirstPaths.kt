package graph_undericted

import stack.LinkedListStack

/**
 * The `DepthFirstPaths` class represents a data type for finding
 * paths from a source vertex *s* to every other vertex
 * in an undirected graph.
 *
 *
 * This implementation uses depth-first search.
 * The constructor takes (*V* + *E*) time in the
 * worst case, where *V* is the number of vertices and
 * *E* is the number of edges.
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
class DepthFirstPaths(G: Graph, private val s: Int) {
    // marked[v] = is there an s-v path?
    private val marked: BooleanArray = BooleanArray(G.V())

    /**
     * edgeTo [v] = last edge on s-v path
     */
    private val edgeTo = IntArray(G.V())

    /**
     * Computes a path between `s` and every other vertex in graph `G`.
     * @param G the graph
     * @param s the source vertex
     * @throws IllegalArgumentException unless `0 <= s < V`
     */
    init {
        dfs(G, s)
    }

    // depth first search from v
    private fun dfs(G: Graph, v: Int) {
        marked[v] = true
        for (w in G.adj(v)!!) {
            if (!marked[w]) {
                edgeTo[w] = v
                dfs(G, w)
            }
        }
    }

    /**
     * Returns a path between the source vertex `s` and vertex `v`, or
     * `null` if no such path.
     * @param  v the vertex
     * @return the sequence of vertices on a path between the source vertex
     * `s` and vertex `v`, as an Iterable
     * @throws IllegalArgumentException unless `0 <= v < V`
     */
    fun pathTo(v: Int): Iterable<Int>? {
        if (!hasPathTo(v)) return null
        val path = LinkedListStack<Int>()
        var x = v
        while (x != s) {
            path.push(x)
            x = edgeTo[x]
        }
        path.push(s)
        return path
    }

    /**
     * Is there a path between the source vertex `s` and vertex `v`?
     * @param v the vertex
     * @return `true` if there is a path, `false` otherwise
     * @throws IllegalArgumentException unless `0 <= v < V`
     */
    fun hasPathTo(v: Int): Boolean {
        return marked[v]
    }
}