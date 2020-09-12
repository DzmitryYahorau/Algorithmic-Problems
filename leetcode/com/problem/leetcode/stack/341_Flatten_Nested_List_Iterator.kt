package stack

import java.util.*

class NestedIterator(nestedList: List<NestedInteger>) {

    val stack = Stack<Int>()

    init {
        val ints = mutableListOf<Int>()
        parseList(ints, nestedList)
        for (i in ints.lastIndex downTo 0) {
            stack.push(ints[i])
        }
    }

    fun next(): Int = stack.pop()

    fun hasNext(): Boolean = stack.isNotEmpty()

    private fun parseList(result: MutableList<Int>, nestedList: List<NestedInteger>) {
        nestedList.forEach { nested ->
            if (nested.isInteger()) {
                result.add(nested.getInteger() ?: 0)
            } else {
                val list = nested.getList()
                if (list != null) {
                    parseList(result, list)
                }
            }
        }
    }
}

/**
 * This is the interface that allows for creating nested lists.
 *  You should not implement it, or speculate about its implementation
 */

class NestedInteger {

    // Constructor initializes an empty nested list.
    constructor() {}

    // Constructor initializes a single integer.
    constructor(value: Int) {}

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    fun isInteger(): Boolean = true

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    fun getInteger(): Int? {
        return null
    }

    // Set this NestedInteger to hold a single integer.
    fun setInteger(value: Int): Unit {

    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    fun add(ni: NestedInteger): Unit {

    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    fun getList(): List<NestedInteger>? = emptyList()
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * var obj = NestedIterator(nestedList)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */