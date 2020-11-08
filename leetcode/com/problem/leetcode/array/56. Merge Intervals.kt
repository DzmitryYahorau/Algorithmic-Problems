package array

fun merge(intervals: Array<IntArray>): Array<IntArray> =
        intervals
                .map { arr -> (arr[0]..arr[1]) }
                .sortedBy { it.first }
                .mergeIntervals()
                .map { interval -> intArrayOf(interval.first, interval.last) }
                .toTypedArray()

fun List<IntRange>.mergeIntervals(): List<IntRange> {
    val result = mutableListOf<IntRange>()
    var i = 0

    while (i < this.size) {
        var j = this[i]
        while (i in this.indices && (i + 1 in this.indices) && j.last >= this[i + 1].first) {
            ++i
            val next = this[i]
            j = (minOf(next.first, j.first)..(maxOf(next.last, j.last)))
        }

        result.add(j)
        i++
    }

    return result
}

fun main() {
//    [[1,4],[4,5]]
//    [[2,3],[4,5],[6,7],[8,9],[1,10]]
    println(merge(intervals = arrayOf(
            intArrayOf(2, 3),
            intArrayOf(4, 5),
            intArrayOf(6, 7),
            intArrayOf(8, 9),
            intArrayOf(1, 10)
    )
    ).joinToString(","))

}