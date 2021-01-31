package tree

import java.util.*

fun getImportance(employees: List<Employee?>, id: Int): Int {
    val employee = employees.first { it?.id == id } ?: return 0

    var result = 0
    val queue = LinkedList<Employee>()
    queue.add(employee)

    while (queue.isNotEmpty()) {
        val worker = queue.poll()
        result += worker.importance

        val subordinates = worker.subordinates.mapNotNull { subordinateId ->
            employees.firstOrNull { it?.id == subordinateId }
        }
        queue.addAll(subordinates)
    }
    return result
}

class Employee {
    var id: Int = 0
    var importance: Int = 0
    var subordinates: List<Int> = listOf()
}