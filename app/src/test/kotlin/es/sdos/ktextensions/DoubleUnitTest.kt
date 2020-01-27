package es.sdos.ktextensions

import org.junit.Test

import org.junit.Assert.*


class DoubleUnitTest {
    @Test
    fun toBoolean_isCorrect() {
        assertEquals(1.0.toBoolean(), true)
        assertEquals(0.0.toBoolean(), false)
        assertEquals(201.0.toBoolean(), true)
    }
}
