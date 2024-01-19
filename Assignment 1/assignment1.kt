import java.io.File

fun main() {
    val lines = File("Assignment 1/day1_test.txt").readLines()
    var sum = 0
    for (line in lines) {
        var digs = ""
        for (char in line) {
            if (char.isDigit()) {
                digs += char
            }
        }
        sum += digs[0].digitToInt() * 10 + digs.last().digitToInt()
    }
    print(sum)
}