package design

import java.util.*

class MyStack() {

    /** Initialize your data structure here. */
    val queue = ArrayDeque<Int>()

    /** Push element x onto stack. */
    fun push(x: Int) {
        queue.addFirst(x)
    }

    /** Removes the element on top of the stack and returns that element. */
    fun pop(): Int {
       return queue.removeFirst()
    }

    /** Get the top element. */
    fun top(): Int {
        return queue.first
    }

    /** Returns whether the stack is empty. */
    fun empty(): Boolean {
        return queue.isEmpty()
    }

}