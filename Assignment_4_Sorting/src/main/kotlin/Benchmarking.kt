package org.sorting

import kotlin.random.Random
import kotlin.time.measureTime

fun benchmarking(minVal: Int, maxVal: Int, listSizes: List<Int>) {
    val randomList = List(listSizes.max()) { Random.nextInt(minVal, maxVal)}
    println("List Size | Selection | Merge | Quick | Radix")
    listSizes.forEach {
        val list = randomList.take(it)
        val selectionTime = measureTime { selectionSort(list) }
        val mergeTime = measureTime { mergeSort(list) }
        val quickTime = measureTime { quickSort(list) }
        val radixTime = measureTime { radixSort(list) }
        print(it)
        print(" | $selectionTime")
        print(" | $mergeTime")
        print(" | $quickTime")
        print(" | $radixTime\n")
    }
}