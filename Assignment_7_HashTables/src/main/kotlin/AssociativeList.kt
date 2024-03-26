package org.example

class AssociativeList<K, V>: AssociativeArray<K, V> {
    class ListNode<K, V>(val key: K, val value: V, next: ListNode<K, V>?)
    private var head: ListNode<K, V>? = null
    override fun set(k: K, v: V) {
        TODO("Not yet implemented")
    }

    override fun contains(k: K): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(k: K): V? {
        TODO("Not yet implemented")
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