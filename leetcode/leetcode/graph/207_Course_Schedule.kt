package graph

class Solution207 {

    private var hasCycle: Boolean = false
    private var onStack: Array<Boolean> = emptyArray()
    private var marked: Array<Boolean> = emptyArray()

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        onStack = Array(numCourses) { false }
        marked = Array(numCourses) { false }

        val graph = createGraph(numCourses, prerequisites)

        for (v in 0 until numCourses) {
            dfs(v, graph)
        }
        return !hasCycle
    }

    private fun createGraph(numCourses: Int, prerequisites: Array<IntArray>): Array<IntArray> {
        val graph: Array<MutableList<Int>> = Array(numCourses) { mutableListOf<Int>() }

        for (edge in prerequisites) {
            val from = edge[0]
            val to = edge[1]
            graph[from].add(to) // add edge
        }
        return graph.map { it.toIntArray() }.toTypedArray()
    }

    private fun dfs(v: Int, graph: Array<IntArray>) {
        if (onStack[v]) {
            hasCycle = true
            return
        }
        marked[v] = true
        onStack[v] = true

        val adjacentNodes = graph[v]
        for (w in adjacentNodes) {
            when {
                hasCycle -> return
                onStack[w] -> {
                    hasCycle = true
                    return
                }
                else -> {
                    marked[w] = true
                    dfs(w, graph)
                }
            }
        }
        onStack[v] = false
    }
}

fun main() {
    val a = intArrayOf(1, 0)
    val a2 = intArrayOf(0, 1)
    val prerequisites = arrayOf(a, a2)

    println(Solution207().canFinish(2, prerequisites))


}