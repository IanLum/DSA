package org.example

import kotlin.math.log2
import kotlin.math.pow

fun main() {
    println("---- Matrix Multiplication Benchmarking ----")
    val sizes = listOf(2,5,10,20,50,100,200,500)
    benchmarking(0, 20, sizes, false)

    println("---- Needleman Wunsch Alignment ----")
    val q = needlemanWunsch(
        "GATTACA",
        "GCATGCG",
        true
    )
    println(q.first)
    println(q.second)
}