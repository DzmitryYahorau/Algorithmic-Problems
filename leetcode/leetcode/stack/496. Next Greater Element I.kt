package stack

import java.util.*

fun nextGreaterElement(findNums: IntArray, nums: IntArray): IntArray {
    // map from x to next greater element of x
    val map: MutableMap<Int, Int> = HashMap()
    val stack = Stack<Int>()

    for (num in nums) {
        while (stack.isNotEmpty() && stack.peek() < num) {
            val smallerNum = stack.pop()
            map.put(num, smallerNum)
        }
        stack.push(num)
    }

    for (i in findNums.indices) {
        //
        val num = findNums[i]
        findNums[i] = map.getOrDefault(num, -1)
    }

    return findNums
}

fun main() {
    val nums1 = intArrayOf(4,1,2)
    val nums2 = intArrayOf(1,3,4,2)

    println(nextGreaterElement(nums1, nums2).joinToString())
}