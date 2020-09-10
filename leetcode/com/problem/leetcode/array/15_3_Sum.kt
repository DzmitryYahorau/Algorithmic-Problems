package array

import java.util.*

class Solution15 {

    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val arr = nums.sorted()

        for (i in arr.indices) {
            for (j in i + 1 until arr.size) {
                val first = arr[i]
                val second = arr[j]
                val third = -(first + second)

                val without = arr.toMutableList()
                without.remove(first)
                without.remove(second)

//                if (i > 2 && without) {
//                    val isThirdExist = binarySearch(
//                            array = without,
//                            lo = i,
//                            hi = without.lastIndex,
//                            target = third
//                    )
//
//                    if (isThirdExist) {
//                        result.add(listOf(first, second, third))
//                    }
//                }
            }
        }

        return result
    }

    private fun binarySearch(array: List<Int>, lo: Int, hi: Int, target: Int): Boolean {
        if (lo == hi) return target == array[lo]

        val mid = lo + (hi - lo) / 2

        return when {
            target > array[mid] -> binarySearch(array, mid + 1, hi, target)
            target < array[mid] -> binarySearch(array, lo, mid, target)
            else -> true
        }
    }
}

fun main() {
    val input = intArrayOf(-1, 0, 1, 2, -1, -4)
    println(Solution15().threeSum(input))
}

fun threeSum(num: IntArray): List<List<Int>>? {
    Arrays.sort(num)
    val res: MutableList<List<Int>> = LinkedList()
    for (i in 0 until num.size - 2) {
        if (i == 0 || i > 0 && num[i] != num[i - 1]) {
            var lo = i + 1
            var hi = num.size - 1
            val sum = 0 - num[i]
            while (lo < hi) {
                when {
                    num[lo] + num[hi] == sum -> {
                        res.add(listOf(num[i], num[lo], num[hi]))
                        while (lo < hi && num[lo] == num[lo + 1]) lo++
                        while (lo < hi && num[hi] == num[hi - 1]) hi--
                        lo++
                        hi--
                    }
                    num[lo] + num[hi] < sum -> lo++
                    else -> hi--
                }
            }
        }
    }
    return res
}