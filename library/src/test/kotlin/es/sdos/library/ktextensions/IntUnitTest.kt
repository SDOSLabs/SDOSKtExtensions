package es.sdos.library.ktextensions

import org.junit.Test
import org.junit.Assert.*

class IntUnitTest {
    //region Test properties
    private val intNull: Int? = null
    private val defaultValue = 1
    private val number = 2
    private val numberWithOneDigit = 0
    private val zeroWithTwoDigits = "00"
    private val zeroWithThreeDigits = "000"
    private val tenWithFourDigits = "0010"
    private val numberWithTwoDigits = 10
    private val numberWithThreeDigit = 401
    //endregion

    //region toStringWithZero
    @Test
    fun toStringWithZero_numberWithOneDigitAndDefaultDigits_shouldReturnDefaultDigitsNumber() {
        assertEquals(numberWithOneDigit.toStringWithZero(), zeroWithTwoDigits)
    }

    @Test
    fun toStringWithZero_numberWithOneDigitAndNeedThreeDigits_shouldReturnThreeDigitsNumber() {
        assertEquals(numberWithOneDigit.toStringWithZero(3), zeroWithThreeDigits)
    }

    @Test
    fun toStringWithZero_numberWithTwoDigitsAndNeedDefaultDigits_shouldReturnDefaultDigitsNumber() {
        assertEquals(numberWithTwoDigits.toStringWithZero(), numberWithTwoDigits.toString())
    }

    @Test
    fun toStringWithZero_numberWithThreeDigitsAndPassOnlyTwoDigits_shouldReturnSameNumber() {
        assertEquals(numberWithThreeDigit.toStringWithZero(2), numberWithThreeDigit.toString())
    }

    @Test
    fun toStringWithZero_numberWithOneDigitAndNeedFourDigits_shouldReturnFourDigitsNumber() {
        assertEquals(numberWithTwoDigits.toStringWithZero(4), tenWithFourDigits)
    }
    //endregion

    //region toInt
    @Test
    fun toInt_intNullWithDefaultValue_shouldReturnDefaultValue() {
        assertEquals(intNull.toInt(defaultValue), defaultValue)
    }

    @Test
    fun toInt_notNullNumber_shouldReturnNumber() {
        assertEquals(number.toInt(1), number)
    }
    //endregion
}
