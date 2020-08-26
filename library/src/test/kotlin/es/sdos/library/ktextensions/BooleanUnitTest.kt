package es.sdos.library.ktextensions

import org.junit.Test

import org.junit.Assert.*

class BooleanUnitTest {

    //region Test properties
    private val minusOneNumberLong = -1L
    private val zeroNumberLong = 0L
    private val minusOneNumberDouble = -1.0
    private val zeroNumberDouble = 0.0
    private val delta = 0.0
    private val booleanNull: Boolean? = null
    private val booleanTrue: Boolean? = true
    private val booleanFalse: Boolean? = false
    //endregion

    //region isTrue
    @Test
    fun isTrue_nullValue_shouldReturnFalse() {
        assertEquals(booleanNull.isTrue(), false)
    }

    @Test
    fun isTrue_falseValue_shouldReturnFalse() {
        assertEquals(booleanFalse.isTrue(), false)
    }

    @Test
    fun isTrue_trueValue_shouldReturnTrue() {
        assertEquals(booleanTrue.isTrue(), true)
    }
    //endregion

    //region toLong
    @Test
    fun toLong_trueValue_shouldReturnMinusOneLong() {
        assertEquals(true.toLong(), minusOneNumberLong)
    }

    @Test
    fun toLong_falseValue_shouldReturnZeroLong() {
        assertEquals(false.toLong(), zeroNumberLong)
    }
    //endregion

    //region toDouble
    @Test
    fun toDouble_trueValue_shouldReturnMinusOneDouble() {
        assertEquals(true.toDouble(), minusOneNumberDouble, delta)
    }

    @Test
    fun toDouble_falseValue_shouldReturnZeroDouble() {
        assertEquals(false.toDouble(), zeroNumberDouble, delta)
    }
    //endregion
}
