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

fun merge(part1: MutableList<Int>, part2: MutableList<Int>): List<Int> {
    val out = mutableListOf<Int>()
    while (part1.isNotEmpty() or part2.isNotEmpty()) {
        if ((part1.firstOrNull() ?: Int.MAX_VALUE) < (part2.firstOrNull() ?: Int.MAX_VALUE))
            out.add(part1.removeFirst())
        else
            out.add(part2.removeFirst())
    }
    return out
}

fun mergeSort(data: List<Int>): List<Int> {
    var partitions = data.chunked(1)
    while (partitions.size > 1) {
        val newPartitions = mutableListOf<List<Int>>()
        partitions.chunked(2).forEach {
            if (it.size == 2)
                newPartitions.add(merge(it[0].toMutableList(), it[1].toMutableList()))
            else
                newPartitions.add(it[0])
        }
        partitions = newPartitions
    }
    return partitions[0]
}

fun radixSort(data: MutableList<Int>): MutableList<Int> {
    TODO()
}