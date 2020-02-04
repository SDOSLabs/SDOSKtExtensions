package es.sdos.library.ktextensions

import org.junit.Test

import org.junit.Assert.*

class FloatUnitTest {

    //region Test properties
    private val zeroNumber = 0F
    private val notEqualZeroNumber = 100F
    private val numberWithFourDecimals = 100.54432F
    private val numberWithFourDecimalsRoundToTwoDecimals = 100.54F
    private val numberWithFiveDecimals = 100.54436F
    private val numberWithFiveDecimalsRoundToFourDecimals = 100.5444F
    private val numberWithThreeDecimalsAndLastDecimalIsFive = 100.545F
    private val numberWithThreeDecimalsAndLastDecimalIsFiveRoundToTwoDecimals = 100.54F
    private val numberMaxFloat = Float.MAX_VALUE
    //endregion

    //region round
    @Test
    fun round_valuesWithDecimals_shouldReturnSuccess() {
        assertEquals(numberWithFourDecimals.round(2),
            numberWithFourDecimalsRoundToTwoDecimals)
        assertEquals(numberWithFourDecimals.round(),
            numberWithFourDecimalsRoundToTwoDecimals)
        assertEquals(numberWithFiveDecimals.round(4),
            numberWithFiveDecimalsRoundToFourDecimals)
    }

    @Test
    fun round_valueMaxFloat_shouldReturnSameNumber() {
        assertEquals(numberMaxFloat.round(2),
            numberMaxFloat)
    }

    @Test
    fun round_lastDecimalIsFive_shouldReturnEquals() {
        assertEquals(numberWithThreeDecimalsAndLastDecimalIsFive.round(2),
            numberWithThreeDecimalsAndLastDecimalIsFiveRoundToTwoDecimals)
    }
    //endregion

    //region toBoolean
    @Test
    fun toBoolean_notEqualToZero_shouldReturnTrue() {
        assertEquals(notEqualZeroNumber.toBoolean(), true)
    }

    @Test
    fun toBoolean_equalToZero_shouldReturnFalse() {
        assertEquals(zeroNumber.toBoolean(), false)
    }
    //endregion
}
