package graph_undericted

import queue.LinkedQueue
import queue.Queue
import stack.LinkedListStack

/**
 * The `BreadthFirstPaths` class represents a data type for finding
 * shortest paths (number of edges) from a source vertex *s*
 * (or a set of source vertices)
 * to every other vertex in an undirected graph.
 *
 *
 * This implementation uses breadth-first search.
 * The constructor takes (*V* + *E*) time in the
 * worst case, where *V* is the number of vertices and *E*
 * is the number of edges.
 * Each instance method takes (1) time.
 * It uses (*V*) extra space (not including the graph).
 *
 *
 * For additional documentation,
 * see [Section 4.1](https://algs4.cs.princeton.edu/41graph)
 * of *Algorithms, 4th Edition* by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
class BreadthFirstPaths {
    // marked[v] = is there an s-v path
    private var marked: BooleanArray

    // edgeTo[v] = previous edge on shortest s-v path
    private var edgeTo: IntArray

    // distTo[v] = number of edges shortest s-v path
    private var distTo: IntArray

    /**
     * Computes the shortest path between the source vertex `s`
     * and every other vertex in the graph `G`.
     * @param G the graph
     * @param s the source vertex
     * @throws IllegalArgumentException unless `0 <= s < V`
     */
    constructor(G: Graph, s: Int) {
        marked = BooleanArray(G.V())
        distTo = IntArray(G.V())
        edgeTo = IntArray(G.V())
        bfs(G, s)
    }

    /**
     * Computes the shortest path between any one of the source vertices in `sources`
     * and every other vertex in graph `G`.
     * @param G the graph
     * @param sources the source vertices
     * @throws IllegalArgumentException if `sources` is `null`
     * @throws IllegalArgumentException unless `0 <= s < V` for each vertex
     * `s` in `sources`
     */
    constructor(G: Graph, sources: Iterable<Int>) {
        marked = BooleanArray(G.V())
        distTo = IntArray(G.V())
        edgeTo = IntArray(G.V())
        for (v in 0 until G.V()) distTo[v] = Int.MAX_VALUE
        bfs(G, sources)
    }

    // breadth-first search from a single source
    private fun bfs(G: Graph, s: Int) {
        val q = LinkedQueue<Int>()
        for (v in 0 until G.V()) distTo[v] = Int.MAX_VALUE
        distTo[s] = 0
        marked[s] = true
        q.enqueue(s)
        while (!q.isEmpty()) {
            val v: Int = q.dequeue() ?: return
            for (w in G.adj(v)!!) {
                if (!marked[w]) {
                    edgeTo[w] = v
                    distTo[w] = distTo[v] + 1
                    marked[w] = true
                    q.enqueue(w)
                }
            }
        }
    }

    // breadth-first search from multiple sources
    private fun bfs(G: Graph, sources: Iterable<Int>) {
        val q: Queue<Int> = LinkedQueue<Int>()
        for (s in sources) {
            marked[s] = true
            distTo[s] = 0
            q.enqueue(s)
        }
        while (!q.isEmpty()) {
            val v: Int = q.dequeue() ?: return
            for (w in G.adj(v)!!) {
                if (!marked[w]) {
                    edgeTo[w] = v
                    distTo[w] = distTo[v] + 1
                    marked[w] = true
                    q.enqueue(w)
                }
            }
        }
    }

    /**
     * Returns a shortest path between the source vertex `s` (or sources)
     * and `v`, or `null` if no such path.
     * @param  v the vertex
     * @return the sequence of vertices on a shortest path, as an Iterable
     * @throws IllegalArgumentException unless `0 <= v < V`
     */
    fun pathTo(v: Int): Iterable<Int>? {
        if (!hasPathTo(v)) return null
        val path = LinkedListStack<Int>()
        var x = v
        while (distTo[x] != 0) {
            path.push(x)
            x = edgeTo[x]
        }
        path.push(x)
        return path
    }

    /**
     * Is there a path between the source vertex `s` (or sources) and vertex `v`?
     * @param v the vertex
     * @return `true` if there is a path, and `false` otherwise
     * @throws IllegalArgumentException unless `0 <= v < V`
     */
    fun hasPathTo(v: Int): Boolean = marked[v]

    /**
     * Returns the number of edges in a shortest path between the source vertex `s`
     * (or sources) and vertex `v`?
     * @param v the vertex
     * @return the number of edges in a shortest path
     * @throws IllegalArgumentException unless `0 <= v < V`
     */
    fun distTo(v: Int): Int = distTo[v]
}
