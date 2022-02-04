package hashtable

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    // check it has enough values for 4 sum
    if(nums.size < 4) return emptyList()

    val result = mutableListOf<List<Int>>()

    // sort array
    nums.sort()

    // fix first value
    for (i in 0 until (nums.size - 3)) {

        // check first is too large
        if (nums[i].toLong() + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
            break
        }

        /* check first is too small, search finished */
        if (nums[i].toLong() + nums[nums.lastIndex - 2].toLong() + nums[nums.lastIndex - 1].toLong() + nums[nums.lastIndex].toLong() < target.toLong()) {
            continue
        }

        // check first is not duplicate
        if ((i > 0) && (nums[i] == nums[i - 1])) {
            continue
        }

        // fix second value
        for (j in (i + 1) until (nums.size - 2)) {

            // check second is too large
            if (nums[i].toLong() + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                break
            }
            // check second is too small
            if (nums[i].toLong() + nums[j] + nums[nums.lastIndex - 1] + nums[nums.lastIndex] < target) {
                continue
            }
            // check second is not duplicate
            if ((j > i + 1) && (nums[j] == nums[j - 1])) {
                continue
            }

            // two pointers (left bound and right bound)
            var left = j + 1
            var right = nums.lastIndex

            while (left < right) {
                val `4sum` = (nums[i].toLong() + nums[j] + nums[left] + nums[right])

                // check we have target sum
                when {
                    `4sum` == target.toLong() -> {
                        result.add(listOf(nums[i], nums[j], nums[left], nums[right]))

                        // optimize for duplicates
                        while (left < right && nums[left] == nums[left + 1]) left++
                        while (left < right && nums[right] == nums[right - 1]) right--

                        left++
                        right--
                    }
                    (`4sum` < target) -> left++
                    else -> right--
                }
            }
        }
    }
    return result
}

fun main() {
    println(fourSum(intArrayOf(1,0,-1,0,-2,2), 0).joinToString())
    println(fourSum(intArrayOf(0,4,-5,2,-2,4,2,-1,4), 12).joinToString())
    println(fourSum(intArrayOf(0,0,0,1000000000,1000000000,1000000000,1000000000),
            1000000000).joinToString())

    println(fourSum(intArrayOf(0,0,0,-1000000000,-1000000000,-1000000000,-1000000000),
            -1000000000).joinToString())
}