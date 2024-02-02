class MyStack<T>: Stack<T> {
    private var list = DoublyLinkedList<T>()

    override fun push(data: T) {
        list.pushFront(data)
    }

    override fun pop(): T? {
        return list.popFront()
    }

    override fun peek(): T? = list.peekFront()

    override fun isEmpty(): Boolean = list.isEmpty()
}