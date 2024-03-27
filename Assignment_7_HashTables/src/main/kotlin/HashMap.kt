package org.example

/**
 * Prime numbers used as array sizes for the division hashing hash table
 * https://planetmath.org/goodhashtableprimes
 */
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

/**
 * @property size: The number of elements currently stored in the hashmap
 * @property sizeIdx: The current index of [maxSize] in [goodPrimes]
 * @property maxSize: The current number of buckets in the hashmap, determined by [goodPrimes]
 * @property buckets: An array of [AssociativeList], holds the key value pairs
 */
class HashMap<K, V>: AssociativeArray<K, V> {
    private var size: Int = 0
    private var sizeIdx: Int = 0
    private var maxSize: Int = goodPrimes[sizeIdx]
    private var buckets = Array<AssociativeList<K, V>>(maxSize) { AssociativeList() }

    /**
     * Hash a value to an [Int]
     * Only implemented on [Number] ([Byte], [Short], [Int], [Long], [Float], [Double])
     * as well as [String] and [Char]. Will through an error if another type is received
     *
     * @return The hash of the value as an [Int]
     * Hashes [Number] by converting to [Int] and taking the modulo with [maxSize]
     * Hashes [String] by converting each character to ascii, and, starting with the first character,
     * alternating between multiplying and taking the modulo. Returns the modulo of the result with [maxSize]
     * Hashes [Char] by converting to ascii and taking the modulo with [maxSize]
     */
    private fun <K> hash(k: K): Int {
        return when (k) {
            is Number -> k.toInt() % maxSize
            is String -> k.map { it.code }
                .reduceIndexed { idx, acc, num ->
                    if (idx % 2 == 0) acc % num else acc + num
                } % maxSize
            is Char -> k.code % maxSize
            else -> error("Invalid Key Type")
        }
    }
    override fun set(k: K, v: V): Boolean {
        if (size == maxSize) resize()
        val res = buckets[hash(k)].set(k, v)
        if (res) size += 1
        return res
    }

    /**
     * Resize the number of [buckets] by setting the size to the next [goodPrimes] and re-adding each element.
     * Can only resize up to the largest [goodPrimes], 1610612741, above which will throw and error
     */
    private fun resize() {
        // Update size attributes
        sizeIdx += 1
        if (sizeIdx >= goodPrimes.size)
            error("HashMap overfull, more than ${goodPrimes.last()} elements")
        maxSize = goodPrimes[sizeIdx]
        // Save existing elements
        val elements = keyValuePairs()
        // Reset and refill buckets
        buckets = Array<AssociativeList<K, V>>(maxSize) { AssociativeList() }
        size = 0
        elements.forEach { (key, value) ->
            set(key, value)
        }
    }

    override fun contains(k: K): Boolean = buckets[hash(k)].contains(k)

    override fun get(k: K): V? = buckets[hash(k)][k]

    override fun remove(k: K): Boolean {
        val res = buckets[hash(k)].remove(k)
        if (res) size -= 1
        return res
    }

    override fun size(): Int = size

    /**
     * @return The private property [maxSize]
     */
    fun maxSize(): Int = maxSize

    override fun keyValuePairs(): List<Pair<K, V>> {
        val out = mutableListOf<Pair<K, V>>()
        buckets.forEach {
            out += it.keyValuePairs()
        }
        return out
    }
}