package array

class Solution88 {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        if (nums1.isEmpty() || nums2.isEmpty()) return

        val size = m + n
        val aux = IntArray(size = size)

        var i = 0
        var j = 0
        var k = 0

        while (k < size) {
            when {
                i >= m && j < n -> {
                    aux[k++] = nums2[j++]
                }
                j >= n && i < m -> {
                    aux[k++] = nums1[i++]
                }
                nums1[i] <= nums2[j] -> {
                    aux[k++] = nums1[i++]
                }
                nums1[i] > nums2[j] -> {
                    aux[k++] = nums2[j++]
                }
            }
        }

        for (index in aux.indices) {
            nums1[index] = aux[index]
        }
    }
}

fun main() {

    val nums1 = intArrayOf(2,0)
    val m = 1
    val nums2 = intArrayOf(1)
    val n = 1
    Solution88().merge(nums1, m, nums2, n)
    println(nums1.joinToString(","))
}
