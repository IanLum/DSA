package org.example

class Matrix(private var size: Int) {
    private var m = Array(size) { IntArray(size) }

    fun get(row: Int, col: Int) = m[row][col]
    fun set(value: Int, row: Int, col: Int) {
        m[row][col] = value
    }
    fun setAll(matrix: Array<IntArray>) {
        if (matrix.size != size)
            throw Exception("Setting matrix with incorrect number of columns")
        matrix.forEachIndexed { idx, row ->
            if (row.size != size)
                throw Exception("Setting matrix with incorrect number of elements in row $idx")
        }
        m = matrix
    }

    fun getAll() = m
    fun print() {
        m.forEach {row ->
            row.forEach {
                print("$it ")
            }
            print("\n")
        }
    }
}