package org.sorting

import kotlin.random.Random
import kotlin.time.measureTime

    fun benchmarking(minVal: Int, maxVal: Int, listSizes: List<Int>) {
    val randomList = List(listSizes.max()) { Random.nextInt(minVal, maxVal)}
    listSizes.forEach {
        val list = randomList.take(it)
        val selectionTime = measureTime { selectionSort(list) }
        val mergeTime = measureTime { mergeSort(list) }
        val quickTime = measureTime { quickSort(list) }
        val radixTime = measureTime { radixSort(list) }
        print(it)
        print(" | Selection: $selectionTime")
        print(" | Merge: $mergeTime")
        print(" | Quick: $quickTime")
        print(" | Radix: $radixTime\n")
    }
}