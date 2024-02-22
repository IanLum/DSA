package org.sorting

import kotlin.math.pow

fun main() {
    val sizes = listOf(100, 500, 1000, 5000, 9000)
    println("Values 0-100")
    benchmarking(0, 100, sizes)
    println("Values 0-10^9")
    benchmarking(0, 10.0.pow(9).toInt(), sizes)
    println("Values 10^8-10^9")
    benchmarking(10.0.pow(8).toInt(), 10.0.pow(9).toInt(), sizes)
}