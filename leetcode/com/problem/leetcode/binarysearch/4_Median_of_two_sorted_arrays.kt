package binarysearch

class MedianOf2Arrays {

    companion object {

        fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
            val sorted = when {
                nums1.isEmpty() && nums2.isNotEmpty() -> nums2
                nums1.isNotEmpty() && nums2.isEmpty() -> nums1
                else -> merge(a = nums1, b = nums2)
            }

            val sortedSize = (sorted.size)

            return when {
                (sortedSize % 2 == 0) -> {
                    val mid1 = ((sortedSize - 1) / 2)
                    val mid2 = mid1 + 1
                    (sorted[mid1] + sorted[mid2]) / 2.0
                }
                else -> {
                    val mid1 = (sortedSize / 2)
                    sorted[mid1].toDouble()
                }
            }
        }

        private fun merge(a: IntArray, b: IntArray): IntArray {
            val aux = IntArray(a.size + b.size)
            val res = IntArray(a.size + b.size)

            for (i in a.indices) {
                aux[i] = a[i]
            }

            for (i in b.indices) {
                aux[i + a.size] = b[i]
            }

            val lo = 0
            val hi: Int = aux.size - 1
            val mid: Int = lo + ((lo + hi) / 2)

            var i = lo
            var j = a.size
            for (k in lo..hi) {
                res[k] = when {
                    (i > a.size - 1) -> aux[j++]
                    (j > hi) -> aux[i++]
                    (aux[j] < aux[i]) -> aux[j++]
                    else -> aux[i++]
                }
            }
            return res
        }
    }
}