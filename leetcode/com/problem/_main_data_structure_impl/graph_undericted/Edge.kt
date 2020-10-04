package _main_data_structure_impl.graph_undericted

/**
 * The `Edge` class represents a weighted edge in an
 * [EdgeWeightedGraph]. Each edge consists of two integers
 * (naming the two vertices) and a real-value weight. The data type
 * provides methods for accessing the two endpoints of the edge and
 * the weight. The natural order for this data type is by
 * ascending order of weight.
 *
 * For additional documentation, see [Section 4.3](https://algs4.cs.princeton.edu/43mst) of
 * *Algorithms, 4th Edition* by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
data class Edge(
        /**
         * Initializes an edge between vertices `v` and `w` of
         * the given `weight`.
         *
         * @param  v one vertex
         * @param  w the other vertex
         * @param  weight the weight of this edge
         * @throws IllegalArgumentException if either `v` or `w`
         * is a negative integer
         * @throws IllegalArgumentException if `weight` is `NaN`
         */
        val v: Int,
        val w: Int,
        val weight: Double
) {
    /**
     * Returns either endpoint of this edge.
     */
    fun either(): Int = v

    /**
     * Returns the endpoint of this edge that is different from the given vertex.
     *
     * @param  vertex one endpoint of this edge
     * @return the other endpoint of this edge
     * @throws IllegalArgumentException if the vertex is not one of the
     * endpoints of this edge
     */
    fun other(vertex: Int): Int = when (vertex) {
        v -> w
        w -> v
        else -> throw IllegalArgumentException("Illegal endpoint")
    }
}