package org.example
import org.jetbrains.kotlinx.multik.api.*
import org.jetbrains.kotlinx.multik.ndarray.data.*
import org.jetbrains.kotlinx.multik.ndarray.complex.*

fun main() {
    val a = mk.ndarray(mk[1, 2, 3])
    /* [1, 2, 3] */

    val b = mk.ndarray(mk[mk[1.5, 2.1, 3.0], mk[4.0, 5.0, 6.0]])
    /*
    [[1.5, 2.1, 3.0],
    [4.0, 5.0, 6.0]]
    */

    val c = mk.ndarray(mk[mk[mk[1.5f, 2f, 3f], mk[4f, 5f, 6f]], mk[mk[3f, 2f, 1f], mk[4f, 5f, 6f]]])
    /*
    [[[1.5, 2.0, 3.0],
    [4.0, 5.0, 6.0]],

    [[3.0, 2.0, 1.0],
    [4.0, 5.0, 6.0]]]
    */


    mk.zeros<Double>(3, 4) // create an array of zeros
    /*
    [[0.0, 0.0, 0.0, 0.0],
    [0.0, 0.0, 0.0, 0.0],
    [0.0, 0.0, 0.0, 0.0]]
    */
    mk.ndarray<Float, D2>(setOf(30f, 2f, 13f, 12f), intArrayOf(2, 2)) // create an array from a collection
    /*
    [[30.0, 2.0],
    [13.0, 12.0]]
    */
    val d = mk.ndarray(doubleArrayOf(1.0, 1.3, 3.0, 4.0, 9.5, 5.0), 2, 3) // create an array of shape(2, 3) from a primitive array
    /*
    [[1.0, 1.3, 3.0],
    [4.0, 9.5, 5.0]]
    */
    mk.d3array(2, 2, 3) { it * it } // create an array of 3 dimension
    /*
    [[[0, 1, 4],
    [9, 16, 25]],

    [[36, 49, 64],
    [81, 100, 121]]]
    */

    mk.d2arrayIndices(3, 3) { i, j -> ComplexFloat(i, j) }
    /*
    [[0.0+(0.0)i, 0.0+(1.0)i, 0.0+(2.0)i],
    [1.0+(0.0)i, 1.0+(1.0)i, 1.0+(2.0)i],
    [2.0+(0.0)i, 2.0+(1.0)i, 2.0+(2.0)i]]
     */

    mk.arange<Long>(10, 25, 5) // creare an array with elements in the interval [10, 25) with step 5
    /* [10, 15, 20] */

    mk.linspace<Double>(0, 2, 9) // create an array of 9 elements in the interval [0, 2]
    /* [0.0, 0.25, 0.5, 0.75, 1.0, 1.25, 1.5, 1.75, 2.0] */

    val e = mk.identity<Double>(3) // create an identity array of shape (3, 3)
    /*
    [[1.0, 0.0, 0.0],
    [0.0, 1.0, 0.0],
    [0.0, 0.0, 1.0]]
    */
}