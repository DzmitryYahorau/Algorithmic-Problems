package array

fun largeGroupPositions(s: String): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    if (s.length < 3) return result

    val current = mutableListOf<Int>()

    for (i in 1..s.lastIndex) {
        if (s[i] == s[i - 1]) {
            current.add(i - 1)
            current.add(i)
        } else {
            if (current.size >= 3) {
                result.add(listOf(current.first(), current.last()))
            }
            current.clear()
        }
    }

    if (current.size >= 3) {
        result.add(listOf(current.first(), current.last()))
    }

    return result
}

