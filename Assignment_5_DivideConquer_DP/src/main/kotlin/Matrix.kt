package org.example

import kotlin.math.log2
import kotlin.math.pow

class Matrix(
    private var size: Int,
    private var m: Array<IntArray> = Array(size) { IntArray(size) }
) {

    operator fun plus(other: Matrix): Matrix {
        val out = Matrix(size)
        for (row in 0..<size) {
            for (col in 0..<size) {
                out.set(
                    this.get(row, col) + other.get(row, col),
                    row,
                    col
                )
            }
        }
        return out
    }

    operator fun minus(other: Matrix): Matrix {
        val out = Matrix(size)
        for (row in 0..<size) {
            for (col in 0..<size) {
                out.set(
                    this.get(row, col) - other.get(row, col),
                    row,
                    col
                )
            }
        }
        return out
    }

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

    fun size() = size

    fun print() {
        m.forEach {row ->
            row.forEach {
                print("$it ")
            }
            print("\n")
        }
    }

    /**
     * Gets a square submatrix from a given row [fromRow] and a given column [fromCol],
     * of size [size]
     */
    fun getSlice(fromRow: Int, fromCol: Int, size: Int): Matrix {
        val m: Array<IntArray> = Array(size) { IntArray(size) }
        for (row in fromRow..<fromRow+size) {
            m[row-fromRow] = this.m[row].sliceArray(fromCol..<fromCol+size)
        }
        return Matrix(size, m)
    }

    /**
     * Pad matrix [mat] with zeros so it has size [size]
     */
    fun pad(size: Int): Matrix {
        val out = Matrix(size)
        for (row in 0..<size) {
            for (col in 0..<size) {
                val n = try {
                    this.get(row,col)
                } catch (e: ArrayIndexOutOfBoundsException) {
                    0
                }
                out.set(n,row,col)
            }
        }
        return out
    }

    /**
     * Multiply [this] matrix by [other].
     * @return [this]*[other] if the dimensions are compatible and null otherwise
     */
    fun multiply(other: Matrix): Matrix {
        if (size != other.size())
            throw Exception("Matrices do not have the same size")

        val out = Matrix(size)

        for (outRow in 0..<size) {
            for (outCol in 0..<size) {
                var sum = 0
                for (i in 0..<size) {
                    sum += this.get(outRow, i) * other.get(i, outCol)
                }
                out.set(sum, outRow, outCol)
            }
        }

        return out
    }

    companion object {
        /**
         * Stitch together 4 equal sized matrices to create on matrix twice the size
         */
        fun stitch(topLeft: Matrix, topRight: Matrix, botLeft: Matrix, botRight: Matrix): Matrix {
            val size = topLeft.size
            val m: Array<IntArray> = Array(size*2) { IntArray(size*2) }
            for (topRow in 0..<size) {
                m[topRow] = topLeft.getAll()[topRow] + topRight.getAll()[topRow]
            }
            for (botRow in 0..<size) {
                m[botRow + size] = botLeft.getAll()[botRow] + botRight.getAll()[botRow]
            }
            return Matrix(size*2, m)
        }
    }
    fun strassenMultiply(other: Matrix): Matrix {
        if (size != other.size())
            throw Exception("Matrices do not have the same size")

        var mat1 = this
        var mat2 = other

        // pad matrices if they don't have power of 2 size
        if (log2(this.size.toDouble()) % 1.0 != 0.0) {
            // the next largest power of 2
            val newSize = 2.0.pow(
                log2(
                    this.size.toDouble()
                ).toInt() + 1
            ).toInt()
            mat1 = this.pad(newSize)
            mat2 = other.pad(newSize)
        }

        return other
    }

    fun strassenRecurse(other: Matrix): Matrix {
        val half = this.size / 2
        val a11 = this.getSlice(0,0, half)
        TODO()
    }
}