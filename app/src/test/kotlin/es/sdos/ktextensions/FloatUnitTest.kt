package es.sdos.ktextensions

import org.junit.Test

import org.junit.Assert.*


class FloatUnitTest {
    @Test
    fun round_isCorrect() {
        assertEquals(100.542F.round(), 100.54F)
        assertEquals(100.540F.round(), 100.54F)
        assertEquals(100.545F.round(), 100.54F)
        assertEquals(100.5456F.round(), 100.55F)
        assertEquals(100.549F.round(), 100.55F)
    }

    @Test
    fun toBoolean_isCorrect() {
        assertEquals(1F.toBoolean(), true)
        assertEquals(0F.toBoolean(), false)
        assertEquals(201F.toBoolean(), true)
    }
}
