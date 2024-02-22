package org.sorting

import kotlin.random.Random
import kotlin.time.DurationUnit
import kotlin.time.measureTime

fun benchmarking(minVal: Int, maxVal: Int, listSizes: List<Int>, forGSheets: Boolean = false) {
    val randomList = List(listSizes.max()) { Random.nextInt(minVal, maxVal)}
    println("List Size | Selection | Merge | Quick | Radix")
    listSizes.forEach {
        val list = randomList.take(it)
        val selectionTime = measureTime { selectionSort(list) }
        val mergeTime = measureTime { mergeSort(list) }
        val quickTime = measureTime { quickSort(list) }
        val radixTime = measureTime { radixSort(list) }
        print(it)
        if (forGSheets) {
            print("\t${selectionTime.toDouble(DurationUnit.MILLISECONDS)}")
            print("\t${mergeTime.toDouble(DurationUnit.MILLISECONDS)}")
            print("\t${quickTime.toDouble(DurationUnit.MILLISECONDS)}")
            print("\t${radixTime.toDouble(DurationUnit.MILLISECONDS)}\n")
        } else {
            print("| $selectionTime")
            print("| $mergeTime")
            print("| $quickTime")
            print("| $radixTime\n")
        }
    }
}