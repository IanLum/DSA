package org.example

import kotlin.math.sin
import kotlin.time.DurationUnit
import kotlin.time.measureTime


fun benchmarking(vecLengths: List<Int>) {
    println("Length | Time (s)")
    vecLengths.forEach { length ->
        val x = List(length) { it }
            .map {
                Complex(sin(it.toDouble()), 0.0)
            }
        val time = measureTime { fft(x) }
        println("${length}\t${time.toDouble(DurationUnit.SECONDS)}")
    }
}