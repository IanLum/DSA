package org.example

import kotlin.math.*

/**
 * A data class to handle complex number arithmetic
 */
data class Complex(val real: Double, val imag: Double) {
    /**
     * Add two complex numbers together
     * @return The sum of the two complex numbers
     */
    operator fun plus(c: Complex): Complex = Complex(real + c.real, imag + c.imag)

    /**
     * Multiply two complex numbers together
     * @return The product of the two complex numbers
     */
    operator fun times(c: Complex): Complex = Complex(
        real * c.real - imag * c.imag,
        real * c.imag + imag * c.real)

    /**
     * The absolute value or magnitude of this complex number, calculated  as Euclidean distance
     * @return The absolute value of the complex number
     */
    fun abs(): Double = sqrt(real.pow(2) + imag.pow(2))
}

/**
 * Perform a Fast Fourier Transform, using the Cooley–Tukey algorithm
 * @param x: The input signal as a one dimensional list of complex numbers
 * @return The frequency domain representation of the input signal
 */
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