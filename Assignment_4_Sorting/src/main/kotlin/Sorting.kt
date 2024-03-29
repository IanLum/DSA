package org.sorting

import java.util.*

fun selectionSort(data: List<Int>): List<Int> {
    val list = data.toList()
    for (startIdx in list.indices) {
        var min = Pair(startIdx, list[startIdx])
        for ((idx, num) in list.drop(startIdx).withIndex())
            if (num < min.second) min = Pair(idx+startIdx, num)
        Collections.swap(list, startIdx, min.first)
    }
    return list
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
    return partitions.getOrElse(0) { mutableListOf<Int>() }
}

fun radixSort(data: List<Int>): List<Int> {
    var list = data.toMutableList()
    var divisor = 1
    while (true) {
        val buckets = List(10) { mutableListOf<Int>() }
        var end = true
        // Add values to buckets
        list.forEach {
            with(it.floorDiv(divisor)) {
                // If any values is still greater than [divisor], continue
                if (this > 0) end = false
                buckets[this % 10].add(it)
            }
        }
        list = buckets.flatten().toMutableList()
        divisor *= 10
        if (end) break
    }
    return list
}