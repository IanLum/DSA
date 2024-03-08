package org.example
import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.letsplot.export.save
import org.jetbrains.kotlinx.kandy.letsplot.layers.points
import kotlin.math.*

fun main() {
    val t = List(16) { it }
    val x = t.map { Complex(sin(it.toDouble()), 0.0) }
    val y = fft(x)
    val yAbs = y.map { it.abs() }
    println(yAbs)

    plot() {
        points {
            x(t)
            y(yAbs)
        }
    }.save("fft.png")
}