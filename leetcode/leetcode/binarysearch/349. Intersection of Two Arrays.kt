package binarysearch

/**
 * Binary Search approach
 */
fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    if (nums1.isEmpty() || nums2.isEmpty()) {
        return IntArray(0)
    }

    val sorted2 = nums2.sorted()
    val result = mutableSetOf<Int>()

    nums1.forEach {
        if (it !in result && binSearch(values = sorted2, value = it)) {
            result.add(it)
        }
    }

    return result.toTypedArray().toIntArray()
}

fun binSearch(values: List<Int>, value: Int, lo: Int = 0, hi: Int = values.lastIndex): Boolean {
    if (lo > hi) return false
    val mid = lo + (hi - lo) / 2

    val midValue = values[mid]
    return when {
        (midValue > value) -> binSearch(values, value, lo, mid - 1)
        (midValue < value) -> binSearch(values, value, mid + 1, hi)
        else -> true
    }
}

/**
 * This is a Facebook interview question.
 * They ask for the intersection, which has a trivial solution using a hash or a set.
 * Then they ask you to solve it under these constraints:
 * - O(n) time and O(1) space (the resulting array of intersections is not taken into consideration).
 * - You are told the lists are sorted.
 * Cases to take into consideration include:
 * duplicates, negative values, single value lists, 0's, and empty list arguments.
 * Other considerations might include
 * sparse arrays.
 */

//TODO: Add array constraints, otherwise ArrayOutOfBoundsException
fun intersectionsO1(nums1: IntArray, nums2: IntArray): IntArray {
    val sorted1 = nums1.sorted() // assume sorted
    val sorted2 = nums2.sorted() // assume sorted
    val intersections = mutableSetOf<Int>()
    var l = 0
    var r = 0
    while (sorted2.getOrNull(l) != null && sorted1.getOrNull(r) != null) {
        val left = sorted1[r]
        val right = sorted2[l]
        if (right == left) {
            intersections.add(right)
            while (left == sorted1[r]) r++
            while (right == sorted2[l]) l++
            continue
        }
        if (right > left) while (left == sorted1[r]) r++
        else while (right == sorted2[l]) l++
    }
    return intersections.toTypedArray().toIntArray()
}

fun intersectionSimpleSolution(nums1: IntArray, nums2: IntArray): IntArray {
    if (nums1.size > nums2.size){
        return intersection(nums2, nums1)
    }

    val set = mutableSetOf<Int>()
    set.addAll(nums1.toList())

    val result = mutableListOf<Int>()
    var i = 0
    var sorted = nums2.sorted()
    var dup = -1

    while (i < sorted.size){
        while(i in sorted.indices && sorted[i] == dup){
            i++
        }

        if (i in sorted.indices){
            dup = sorted[i]

            if (dup in set){
                result.add(dup)
            }
        }
    }

    return result.toTypedArray().toIntArray()
}
