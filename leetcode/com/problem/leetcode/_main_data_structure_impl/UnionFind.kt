package _main_data_structure_impl

class QuickUnionFind(
        N: Int
) {
    private val ids: IntArray = IntArray(size = N)

    init {
        (0..N).forEach { i -> ids[i] = i }
    }

    fun connected(first: Int, second: Int): Boolean =
            root(first) == root(second)

    fun union(first: Int, second: Int) {
        ids[root(first)] = root(second)
    }

    private fun root(i: Int): Int {
        var j = i
        while (j != ids[j]) {
            j = ids[j]
        }
        return j
    }
}