import org.example.Complex
import org.example.fft
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.sin

class FourierKtTest {

    /**
     * Simple FFT test of a 16 point sine wave.
     * MATLAB used to calculate correct values.
     * 10^-4 tolerance.
     */
    @Test
    fun testFFT() {
        // Calculated with MATLAB
        val expected = listOf(
            1.935687479,
            2.295751961,
            5.118317257,
            5.151245623,
            1.405960045,
            0.762175686,
            0.522750541,
            0.4202730535,
            0.3907854659,
            0.4202730535,
            0.522750541,
            0.762175686,
            1.405960045,
            5.151245623,
            5.118317257,
            2.295751961,
        )
        val t = List(16) { it }
        val x = t.map { Complex(sin(it.toDouble()), 0.0) }
        val y = fft(x)
        val yAbs = y.map { it.abs() }
        yAbs.forEachIndexed { idx, i ->
            assertEquals(
                expected[idx], i,0.0001
            )
        }
    }
}