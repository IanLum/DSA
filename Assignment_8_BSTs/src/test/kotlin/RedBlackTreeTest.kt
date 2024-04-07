import org.example.RedBlackTree
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class RedBlackTreeTest {

    /**
     * Test that check root is black function properly returns true and false
     */
    @Test
    fun checkRootIsBlack() {
        val rbt = RedBlackTree()
        rbt.insert(1)
        assertTrue(rbt.checkRootIsBlack())
        val rbt2 = RedBlackTree()
        rbt2.insert(1, true)
        assertFalse(rbt2.checkRootIsBlack())
    }

    /**
     * Test that check red nodes have black children function properly returns true and false
     */
    @Test
    fun checkRedNodeBlackChildren() {
        val rbt = RedBlackTree()
        for (i in 1..6) {
            rbt.insert(i)
        }
        assertTrue(rbt.checkRedNodeBlackChildren())
        val rbt2 = RedBlackTree()
        for (i in 1..5) {
            rbt2.insert(i)
        }
        rbt2.insert(6, true)
        assertFalse(rbt2.checkRedNodeBlackChildren())
    }

    /**
     * Test that check black depth of leaves function properly returns true and false
     */
    @Test
    fun checkLeafBlackDepth() {
        val rbt = RedBlackTree()
        for (i in 1..6) {
            rbt.insert(i)
        }
        assertTrue(rbt.checkLeafBlackDepth())
        val rbt2 = RedBlackTree()
        rbt2.insert(1, noFixup = true)
        rbt2.insert(2, noFixup = true)
        rbt2.insert(3, noFixup = true)
        rbt2.insert(4, noFixup = false)
        assertFalse(rbt2.checkLeafBlackDepth())
    }

    /**
     * Check that invariants are always satisfied when numbers 1-30 are added
     */
    @Test
    fun checkInvariants() {
        val rbt = RedBlackTree()
        for (i in 1..30) {
            rbt.insert(i)
            assertTrue(rbt.checkInvariants())
        }
    }
}