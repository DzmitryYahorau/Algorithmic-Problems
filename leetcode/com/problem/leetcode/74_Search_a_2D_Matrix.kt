private const val INVALID_INDEX = -1

class Search2DMatrix {

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val index = searchMatrixIndex(matrix, target)

        if (index == INVALID_INDEX) return false

        val result = binarySearch(
                array = matrix[index],
                lo = 0,
                hi = matrix[index].size - 1,
                target = target
        )

        return (result != INVALID_INDEX)
    }

    private fun searchMatrixIndex(matrix: Array<IntArray>, target: Int): Int {
        for (i in matrix.indices) {
            if (matrix[i].isEmpty()) return INVALID_INDEX
            val first = matrix[i].first()
            val last = matrix[i].last()

            if (target in first..last) {
                return i
            }
        }
        return INVALID_INDEX
    }

    private fun binarySearch(array: IntArray, lo: Int, hi: Int, target: Int): Int {
        if (lo == hi) return if (target == array[lo]) array[lo] else INVALID_INDEX

        val mid = lo + (hi - lo) / 2

        return when {
            target > array[mid] -> binarySearch(array, mid + 1, hi, target)
            target < array[mid] -> binarySearch(array, lo, mid, target)
            else -> array[mid]
        }
    }
}