package array

fun removeElement(nums: IntArray, `val`: Int): Int {
    if (nums.size == 1) return nums.count { it != `val` }

    var firstIndex = 0
    var lastIndex = nums.indexOfLast { it != `val` }.takeIf { it >= 0 } ?: return 0

    while (firstIndex < lastIndex) {

        if (nums[firstIndex] == `val`) {
            swap(array = nums, firstIndex = firstIndex, secondIndex = lastIndex)

            while (lastIndex in nums.indices && nums[lastIndex] == `val`) {
                lastIndex--
            }
        }
        firstIndex++
    }

    return lastIndex + 1
}

fun swap(array: IntArray, firstIndex: Int, secondIndex: Int) {
    val temp = array[firstIndex]

    array[firstIndex] = array[secondIndex]
    array[secondIndex] = temp
}

fun main() {
//    [3,2,2,3]
//    3

    println(removeElement(intArrayOf(3, 3), 3))
}