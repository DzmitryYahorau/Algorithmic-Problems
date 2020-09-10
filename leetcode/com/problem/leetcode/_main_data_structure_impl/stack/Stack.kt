package _main_data_structure_impl.stack

interface Stack {

    fun push(item: String)

    fun pop(): String?

    fun isEmpty(): Boolean
}