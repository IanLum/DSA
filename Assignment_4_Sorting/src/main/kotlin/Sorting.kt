package org.example

import java.util.*

fun selectionSort(data: MutableList<Int>): MutableList<Int> {
    for (startIdx in 0..<data.size) {
        var min = Pair(startIdx, data[startIdx])
        for ((idx, num) in data.drop(startIdx).withIndex())
            if (num < min.second) min = Pair(idx+startIdx, num)
        Collections.swap(data, startIdx, min.first)
    }
    return data
}

fun quickSort(data: MutableList<Int>): MutableList<Int> {
    TODO()
}

fun mergeSort(data: MutableList<Int>): MutableList<Int> {
    TODO()
}

fun radixSort(data: MutableList<Int>): MutableList<Int> {
    TODO()
}