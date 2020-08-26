package es.sdos.library.ktextensions

import org.junit.Test

import org.junit.Assert.*

class DoubleUnitTest {

    //region Test properties
    private val randomNotEqualToZeroNumber = 200.0
    private val zeroNumber = 0.0
    //endregion

    //region toBoolean
    @Test
    fun toBoolean_numberNotEqualToZero_shouldReturnTrue() {
        assertEquals(randomNotEqualToZeroNumber.toBoolean(), true)
    }

    @Test
    fun toBoolean_zeroNumber_shouldReturnFalse() {
        assertEquals(zeroNumber.toBoolean(), false)
    }
    //endregion
}
