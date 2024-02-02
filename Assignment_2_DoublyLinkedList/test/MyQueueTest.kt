import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MyQueueTest {

    @Test
    fun enqueue() {
        val q = MyQueue<Int>()
        q.enqueue(0)
        assertEquals(0, q.peek())
        q.enqueue(1)
        assertEquals(0, q.peek())
    }

    @Test
    fun dequeue() {
        val q = MyQueue<Int>()
        q.enqueue(0)
        q.enqueue(1)
        assertEquals(0, q.dequeue())
        assertEquals(1, q.dequeue())
    }

    @Test
    fun peek() {
        val q = MyQueue<Int>()
        q.enqueue(0)
        assertEquals(0, q.peek())
        q.enqueue(1)
        assertEquals(0, q.peek())
        q.dequeue()
        assertEquals(1, q.peek())
    }

    @Test
    fun isEmpty() {
        val q = MyQueue<Int>()
        assertTrue(q.isEmpty())
        q.enqueue(0)
        assertFalse(q.isEmpty())
        q.dequeue()
        assertTrue(q.isEmpty())
    }
}