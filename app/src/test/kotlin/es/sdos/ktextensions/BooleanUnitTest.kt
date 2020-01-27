package es.sdos.ktextensions

import org.junit.Test

import org.junit.Assert.*


class BooleanUnitTest {
    @Test
    fun isTrue_isCorrect() {
        val boolean: Boolean? = true
        val booleanNull: Boolean? = null
        assertEquals(boolean.isTrue(), true)
        assertEquals(booleanNull.isTrue(), false)
    }

    @Test
    fun toLong_isCorrect() {
        assertEquals(true.toLong(), -1L)
        assertEquals(false.toLong(), 0L)
    }

    @Test
    fun toDouble_isCorrect() {
        assertEquals(true.toDouble(), -1.0, 0.1)
        assertEquals(false.toDouble(), 0.0, 0.1)
    }
}
