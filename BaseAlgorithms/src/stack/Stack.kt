package stack

interface Stack<Item> {

    fun push(item: Item)

    fun pop(): Item?

    fun isEmpty(): Boolean

}