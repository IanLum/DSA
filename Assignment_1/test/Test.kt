import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.File

class Test {
    @Test
    fun part1_test() {
        val lines = File("data/day1_test.txt").readLines()
        assertEquals(142, part1(lines))
    }
    @Test
    fun part2_test() {
        val lines = File("data/day1pt2_test.txt").readLines()
        assertEquals(281, part2(lines))
    }
}