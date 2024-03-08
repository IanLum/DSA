package org.example

import kotlin.math.*

data class Complex(val real: Double, val imag: Double) {
    operator fun plus(c: Complex) = Complex(real + c.real, imag + c.imag)

    operator fun times(c: Complex) = Complex(
        real * c.real - imag * c.imag,
        real * c.imag + imag * c.real)

    fun abs() = sqrt(real.pow(2) + imag.pow(2))
}

fun fft(x: List<Complex>): List<Complex> {
    val n = x.size
    if (n == 1) return x
    else if (n % 2 > 0) error("Size of x must be a power of 2")

    // Length N/2 Vectors
    val xEven = fft(x.filterIndexed { idx, _ -> idx % 2 == 0})
    val xOdd = fft(x.filterIndexed { idx, _ -> idx % 2 == 1})
    val (factorHead, factorTail) = DoubleArray(n) { it.toDouble() }.map {
        Complex(
            cos(-2 * PI * it / n),
            sin(-2 * PI * it / n)
        )
    }.chunked(n/2)

    val outHead = factorHead.mapIndexed { idx, factor -> xEven[idx] + factor * xOdd[idx] }
    val outTail = factorTail.mapIndexed { idx, factor -> xEven[idx] + factor * xOdd[idx] }

    return outHead + outTail
}