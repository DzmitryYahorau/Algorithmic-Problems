package tree

data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return "TreeNode(`val`=$`val`, left=$left, right=$right)"
    }

    fun toValueString(): String =
            "$`val` ${left?.toValueString()} ${right?.toValueString()}"
}