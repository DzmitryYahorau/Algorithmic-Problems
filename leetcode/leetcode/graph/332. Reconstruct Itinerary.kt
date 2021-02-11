package graph

import java.util.*
import kotlin.test.assertEquals
import java.util.LinkedList

import java.util.HashMap

//https://leetcode.com/problems/reconstruct-itinerary/discuss/78766/Share-my-solution
fun findItinerary(tickets: List<List<String>>): List<String> {

    val flights = HashMap<String, PriorityQueue<String>>()
    val path = LinkedList<String>()

    for (ticket in tickets) {
        flights.putIfAbsent(ticket[0], PriorityQueue())
        flights[ticket[0]]?.add(ticket[1])
    }
    dfs("JFK", flights, path)
    return path
}

private fun dfs(departure: String?, flights: Map<String, PriorityQueue<String>>, path: LinkedList<String>) {
    val arrivals: PriorityQueue<String>? = flights[departure]

    while (arrivals != null && !arrivals.isEmpty()) {
        dfs(arrivals.poll(), flights, path)
    }
    path.addFirst(departure)
}

fun main() {

//    Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//    Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]

    println(
            findItinerary(listOf(
                    listOf("MUC", "LHR"),
                    listOf("JFK", "MUC"),
                    listOf("SFO", "SJC"),
                    listOf("LHR", "SFO"))
            ).joinToString()
    )


//    [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
    println(
            findItinerary(listOf(
                    listOf("JFK", "SFO"),
                    listOf("JFK", "ATL"),
                    listOf("SFO", "ATL"),
                    listOf("ATL", "JFK"),
                    listOf("ATL", "SFO"))
            ).joinToString()
    )

//    [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
    assertEquals(
            actual = findItinerary(listOf(
                    listOf("JFK", "SFO"),
                    listOf("JFK", "ATL"),
                    listOf("SFO", "ATL"),
                    listOf("ATL", "JFK"),
                    listOf("ATL", "SFO"))
            ),
            expected = listOf("JFK", "ATL", "JFK", "SFO", "ATL", "SFO")
    )

}