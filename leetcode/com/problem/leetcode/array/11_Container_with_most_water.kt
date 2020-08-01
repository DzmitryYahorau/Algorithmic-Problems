package array

import java.lang.Integer.min

class Solution11 {

    fun maxArea(height: IntArray): Int {
        if (height.size < 2) return 0

        var left = 0
        var right = height.lastIndex
        var max = 0

        while (left < right) {
            val area = (right - left) * (min(height[left], height[right]))
            if (area > max) {
                max = area
            }

            if (height[left] <= height[right]) {
                left++
            } else {
                right--
            }
        }

        return max
    }
}

fun main() {
    val input = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    println(Solution11().maxArea(input))
}