package org.example

// https://planetmath.org/goodhashtableprimes
val goodPrimes = arrayOf(
    53,
    97,
    193,
    389,
    769,
    1543,
    3079,
    6151,
    12289,
    24593,
    49157,
    98317,
    196613,
    393241,
    786433,
    1572869,
    3145739,
    6291469,
    12582917,
    25165843,
    50331653,
    100663319,
    201326611,
    402653189,
    805306457,
    1610612741
)
class HashMap<K, V>: AssociativeArray<K, V> {
    private var size = 0
    private var sizeIdx = 0
    private var maxSize = goodPrimes[sizeIdx]
    private val buckets = Array<AssociativeList<K, V>>(maxSize) { AssociativeList() }

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