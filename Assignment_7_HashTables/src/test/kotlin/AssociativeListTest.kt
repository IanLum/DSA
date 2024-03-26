import org.example.AssociativeList
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class AssociativeListTest {

    /**
     * Test getting and setting values
     */
    @Test
    fun getSet() {
        val al = AssociativeList<Int, Char>()
        al[1] = 'a'
        al[2] = 'b'
        assertEquals('a', al[1])
        assertEquals('b', al[2])
    }

    /**
     * Test overriding existing keys
     * Relies on [get] and [size] working
     */
    @Test
    fun setOverride() {
        val al = AssociativeList<Int, Char>()
        // Set new elements
        al[1] = 'a'
        al[2] = 'b'
        // Override an element
        al[1] = 'c'
        assertEquals('c', al[1])
        assertEquals(2, al.size())
    }

    /**
     * Test checking if list contains a value
     * Relies on [set] working
     */
    @Test
    fun contains() {
        val al = AssociativeList<Int, Char>()
        al[1] = 'a'
        al[2] = 'b'
        assertTrue(al.contains(1))
        assertTrue(al.contains(2))
        assertFalse(al.contains(3))
    }

    /**
     * Test that getting non-existent values returns [null]
     */
    @Test
    fun getNull() {
        val al = AssociativeList<Int, Char>()
        assertNull(al[1])
        assertNull(al[2])
    }

    /**
     * Test removing the head element, check that other elements are still accessible
     * Relies on [get], [set], and [size] working
     */
    @Test
    fun removeHead() {
        val al = AssociativeList<Int, Char>()
        al[1] = 'a'
        al[2] = 'b'
        al[3] = 'c'
        al.remove(3)
        // Check it's been removed
        assertNull(al[3])
        assertEquals(2, al.size())
        // Check other elements
        assertEquals('a', al[1])
        assertEquals('b', al[2])
    }

    /**
     * Test removing the center element, check that other elements are still accessible
     * Relies on [get], [set], and [size] working
     */
    @Test
    fun removeCenter() {
        val al = AssociativeList<Int, Char>()
        al[1] = 'a'
        al[2] = 'b'
        al[3] = 'c'
        al.remove(2)
        // Check it's been removed
        assertNull(al[2])
        assertEquals(2, al.size())
        // Check other elements
        assertEquals('a', al[1])
        assertEquals('c', al[3])
    }

    /**
     * Test removing the center element, check that other elements are still accessible
     * Relies on [get], [set], and [size] working
     */
    @Test
    fun removeTail() {
        val al = AssociativeList<Int, Char>()
        al[1] = 'a'
        al[2] = 'b'
        al[3] = 'c'
        al.remove(1)
        // Check it's been removed
        assertNull(al[1])
        assertEquals(2, al.size())
        // Check other elements
        assertEquals('b', al[2])
        assertEquals('c', al[3])
    }

    /**
     * Check that remove returns the proper status, true when removal was successful, false otherwise
     * Relies on [set] working
     */
    @Test
    fun removeStatus() {
        val al = AssociativeList<Int, Char>()
        al[1] = 'a'
        assertTrue(al.remove(1))
        assertFalse(al.remove(1))
    }

    /**
     * Test that size returns the correct size when adding, removing, and overriding elements
     * Relies on [set] and [remove] working
     */
    @Test
    fun size() {
        val al = AssociativeList<Int, Char>()
        assertEquals(0, al.size())
        al[1] = 'a'
        assertEquals(1, al.size())
        al[2] = 'b'
        assertEquals(2, al.size())
        al[1] = 'c'
        assertEquals(2, al.size())
        al.remove(1)
        assertEquals(1, al.size())
        al.remove(2)
        assertEquals(0, al.size())
    }

    /**
     * Test that the correct list is returned
     * Relies on [set] working
     */
    @Test
    fun keyValuePairs() {
        val al = AssociativeList<Int, Char>()
        al[1] = 'a'
        al[2] = 'b'
        al[3] = 'c'
        val exp = listOf(Pair(3, 'c'), Pair(2, 'b'), Pair(1, 'a'))
        assertEquals(exp, al.keyValuePairs())
    }
}