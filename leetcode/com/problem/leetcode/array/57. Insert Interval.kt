package array

fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    val _intervals = intervals.map { arr -> IntRange(start = arr[0], endInclusive = arr[1]) }
    val _newInterval = IntRange(start = newInterval[0], endInclusive = newInterval[1])

    val ofStart = _intervals.firstOrNull { _newInterval.first in it }?.first ?: _newInterval.first
    val ofEnd = _intervals.firstOrNull { _newInterval.last in it }?.last ?: _newInterval.last

    val mergedInterval = ofStart..ofEnd

    val filtered = _intervals
            .filterNot { mergedInterval isOverlappingBy it }
            .toMutableList()

    val indexToInsertOrNull = filtered.indexOfFirst { it.first > mergedInterval.last }.takeIf { it >= 0 }

    if (indexToInsertOrNull == null) {

        val start = filtered.firstOrNull()?.first
        val end = filtered.lastOrNull()?.last

        val index = when {
            (start == null) || (end == null) -> 0
            (mergedInterval.last < start) -> 0
            (mergedInterval.first > end) -> filtered.lastIndex + 1
            else -> 0
        }

        filtered.add(index, mergedInterval)
    } else {
        filtered.add(indexToInsertOrNull, mergedInterval)
    }

    return filtered
            .map { interval -> intArrayOf(interval.first, interval.last) }
            .toTypedArray()
}

infix fun IntRange.isOverlappingBy(intRange: IntRange): Boolean =
        this.first in intRange || this.last in intRange

fun main() {

    insert(arrayOf(intArrayOf(1, 5)), intArrayOf(6, 8))
}