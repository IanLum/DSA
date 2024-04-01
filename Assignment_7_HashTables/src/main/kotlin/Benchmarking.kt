package org.example

import kotlin.math.pow
import kotlin.random.Random
import kotlin.time.DurationUnit
import kotlin.time.measureTime

fun benchmarking(numValues: List<Int>, forGSheets: Boolean) {
    val allNums = MutableList(numValues.max() * 5) { it }
    println("Size | Associative List | Hashmap")
    numValues.forEach { size ->
        allNums.shuffle()
        val nums = allNums.take(size)
        val al = AssociativeList<Int, Int>()
        val h = HashMap<Int, Int>()

        val alTime = measureTime {
            nums.forEach {
                al[it] = it
            }
        }
        val hTime = measureTime {
            nums.forEach {
                h[it] = it
            }
        }
        print(size)
        if (forGSheets) {
            print("\t${alTime.toDouble(DurationUnit.MILLISECONDS)}")
            print("\t${hTime.toDouble(DurationUnit.MILLISECONDS)}\n")
        } else {
            print(" | $alTime")
            print(" | $hTime\n")
        }
    }
}

fun main() {
    val numValues = listOf(10, 100, 500, 1000, 5000, 10000, 50000, 100000)
    benchmarking(numValues, true)
}