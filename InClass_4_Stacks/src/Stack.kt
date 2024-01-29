/**
 * Implementation of a LIFO stack
 * @property top the top element of the stack
 */
class Stack<T>(
    private var top: StackNode<T>? = null
) {
    /**
     * Push [data] onto the stack
     * @param data the new value to put onto the stack
     */
    fun push(data: T) {
        top = StackNode(data, top)
    }

    /**
     * Pop the top element off the stack
     * @return the value of the top element if there is one, else return null
     */
    fun pop(): T? {
        val topVal = peek()
        top = top?.next
        return topVal
    }

    /**
     * @return the value of the top element if there is one, else return null
     */
    fun peek() = top?.data

    /**
     * @return true if the stack is empty, else return false
     */
    fun isEmpty() = top == null
}

/**
 * @property data the string data associated with the node
 * @property next the next node in the stack
 */
class StackNode<T>(val data: T, val next: StackNode<T>?)
