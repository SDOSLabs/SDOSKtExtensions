package es.sdos.ktextensions

import org.junit.Test

import org.junit.Assert.*


class IntUnitTest {
    @Test
    fun toStringWithZero_isCorrect() {
        assertEquals(0.toStringWithZero(), "00")
        assertEquals(4.toStringWithZero(), "04")
        assertEquals(9.toStringWithZero(), "09")
        assertEquals(10.toStringWithZero(), "10")
        assertEquals(401.toStringWithZero(), "401")
    }

    @Test
    fun toInt_isCorrect() {
        val intNull: Int? = null
        assertEquals(intNull.toInt(0), 0)
        assertNotEquals(intNull.toInt(1), 0)
    }
}
