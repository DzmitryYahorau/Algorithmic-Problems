package backtracking

fun combine(n: Int, k: Int): List<List<Int>> {
    if (n == 0 || k == 0) return emptyList()

    var previous = mutableListOf<List<List<Int>>>()

    repeat(n) {
        previous.add(listOf(emptyList()))
    }

    for (i in 1..k) {
        previous = fill(i, previous, n)
    }

    return previous.last()
}

private fun fill(i: Int, previous: MutableList<List<List<Int>>>, n: Int): MutableList<List<List<Int>>> {
    val current = mutableListOf<List<List<Int>>>()
    current.add(listOf((1..i).toList()))
    // Combine(i, j).
    for (j in (i + 1..n)) {
        current.add(current.last() + previous[current.size].map { it + j } )
    }
    return current
}

fun main() {
    println(combine(4, 1).joinToString())
}