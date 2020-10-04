package graph_directed

import _main_data_structure_impl.graph_directed.Digraph
import java.util.*

/**
 * The `DirectedCycle` class represents a data type for
 * determining whether a digraph has a directed cycle.
 * The *hasCycle* operation determines whether the digraph has
 * a simple directed cycle and, if so, the *cycle* operation
 * returns one.
 *
 *
 * This implementation uses depth-first search.
 * The constructor takes (*V* + *E*) time in the worst
 * case, where *V* is the number of vertices and *E* is
 * the number of edges.
 * Each instance method takes (1) time.
 * It uses (*V*) extra space (not including the digraph).
 *
 *
 *
 *
 * For additional documentation,
 * see [Section 4.2](https://algs4.cs.princeton.edu/42digraph) of
 * *Algorithms, 4th Edition* by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
class DirectedCycle(G: Digraph) {

    // marked[v] = has vertex v been marked?
    private val marked: BooleanArray = BooleanArray(G.V())

    // edgeTo[v] = previous vertex on path to v
    private val edgeTo: IntArray = IntArray(G.V())

    // onStack[v] = is vertex on the stack?
    private val onStack: BooleanArray = BooleanArray(G.V())

    // directed cycle (or null if no such cycle)
    private var cycle: Stack<Int>? = null

    /**
     * Determines whether the digraph `G` has a directed cycle and, if so,
     * finds such a cycle.
     * @param G the digraph
     */
    init {
        for (v in 0 until G.V()) if (!marked[v] && cycle == null) dfs(G, v)
    }

    // check that algorithm computes either the topological order or finds a directed cycle
    private fun dfs(G: Digraph, v: Int) {
        onStack[v] = true
        marked[v] = true
        for (w in G.adj(v)!!) {

            // short circuit if directed cycle found
            when {
                cycle != null -> return
                !marked[w] -> {
                    edgeTo[w] = v
                    dfs(G, w)
                }
                onStack[w] -> {
                    cycle = Stack()
                    var x = v
                    while (x != w) {
                        cycle?.push(x)
                        x = edgeTo[x]
                    }
                    cycle?.push(w)
                    cycle?.push(v)
                }
            }
        }
        onStack[v] = false
    }

    /**
     * Does the digraph have a directed cycle?
     * @return `true` if the digraph has a directed cycle, `false` otherwise
     */
    fun hasCycle(): Boolean = cycle != null

    /**
     * Returns a directed cycle if the digraph has a directed cycle, and `null` otherwise.
     * @return a directed cycle (as an iterable) if the digraph has a directed cycle,
     * and `null` otherwise
     */
    fun cycle(): Iterable<Int>? = cycle
}