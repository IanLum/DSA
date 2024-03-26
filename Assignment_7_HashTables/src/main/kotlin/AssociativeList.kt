package org.example

class AssociativeList<K, V>: AssociativeArray<K, V> {
    class ListNode<K, V>(val key: K, var value: V, var next: ListNode<K, V>?)
    private var head: ListNode<K, V>? = null
    private var size: Int = 0

    /**
     * @return the [ListNode] associated with the key [k] or null if it doesn't exist
     */
    private fun getNode(k: K): ListNode<K, V>? {
        var curr = head
        while (curr != null) {
            if (curr.key == k)
                return curr
            curr = curr.next
        }
        return null
    }

    override fun set(k: K, v: V) {
        getNode(k)?.also {
            // If key node exists (is not null), override it
            it.value = v
        } ?: run {
            // Otherwise, add a fresh node to head
            head = ListNode(k, v, head)
            size += 1
        }
    }

    override fun contains(k: K): Boolean {
        return getNode(k) != null
    }

    override fun get(k: K): V? = getNode(k)?.value

    override fun remove(k: K): Boolean {
        head?.also {
            // Run if head is not null
            if (it.key == k) {
                // Special case if head is holding the key to remove
                head = it.next
                size -= 1
                return true
            }

            // Otherwise, loop through nodes until the key is found
            var prev = it
            var curr = it.next
            while (curr != null) {
                if (curr.key == k) {
                    // Link nodes across the removed value
                    prev.next = curr.next
                    size -= 1
                    return true
                }
                prev = curr
                curr = curr.next
            }
        }
        return false
    }

    override fun size(): Int = size

    override fun keyValuePairs(): List<Pair<K, V>> {
        val out = mutableListOf<Pair<K, V>>()
        var curr = head
        while (curr != null) {
            out.add(Pair(curr.key, curr.value))
            curr = curr.next
        }
        return out
    }

}