package org.example

fun lookRight(half: List<Int>): Int {
    var sum = 0
    var max = Int.MIN_VALUE
    half.forEach {
        sum += it
        if (sum > max) max = sum
    }
    return max
}

fun merge(half1: List<Int>, half2: List<Int>): Int {
    return lookRight(half1.asReversed()) + lookRight(half2)
}

fun maxSubsequence(list: List<Int>): Int {
    if (list.size == 1) {
        return list.first()
    }
    val split = list.size / 2
    val half1 = list.take(split)
    val half2 = list.drop(split)
    return maxOf(
        maxSubsequence(half1),
        maxSubsequence(half2),
        merge(half1, half2)
    )
}