import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DoublyLinkedListTest {

    @Test
    fun pushFront() {
        val dll = DoublyLinkedList<Int>()
        dll.pushFront(0)
        assertEquals(0, dll.peekFront())
        assertEquals(0, dll.peekBack())
        dll.pushFront(1)
        assertEquals(1, dll.peekFront())
        assertEquals(0, dll.peekBack())
    }

    @Test
    fun pushBack() {
        val dll = DoublyLinkedList<Int>()
        dll.pushBack(0)
        assertEquals(0, dll.peekFront())
        assertEquals(0, dll.peekBack())
        dll.pushBack(1)
        assertEquals(0, dll.peekFront())
        assertEquals(1, dll.peekBack())
    }

    @Test
    fun pushBoth() {
        val dll = DoublyLinkedList<Int>()
        dll.pushFront(0)
        dll.pushFront(1)
        dll.pushBack(2)
        dll.pushBack(3)
        assertEquals(1, dll.peekFront())
        assertEquals(3, dll.peekBack())

    }

    @Test
    fun popFront() {
        val dll = DoublyLinkedList<Int>()
        dll.pushFront(0)
        dll.pushFront(1)
        dll.pushBack(2)
        assertEquals(1, dll.popFront())
        assertEquals(0, dll.popFront())
        assertEquals(2, dll.popFront())
    }

    @Test
    fun popBack() {
        val dll = DoublyLinkedList<Int>()
        dll.pushBack(0)
        dll.pushBack(1)
        dll.pushFront(2)
        assertEquals(1, dll.popBack())
        assertEquals(0, dll.popBack())
        assertEquals(2, dll.popBack())
    }

    @Test
    fun peekFront() {
        val dll = DoublyLinkedList<Int>()
        dll.pushBack(0)
        assertEquals(0, dll.peekFront())
        dll.pushFront(1)
        assertEquals(1, dll.peekFront())
    }

    @Test
    fun peekBack() {
        val dll = DoublyLinkedList<Int>()
        dll.pushFront(0)
        assertEquals(0, dll.peekBack())
        dll.pushBack(1)
        assertEquals(1, dll.peekBack())
    }

    @Test
    fun isEmpty() {
        val dll = DoublyLinkedList<Int>()
        assertTrue(dll.isEmpty())
        dll.pushFront(0)
        assertFalse(dll.isEmpty())
        dll.pushBack(1)
        dll.popFront()
        dll.popFront()
        assertTrue(dll.isEmpty())
    }
}