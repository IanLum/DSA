package org.example

import kotlin.random.Random
import kotlin.time.DurationUnit
import kotlin.time.measureTime

fun benchmarking(numValues: List<Int>, forGSheets: Boolean) {
    val allNums = MutableList(numValues.max() * 5) { it }
    println("Size | Standard | Strassen")
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