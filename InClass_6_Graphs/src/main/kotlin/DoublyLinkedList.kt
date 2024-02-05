class DoublyLinkedList<T> {
    class ListNode<T>(val data: T, var next: ListNode<T>?, var prev: ListNode<T>?)
    private var front: ListNode<T>? = null
    private var back: ListNode<T>? = null

    /**
     * Adds the element [data] to the front of the linked list.
     */
    fun pushFront(data: T) {
        front = ListNode(data, front, null)
        front?.next?.prev = front
        if (back == null) {back = front}
    }

    /**
     * Adds the element [data] to the back of the linked list.
     */
    fun pushBack(data: T) {
        back = ListNode(data, null, back)
        back?.prev?.next = back
        if (front == null) {front = back}
    }

    /**
     * Removes an element from the front of the list. If the list is empty, it is unchanged.
     * @return the value at the front of the list or nil if none exists
     */
    fun popFront(): T? {
        val frontVal = peekFront()
        front = front?.next
        if (front == null) {back = null}
        return frontVal
    }

    /**
     * Removes an element from the back of the list. If the list is empty, it is unchanged.
     * @return the value at the back of the list or nil if none exists
     */
    fun popBack(): T? {
        val backVal = peekBack()
        back = back?.prev
        if (back == null) {front = null}
        return backVal
    }

    /**
     * @return the value at the front of the list or nil if none exists
     */
    fun peekFront() = front?.data

    /**
     * @return the value at the back of the list or nil if none exists
     */
    fun peekBack() = back?.data

    /**
     * @return true if the list is empty and false otherwise
     */
    fun isEmpty() = (front == null && back == null)
}