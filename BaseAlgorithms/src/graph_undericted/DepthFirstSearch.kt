package graph_undericted

/**
 * The `DepthFirstSearch` class represents a data type for
 * determining the vertices connected to a given source vertex *s*
 * in an undirected graph. For versions that find the paths, see
 * [DepthFirstPaths] and [BreadthFirstPaths].
 *
 *
 * This implementation uses depth-first search.
 * See [NonrecursiveDFS] for a non-recursive version.
 * The constructor takes (*V* + *E*) time in the worst
 * case, where *V* is the number of vertices and *E*
 * is the number of edges.
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
class DepthFirstSearch(G: Graph, s: Int) {

    // marked[v] = is there an s-v path?
    private val marked = BooleanArray(G.V())

    // number of vertices connected to s
    private var count = 0

    /**
     * Computes the vertices in graph `G` that are
     * connected to the source vertex `s`.
     * @param G the graph
     * @param s the source vertex
     * @throws IllegalArgumentException unless `0 <= s < V`
     */
    init {
        dfs(G, s)
    }

    // depth first search from v
    private fun dfs(G: Graph, v: Int) {
        count++
        marked[v] = true
        for (w in G.adj(v)!!) {
            if (!marked[w]) {
                dfs(G, w)
            }
        }
    }

    /**
     * Is there a path between the source vertex `s` and vertex `v`?
     * @param v the vertex
     * @return `true` if there is a path, `false` otherwise
     * @throws IllegalArgumentException unless `0 <= v < V`
     */
    fun marked(v: Int): Boolean = marked[v]

    /**
     * Returns the number of vertices connected to the source vertex `s`.
     */
    fun count(): Int = count
}