package _main_data_structure_impl.symbol_table.BST

internal data class Node(val key: Key, var value: Value?, var left: Node? = null, var right: Node? = null, var count: Int)

typealias Key = String

typealias Value = String