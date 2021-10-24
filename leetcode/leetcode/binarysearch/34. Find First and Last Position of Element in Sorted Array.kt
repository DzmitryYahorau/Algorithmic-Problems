package binarysearch

fun searchRange(nums: IntArray, target: Int): IntArray {
    val centerIndex = nums.binSearch(target)

    val leftIndex = nums.leftIndex(target = target, right = centerIndex)
    val rightIndex = nums.rightIndex(target = target, left = leftIndex)

    return intArrayOf(leftIndex, rightIndex)
}

fun IntArray.leftIndex(target: Int, right: Int): Int {
    var hi = right
    while (hi in indices) {
        val next = binSearch(target, 0, hi - 1)
        if (next !in indices) {
            return hi
        } else {
            hi = next
        }
    }

    return hi
}

fun IntArray.rightIndex(target: Int, left: Int): Int {
    var lo = left
    while (lo in indices) {
        val next = binSearch(target, lo + 1, lastIndex)
        if (next !in indices) {
            return lo
        } else {
            lo = next
        }
    }

    return lo
}

fun IntArray.binSearch(target: Int, lo: Int = 0, hi: Int = this.lastIndex): Int {
    if (lo > hi) return -1
    val mid = lo + (hi - lo) / 2

    return when {
        this[mid] < target -> binSearch(target, mid + 1, hi)
        this[mid] > target -> binSearch(target, lo, mid - 1)
        else -> mid
    }
}

fun main() {
    println(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), target = 8).joinToString())
    println(searchRange(intArrayOf(2, 2), target = 2).joinToString())
    println(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), target = 6).joinToString())
    println(searchRange(intArrayOf(), target = 6).joinToString())
}