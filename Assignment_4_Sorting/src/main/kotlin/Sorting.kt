package org.example

import java.util.*

fun selectionSort(data: List<Int>): List<Int> {
    for (startIdx in data.indices) {
        var min = Pair(startIdx, data[startIdx])
        for ((idx, num) in data.drop(startIdx).withIndex())
            if (num < min.second) min = Pair(idx+startIdx, num)
        Collections.swap(data, startIdx, min.first)
    }
    return data
}

fun quickSort(data: List<Int>): List<Int> {
    if (data.size <= 1) return data

    val pivot = data[0]
    var storeIdx = 1
    for ((idx, num) in data.drop(1).withIndex()) {
        if (num < pivot) {
            Collections.swap(data, storeIdx, idx + 1)
            ++storeIdx
        }
    }
    val headPartition = data.slice(1..<storeIdx)
    val tailPartition = data.drop(storeIdx)

    return quickSort(headPartition) + data[0] + quickSort(tailPartition)
}

fun mergeSort(data: MutableList<Int>): MutableList<Int> {
    TODO()
}

fun radixSort(data: MutableList<Int>): MutableList<Int> {
    TODO()
}