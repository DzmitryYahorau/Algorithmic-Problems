package hashtable

class ContainsDuplicate() {

    fun containsDuplicate(nums: IntArray): Boolean {
        val map = mutableMapOf<Int, Int>()

        for (i in nums.indices) {
            if (map.containsKey(nums[i])) {
                return true
            } else {
                map[nums[i]] = i
            }
        }

        return false
    }
}