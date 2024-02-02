import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MyStackTest {

    @Test
    fun push() {
        val s = MyStack<Int>()
        s.push(0)
        assertEquals(0, s.peek())
        s.push(1)
        assertEquals(1, s.peek())
    }

    @Test
    fun pop() {
        val s = MyStack<Int>()
        s.push(0)
        s.push(1)
        assertEquals(1, s.pop())
        assertEquals(0, s.pop())
        assertTrue(s.isEmpty())
    }

    @Test
    fun peek() {
        val s = MyStack<Int>()
        s.push(0)
        assertEquals(0, s.peek())
        s.push(1)
        assertEquals(1, s.peek())
    }

    @Test
    fun isEmpty() {
        val s = MyStack<Int>()
        assertTrue(s.isEmpty())
        s.push(0)
        assertFalse(s.isEmpty())
        s.pop()
        assertTrue(s.isEmpty())
    }
}