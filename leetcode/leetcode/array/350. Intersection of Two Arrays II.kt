package array

//#not easy question, confusing conditions
fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val map = mutableMapOf<Int, Int>()
    val result = mutableListOf<Int>()

    for (num in nums1) {
        val current = map.getOrDefault(num, 0)
        map[num] = current + 1
    }

    for (num in nums2) {
        val value = map.getOrDefault(num, 0)
        if (value > 0) {
            result.add(num)
            map[num] = value - 1
        }
    }

    return result.toIntArray()
}

fun main() {
    println(intersect(nums1 = intArrayOf(1, 2, 2, 1), nums2 = intArrayOf(2, 2)).joinToString { it.toString() })
    println(intersect(nums1 = intArrayOf(4, 9, 5), nums2 = intArrayOf(9, 4, 9, 8, 4)).joinToString { it.toString() })
    println(intersect(nums1 = intArrayOf(1), nums2 = intArrayOf(1, 1)).joinToString { it.toString() })
    println(intersect(nums1 = intArrayOf(1), nums2 = intArrayOf(1, 2)).joinToString { it.toString() })
}
