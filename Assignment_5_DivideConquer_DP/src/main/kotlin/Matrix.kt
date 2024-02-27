package org.example

class Matrix(
    private var size: Int,
    private var m: Array<IntArray> = Array(size) { IntArray(size) }
) {

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
        val out = Matrix(size)
        for (row in fromRow..<fromRow+size) {
            for (col in fromCol..<fromCol+size) {
                out.set(
                    this.get(row,col),
                    row-fromRow,
                    col-fromCol
                )
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

    fun strassenMultiply(other: Matrix): Matrix {
        TODO()
    }
}