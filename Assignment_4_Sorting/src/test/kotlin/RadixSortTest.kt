import org.sorting.radixSort
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class RadixSortTest {

    @Test
    fun singleDigit() {
        val l = mutableListOf(4,8,2,3,8,5)
        val exp = mutableListOf(2,3,4,5,8,8)
        assertEquals(exp, radixSort(l))
    }
    @Test
    fun multiDigit() {
        val l = mutableListOf(4345,6896,347,568,3,36,209)
        val exp = mutableListOf(3,36,209,347,568,4345,6896)
        assertEquals(exp, radixSort(l))
    }

    @Test
    fun allSame() {
        val l = mutableListOf(3,3,3,3)
        val exp = mutableListOf(3,3,3,3)
        assertEquals(exp, radixSort(l))
    }

    @Test
    fun duplicates() {
        val l = mutableListOf(3,4,3,4,3,4,3)
        val exp = mutableListOf(3,3,3,3,4,4,4)
        assertEquals(exp, radixSort(l))
    }

    @Test
    fun empty() {
        val l = mutableListOf<Int>()
        val exp = mutableListOf<Int>()
        assertEquals(exp, radixSort(l))
    }

    @Test
    fun multiplesOf100() {
        val l = mutableListOf(700,400,1000,300,600)
        val exp = mutableListOf(300,400,600,700,1000)
        assertEquals(exp, radixSort(l))
    }

    @Test
    fun unevenDigits() {
        val l = mutableListOf(2003,4,70,139876,21,600)
        val exp = mutableListOf(4,21,70,600,2003,139876)
        assertEquals(exp, radixSort(l))
    }
}