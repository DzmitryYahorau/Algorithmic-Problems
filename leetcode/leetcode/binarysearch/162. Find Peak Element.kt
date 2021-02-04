package binarysearch

fun findPeakElement(num: IntArray): Int {
    for (i in 1 until num.size) {
        if (num[i] < num[i - 1]) {
            return i - 1
        }
    }
    return num.size - 1
}

@Suppress("unused", "className")
class `Binary search solution` {

    fun findPeakElement(num: IntArray): Int {
        var low = 0
        var high = num.size - 1

        while (low < high) {
            val mid1 = (low + high) / 2
            val mid2 = mid1 + 1
            if (num[mid1] < num[mid2])
                low = mid2
            else
                high = mid1
        }
        return low
    }
}
