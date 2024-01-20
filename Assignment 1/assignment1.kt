import java.io.File

fun part1(lines: List<String>): Int {
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
    return (sum)
}

fun part2(lines: List<String>): Int {
    var sum = 0
    for (line in lines) {
        val digs = Regex("(?=(one|two|three|four|five|six|seven|eight|nine|\\d))")
            .findAll(line)
            .map{it.groupValues[1]}
            .toList()
        val wordToInt = mapOf(
            "one" to "1",
            "two" to "2",
            "three" to "3",
            "four" to "4",
            "five" to "5",
            "six" to "6",
            "seven" to "7",
            "eight" to "8",
            "nine" to "9"
        )
        sum += wordToInt.getOrDefault(digs[0], digs[0]).toInt() * 10 + wordToInt.getOrDefault(digs.last(), digs.last()).toInt()
    }
    return sum
}

fun test1() {
    val lines = File("Assignment 1/day1_test.txt").readLines()
    if (part1(lines) == 142) {
        println("Test 1 Passed :)")
    } else {
        println("Test 1 Failed :(")
    }
}

fun test2() {
    val lines = File("Assignment 1/day1pt2_test.txt").readLines()
    if (part2(lines) == 281) {
        println("Test 2 Passed :)")
    } else {
        println("Test 2 Failed :(")
    }
}

fun main() {
    val lines = File("Assignment 1/day1_input.txt").readLines()
    test1()
    test2()
    println("Solution to Part 1: ${part1(lines)}")
    println("Solution to Part 2: ${part2(lines)}")
}