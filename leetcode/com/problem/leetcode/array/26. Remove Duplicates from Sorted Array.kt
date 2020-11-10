package array

fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    var i = 0
    for (j in 1 until nums.size) {
        //need to move second pointer until we find other num,
        // then put it to the first pointer
        if (nums[j] != nums[i]) {
            i++
            nums[i] = nums[j]
        }
    }
    return i + 1
}

fun main() {
//    [3,2,2,3]
//    3
    val num = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    val newSize = removeDuplicates(num)
    println(newSize)
    println(num.slice(0 until newSize).sorted().joinToString(", "))
}