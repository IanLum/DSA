package org.example

class AssociativeList<K, V>: AssociativeArray<K, V> {
    class ListNode<K, V>(val key: K, val value: V, val next: ListNode<K, V>?)
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
        TODO("Not yet implemented")
    }

    override fun size(): Int {
        TODO("Not yet implemented")
    }

    override fun keyValuePairs(): List<Pair<K, V>> {
        TODO("Not yet implemented")
    }

}