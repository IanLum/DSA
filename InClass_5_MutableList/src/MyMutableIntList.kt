class MyMutableIntList {
    private var array = IntArray(1)
    private var s = 0

    /**
     * Add [element] to the end of the list
     */
    fun add(element: Int, bad: Boolean = false) {
        if (s == array.size) {
            array = array.copyOf(if (!bad) (array.size * 2) else (array.size + 1))
        }
        array[s] = element
        s++
    }

    /**
     * Remove all elements from the list
     */
    fun clear() {
        array = IntArray(array.size)
        s = 0
    }

    /*
     * @return the size of the list
     */
    fun size(): Int {
        return s
    }

    /**
     * @param index the index to return
     * @return the element at [index]
     */
    operator fun get(index: Int):Int {
        return array[index]
    }

    /**
     * Store [value] at position [index]
     * @param index the index to set
     * @param value to store at [index]
     */
    operator fun set(index: Int, value: Int) {
        array[index] = value
    }
}