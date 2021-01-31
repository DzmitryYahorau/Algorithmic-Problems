package symbol_table.RBT

typealias Key = String
typealias Value = String

data class Node(val key: Key, var value: Value?, var left: Node? = null, var right: Node? = null, var color: LeafColor?)

fun Node?.isRed(): Boolean = this?.color == LeafColor.RED

enum class LeafColor {
    RED, BLACK
}
