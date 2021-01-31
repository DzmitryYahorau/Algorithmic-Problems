package design

import java.util.*

class MinStack() {

    private val stack = Stack<Int>()
    private val minStack = Stack<Int>()

    fun push(x: Int) {
        if(minStack.isEmpty() || minStack.peek() >= x){
            minStack.push(x)
        }
        stack.push(x)
    }

    fun pop() {
        if(stack.peek() == minStack.peek()){
            minStack.pop()
        }

        stack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }

}