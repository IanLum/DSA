package org.example

// https://planetmath.org/goodhashtableprimes
val goodPrimes = arrayOf(
    // I added these to test smaller array sizes
    7,
    11,
    17,
    29,
    // -----
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
    private var size: Int = 0
    private var sizeIdx: Int = 0
    private var maxSize: Int = goodPrimes[sizeIdx]
    private val buckets = Array<AssociativeList<K, V>>(maxSize) { AssociativeList() }

    private fun <K> hash(k: K): Int {
        return when (k) {
            is Number -> k.toInt() % maxSize
            is String -> k.map { it.code }
                .joinToString("")
                .toInt() % maxSize
            is Char -> k.code % maxSize
            else -> error("Invalid Key Type")
        }
    }
    override fun set(k: K, v: V) {
        buckets[hash(k)][k] = v
    }

    override fun contains(k: K): Boolean = buckets[hash(k)].contains(k)

    override fun get(k: K): V? = buckets[hash(k)][k]

    override fun remove(k: K): Boolean = buckets[hash(k)].remove(k)

    override fun size(): Int {
        TODO("Not yet implemented")
    }

    override fun keyValuePairs(): List<Pair<K, V>> {
        val out = mutableListOf<Pair<K, V>>()
        buckets.forEach {
            out += it.keyValuePairs()
        }
        return out
    }
}