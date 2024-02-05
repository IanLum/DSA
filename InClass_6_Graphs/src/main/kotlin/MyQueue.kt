class MyQueue<T> : Queue<T> {
    private var list = DoublyLinkedList<T>()

    override fun enqueue(data: T) {
        list.pushFront(data)
    }

    override fun dequeue(): T? = list.popBack()

    override fun peek(): T? = list.peekBack()

    override fun isEmpty(): Boolean = list.isEmpty()
}