package array

fun thirdMax(nums: IntArray): Int {
    var maxs = Triple<Int?, Int?, Int?>(null, null, null)

    nums.forEach { num ->
        when {
            maxs.toList().contains(num) -> Unit
            (maxs.first == null || num > maxs.first!!) -> {
                maxs = maxs.copy(first = num, second = maxs.first, third = maxs.second)
            }
            (maxs.second == null || num > maxs.second!!) -> {
                maxs = maxs.copy(second = num, third = maxs.second)
            }
            (maxs.third == null || num > maxs.third!!) -> {
                maxs = maxs.copy(third = num)
            }
        }
    }

    return maxs.third ?: maxs.first!!
}