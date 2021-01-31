package hashtable

import kotlin.math.absoluteValue

class ContainsDuplicate2 {

    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            if (map.containsKey(nums[i]) && (
                            ((map[nums[i]] ?: 0).minus(i)).absoluteValue) <= k) {
                return true
            } else {
                map[nums[i]] = i
            }
        }
        return false
    }
}