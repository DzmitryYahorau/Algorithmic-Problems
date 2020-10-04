package _main_data_structure_impl.stack

interface Stack<Item> {

    fun push(item: Item)

    fun pop(): Item?

    fun isEmpty(): Boolean

}