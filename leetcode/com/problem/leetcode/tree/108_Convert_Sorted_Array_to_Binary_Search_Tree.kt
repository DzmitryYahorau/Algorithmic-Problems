package tree

fun sortedArrayToBST(nums: IntArray): TreeNode? =
        when (nums.size) {
            0 -> null
            else -> {
                val mid = nums.size / 2
                TreeNode(nums[mid]).apply {
                    left = sortedArrayToBST(nums.sliceArray(0 until mid))
                    right = sortedArrayToBST(nums.sliceArray(mid + 1..nums.lastIndex))
                }
            }
        }