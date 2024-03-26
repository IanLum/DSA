package org.example

class AssociativeList<K, V>: AssociativeArray<K, V> {
    class ListNode<K, V>(val key: K, val value: V, var next: ListNode<K, V>?)
    private var head: ListNode<K, V>? = null

    override fun set(k: K, v: V) {
        head = ListNode(k, v, head)
    }

    override fun contains(k: K): Boolean {
        return get(k) != null
    }

    override fun get(k: K): V? {
        var curr = head
        while (curr != null) {
            if (curr.key == k)
                return curr.value
            curr = curr.next
        }
        return null
    }

    override fun remove(k: K): Boolean {
        head?.also {
            // Run if head is not null
            if (it.key == k) {
                // Special case if head is holding the key to remove
                head = it.next
                return true
            }

            // Otherwise, loop through nodes until the key is found
            var prev = it
            var curr = it.next
            while (curr != null) {
                if (curr.key == k) {
                    // Link nodes across the removed value
                    prev.next = curr.next
                    return true
                }
                prev = curr
                curr = curr.next
            }
        }
        return false
    }

    override fun size(): Int {
        TODO("Not yet implemented")
    }

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