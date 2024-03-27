import org.example.AssociativeList
import org.example.HashMap
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
class HashMapTest {

    /**
     * Test getting and setting values with [Int] keys
     */
    @Test
    fun getSetIntKey() {
        val h = HashMap<Int, Int>()
        h[1] = 3
        h[2] = 4
        assertEquals(3, h[1])
        assertEquals(4, h[2])
    }

    /**
     * Test getting and setting values with [String] keys
     */
    @Test
    fun getSetStringKey() {
        val h = HashMap<String, String>()
        h["Paul"] = "Ruvolo"
        h["Ian"] = "Lum"
        assertEquals("Ruvolo", h["Paul"])
        assertEquals("Lum", h["Ian"])
    }

    /**
     * Test getting and setting values with [Char] keys
     */
    @Test
    fun getSetCharKey() {
        val h = HashMap<Char, Char>()
        h['a'] = 'x'
        h['b'] = 'y'
        assertEquals('x', h['a'])
        assertEquals('y', h['b'])
    }

    /**
     * Test getting and setting values that have hash collisions
     */
    @Test
    fun getSetCollision() {
        val h = HashMap<Int, Char>()
        h[1] = 'a'
        h[54] = 'b'
        assertEquals('a', h[1])
        assertEquals('b', h[54])
    }

    /**
     * Test resizing hashmap when it overfills
     */
    @Test
    fun resize() {
        val h = HashMap<Int, Char>()
        for (i in 1..54) {
            h[i] = 'a'
        }
        assertEquals(54, h.size())
        assertEquals(97, h.maxSize())
        for (i in 1..54) {
            assertTrue(h.contains(i))
        }
    }


    /**
     * Test checking if hashmap contains a value
     */
    @Test
    fun contains() {
        val h = HashMap<Int, Char>()
        h[1] = 'a'
        h[2] = 'b'
        assertTrue(h.contains(1))
        assertTrue(h.contains(2))
        assertFalse(h.contains(3))
    }

    /**
     * Test that getting non-existent values returns [null]
     */
    @Test
    fun getNull() {
        val h = HashMap<Int, Char>()
        assertNull(h[1])
        assertNull(h[2])
    }

    /**
     * Test removing items. Tests colliding items and separately bucketed items.
     */
    @Test
    fun remove() {
        val h = HashMap<Int, Char>()
        h[1] = 'a'
        h[2] = 'b'
        h[54] = 'c'
        // Remove key 1
        h.remove(1)
        // Check it's been removed
        assertNull(h[1])
        assertEquals(2, h.size())
        // Check other elements
        assertEquals('b', h[2])
        assertEquals('c', h[54])

        // Remove key 2
        h.remove(2)
        // Check it's been removed
        assertNull(h[2])
        assertEquals(1, h.size())
        // Check other elements
        assertEquals('c', h[54])

        // Remove key 2
        h.remove(54)
        // Check it's been removed
        assertNull(h[54])
        assertEquals(0, h.size())
    }

    /**
     * Test that size returns the correct size when adding, removing, and overriding elements
     */
    @Test
    fun size() {
        val h = HashMap<Int, Char>()
        assertEquals(0, h.size())
        h[1] = 'a'
        assertEquals(1, h.size())
        h[2] = 'b'
        assertEquals(2, h.size())
        h[1] = 'c'
        assertEquals(2, h.size())
        h.remove(1)
        assertEquals(1, h.size())
        h.remove(2)
        assertEquals(0, h.size())
    }

    /**
     * Test that the correct list is returned from [keyValuePairs]
     */
    @Test
    fun keyValuePairs() {
        val h = HashMap<Int, Char>()
        h[1] = 'a'
        h[53] = 'b'
        h[54] = 'c'
        val exp = listOf(Pair(53, 'b'), Pair(54, 'c'), Pair(1, 'a'))
        assertEquals(exp, h.keyValuePairs())
    }
}