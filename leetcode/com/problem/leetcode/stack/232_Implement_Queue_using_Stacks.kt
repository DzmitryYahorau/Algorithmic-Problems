package stack

import java.util.*

internal class MyQueue {
    private val input: Stack<Int> = Stack()
    private val output: Stack<Int> = Stack()

    // Push element x to the back of queue.
    fun push(x: Int) {
        input.push(x)
    }

    // Time complexity O(n) worst case
    // Space complexity O(1)
    // Removes the element from in front of queue.
    fun pop(): Int {
        moveIfNeeded()
        return output.pop()
    }

    // Get the front element.
    fun peek(): Int {
        moveIfNeeded()
        return output.peek()
    }

    // Return whether the queue is empty.
    fun empty(): Boolean {
        return input.empty() && output.empty()
    }

    private fun moveIfNeeded() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop())
            }
        }
    }
}
