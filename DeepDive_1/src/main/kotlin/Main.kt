package org.example

import kotlin.math.pow

fun main() {
//    FourierExample.matlab()
//    FourierExample.simple()

    val lens = List(25) { 2.0.pow(it).toInt() }
    benchmarking(lens)
}