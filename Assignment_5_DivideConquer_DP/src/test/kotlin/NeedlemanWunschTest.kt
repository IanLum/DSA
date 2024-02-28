import org.example.needlemanWunsch
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class NeedlemanWunschTest {

    @Test
    fun diffLengthStrings() {
        assertEquals(
            Pair("AATCG", "--TCG"),
            needlemanWunsch("AATCG", "TCG")
        )
    }

    @Test
    fun bothGap() {
        assertEquals(
            Pair("AT-CG", "-TGCG"),
            needlemanWunsch("ATCG", "TGCG")
        )
    }

    @Test
    fun branchingAnswer() {
        assertEquals(
            Pair("G-ATTACA", "GCAT-GCG"),
            needlemanWunsch("GATTACA", "GCATGCG")
        )
    }
}