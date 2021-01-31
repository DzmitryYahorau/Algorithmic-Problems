package tree

import ListNode

fun sortedListToBST(head: ListNode?): TreeNode? {
    if (head == null) return null
    val list = mutableListOf<ListNode>()

    var i = head
    while (i != null) {
        list.add(i)
        i = i.next
    }

    if (list.size == 1) return TreeNode(head.`val`)

    return sortedArrayToBST(list.map { it.`val` }.toIntArray())
}

//    fun sortedArrayToBST(nums: IntArray): TreeNode? =
//            when (nums.size) {
//                0 -> null
//                else -> {
//                    val mid = nums.size / 2
//                    TreeNode(nums[mid]).apply {
//                        left = sortedArrayToBST(nums.sliceArray(0 until mid))
//                        right = sortedArrayToBST(nums.sliceArray(mid + 1..nums.lastIndex))
//                    }
//                }
//            }



