import org.sorting.quickSort
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class QuickSortTest {

    @Test
    fun singleDigit() {
        val l = mutableListOf(4,8,2,3,8,5)
        val exp = mutableListOf(2,3,4,5,8,8)
        assertEquals(exp, quickSort(l))
    }
    @Test
    fun multiDigit() {
        val l = mutableListOf(4345,6896,347,568,3,36,209)
        val exp = mutableListOf(3,36,209,347,568,4345,6896)
        assertEquals(exp, quickSort(l))
    }

    @Test
    fun allSame() {
        val l = mutableListOf(3,3,3,3)
        val exp = mutableListOf(3,3,3,3)
        assertEquals(exp, quickSort(l))
    }

    @Test
    fun duplicates() {
        val l = mutableListOf(3,4,3,4,3,4,3)
        val exp = mutableListOf(3,3,3,3,4,4,4)
        assertEquals(exp, quickSort(l))
    }

    @Test
    fun empty() {
        val l = mutableListOf<Int>()
        val exp = mutableListOf<Int>()
        assertEquals(exp, quickSort(l))
    }
}