package hashtable

/**
 * more canonical is @see bitmanipulation.singleNumber()
 */

fun singleNumber(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    val set = mutableSetOf<Int>()

    nums.forEach { num ->
        if (set.add(num)) {
            set.remove(num)
        }
    }

    return set.first()
}