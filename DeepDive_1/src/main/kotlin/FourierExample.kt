package org.example

import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.letsplot.export.save
import org.jetbrains.kotlinx.kandy.letsplot.feature.layout
import org.jetbrains.kotlinx.kandy.letsplot.layers.line
import org.jetbrains.kotlinx.kandy.letsplot.layers.points
import kotlin.math.PI
import kotlin.math.sin
import kotlin.random.Random

class FourierExample {
    companion object {

        /**
         * Test the [fft] function on a simple sine wave. Plot the absolute value of the result,
         * showing the amplitude of the angular frequencies present in the signal.
         */
        fun simple() {
            val t = List(16) { it }
            val x = t.map { Complex(sin(it.toDouble()), 0.0) }
            val y = fft(x)
            val yAbs = y.map { it.abs() }
            println(yAbs)

            plot() {
                points { x(t); y(yAbs) }
                layout {
                    title = "FFT of Sine Wave"
                    xAxisLabel = "Frequency (rad/sample)"
                    yAxisLabel = "Amplitude"
                }
            }.save("fft.png")
        }

        // https://www.mathworks.com/help/matlab/ref/fft.html
        fun matlab() {
            val Fs = 1000.0 // Sampling frequency
            val T = 1.0/Fs // Sampling period
            val L = 1024 // Length of signal
            val t = List(L) {it * T} // Time vector

            val X = t.map {
                0.8 + 0.7 * sin(2* PI *50*it) + sin(2* PI *120*it) + // Signal
                        Random.nextDouble(-1.0, 1.0) // Add Noise
            }

            plot() {
                line {x(t); y(X)}
                layout {
                    title = "Noisy Signal"
                    xAxisLabel = "t (s)"
                    yAxisLabel = "X(t)"
                }
            }.save("noisy_signal.png")

            val Y = fft(X.map { Complex(it, 0.0) })

            val YAbs = Y.map { it.abs() }
            val freq = List(L) { Fs / L * it }

            plot() {
                line { x(freq); y(YAbs) }
                layout {
                    title = "FFT of Noisy Signal"
                    xAxisLabel = "frequency (Hz)"
                    yAxisLabel = "Amplitude"
                }
            }.save("noisy_signal_fft.png")
        }
    }
}