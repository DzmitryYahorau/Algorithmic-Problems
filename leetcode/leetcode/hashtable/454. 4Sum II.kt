package hashtable

fun fourSumCount(nums1: IntArray, nums2: IntArray, nums3: IntArray, nums4: IntArray): Int {
    // count num frequencies
    val first = nums1.toList().groupingBy { it }.eachCount()
    val second = nums2.toList().groupingBy { it }.eachCount()
    val third = nums3.toList().groupingBy { it }.eachCount()
    val forth = nums4.toList().groupingBy { it }.eachCount()

    /**
     * map of sum (first + second) : total frequency for both or how many
     * combinations we can make with this nums
     */
    val mapAB = mutableMapOf<Int, Int>()

    first.forEach { (key1, value1) ->
        second.forEach { (key2, value2) ->
            val sum = key1 + key2
            val howManyCombinations = value1 * value2
            mapAB[sum] = (mapAB[sum] ?: 0) + howManyCombinations
        }
    }

    var count = 0
    third.forEach { (key1, value1) ->
        forth.forEach { (key2, value2) ->
            val sum = key1 + key2
            val howManyCombinations = value1 * value2
            count += (mapAB[-sum] ?: 0) * howManyCombinations
        }
    }

    return count
}

fun main() {
    println(
            fourSumCount(
                    nums1 = intArrayOf(1, 2),
                    nums2 = intArrayOf(-2, -1),
                    nums3 = intArrayOf(-1, 2),
                    nums4 = intArrayOf(0, 2)
            )
    )
}