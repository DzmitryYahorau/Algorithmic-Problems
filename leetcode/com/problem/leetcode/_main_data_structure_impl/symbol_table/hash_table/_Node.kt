package _main_data_structure_impl.symbol_table.hash_table

typealias Key = String
typealias Value = String

data class Node(val key: Key, var value: Value?, var next: Node?)