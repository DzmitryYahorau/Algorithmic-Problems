import kotlin.math.abs

class FindDuplicateNumber {

    companion object {

        fun findDuplicate(arr: IntArray): Int {
            var result = 0
            val map = mutableMapOf<Int, Int>()
            for (i in arr.indices) {
                if (map.containsKey(arr[i])) {
                    result = arr[i]
                    break
                } else {
                    map[arr[i]] = i
                }
            }
            return result
        }
    }
}