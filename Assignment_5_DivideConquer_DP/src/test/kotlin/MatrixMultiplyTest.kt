import org.example.Matrix
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertContentEquals

class MatrixMultiplyTest {

    @Test
    fun multiply2x2() {
        val m = Matrix(2, arrayOf(intArrayOf(1,2), intArrayOf(3,4)))
        val n = Matrix(2, arrayOf(intArrayOf(5,6), intArrayOf(7,8)))
        val out = arrayOf(intArrayOf(19,22), intArrayOf(43,50))
        assertTrue(out contentDeepEquals m.multiply(n).getAll())
    }

    @Test
    fun identity2x2() {
        val m = Matrix(2, arrayOf(intArrayOf(1,2), intArrayOf(3,4)))
        val n = Matrix(2, arrayOf(intArrayOf(1,0), intArrayOf(0,1)))
        assertTrue(m.getAll() contentDeepEquals m.multiply(n).getAll())
    }

    @Test
    fun multiply3x3() {
        val m = Matrix(3, arrayOf(intArrayOf(1,1,1), intArrayOf(2,2,2), intArrayOf(3,3,3)))
        val n = Matrix(3, arrayOf(intArrayOf(4,5,6), intArrayOf(4,5,6), intArrayOf(4,5,6)))
        val out = arrayOf(intArrayOf(12,15,18), intArrayOf(24,30,36), intArrayOf(36,45,54))
        assertTrue(out contentDeepEquals m.multiply(n).getAll())
    }

    @Test
    fun identity3x3() {
        val m = Matrix(3, arrayOf(intArrayOf(1,1,1), intArrayOf(2,2,2), intArrayOf(3,3,3)))
        val n = Matrix(3, arrayOf(intArrayOf(1,0,0), intArrayOf(0,1,0), intArrayOf(0,0,1)))
        assertTrue(m.getAll() contentDeepEquals m.multiply(n).getAll())
    }

    @Test
    fun multiply4x4() {
        val m = Matrix(4, arrayOf(intArrayOf(1,1,1,1), intArrayOf(2,2,2,2), intArrayOf(3,3,3,3), intArrayOf(4,4,4,4)))
        val n = Matrix(4, arrayOf(intArrayOf(4,5,6,7), intArrayOf(4,5,6,7), intArrayOf(4,5,6,7), intArrayOf(4,5,6,7)))
        val out = arrayOf(intArrayOf(16, 20, 24, 28), intArrayOf(32, 40, 48, 56), intArrayOf(48, 60, 72, 84), intArrayOf(64, 80, 96, 112))
        assertTrue(out contentDeepEquals m.multiply(n).getAll())
    }

    @Test
    fun identity4x4() {
        val m = Matrix(4, arrayOf(intArrayOf(1,1,1,1), intArrayOf(2,2,2,2), intArrayOf(3,3,3,3), intArrayOf(4,4,4,4)))
        val n = Matrix(4, arrayOf(intArrayOf(1,0,0,0), intArrayOf(0,1,0,0), intArrayOf(0,0,1,0), intArrayOf(0,0,0,1)))
        assertTrue(m.getAll() contentDeepEquals m.multiply(n).getAll())
    }
}