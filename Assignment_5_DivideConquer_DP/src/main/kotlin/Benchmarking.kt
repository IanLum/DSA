package org.example

import kotlin.random.Random
import kotlin.time.DurationUnit
import kotlin.time.measureTime

fun benchmarking(minVal: Int, maxVal: Int, matSizes: List<Int>, forGSheets: Boolean) {
    println("Size | Standard | Strassen")
    matSizes.forEach { size ->
        val m = Matrix(
            size,
            Array(size) { IntArray(size) { Random.nextInt(minVal, maxVal) } }
        )
        val standardTime = measureTime { m.multiply(m) }
        val strassenTime = measureTime { m.strassenMultiply(m) }
        print(size)
        if (forGSheets) {
            print("\t${standardTime.toDouble(DurationUnit.MILLISECONDS)}")
            print("\t${strassenTime.toDouble(DurationUnit.MILLISECONDS)}\n")
        } else {
            print(" | $standardTime")
            print(" | $strassenTime\n")
        }
    }
}