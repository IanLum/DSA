package org.example

const val MATCH = 1
const val MISMATCH = -1
const val INDEL = -1

var sequence1: String = "" // rows
var sequence2: String = "" // columns
var table: Array<IntArray> = emptyArray()

fun needlemanWunsch(seq1: String, seq2: String): Pair<String, String> {
    sequence1 = " $seq1"
    sequence2 = " $seq2"
    val rows = sequence1.length
    val cols = sequence2.length
    table = Array(rows) { IntArray(cols) { Int.MIN_VALUE } }
    fillTable(rows-1, cols-1)

    table.forEach {
        println(it.toList())
    }

    return Pair("","")
}

fun fillTable(row: Int, col: Int): Int {
    if (table[row][col] != Int.MIN_VALUE)
        return table[row][col]

    if (row == 0)
        table[row][col] = -col
    else if (col == 0)
        table[row][col] = -row
    else {
        val match = if (sequence1[row] == sequence2[col]) {
            MATCH
        } else {
            MISMATCH
        }

        table[row][col] = maxOf(
            fillTable(row - 1, col - 1) + match,
            fillTable(row, col - 1) + INDEL,
            fillTable(row - 1, col) + INDEL
        )
    }
    return table[row][col]
}