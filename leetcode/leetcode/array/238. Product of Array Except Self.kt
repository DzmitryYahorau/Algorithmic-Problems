package array

/*
Given numbers [2, 3, 4, 5], regarding the third number 4,
the product of array except 4 is 2*3*5 which consists of two parts: left 2*3 and right 5.
The product is left*right. We can get lefts and rights:

Numbers:     2    3    4     5
Lefts:            2  2*3 2*3*4
Rights:  3*4*5  4*5    5
Let’s fill the empty with 1:

Numbers:     2    3    4     5
Lefts:       1    2  2*3 2*3*4
Rights:  3*4*5  4*5    5     1
We can calculate lefts and rights in 2 loops. The time complexity is O(n).

We store lefts in result array. If we allocate a new array for rights.
The space complexity is O(n). To make it O(1),
we just need to store it in a variable which is right in @lycjava3’s code.
*/

fun productExceptSelf(nums: IntArray): IntArray {
    val output = IntArray(nums.size)

    var left = 1
    for (i in 0..nums.lastIndex) {
        if (i > 0) {
            left *= nums[i - 1]
        }
        output[i] = left
    }

    var right = 1
    for (i in nums.lastIndex downTo 0) {
        if (i < nums.lastIndex) {
            right *= nums[i + 1]
        }
        output[i] *= right
    }

    return output
}

fun main() {
    println(productExceptSelf(intArrayOf(1, 2, 3, 4)).joinToString())
}