package es.sdos.ktextensions

import org.junit.Test

import org.junit.Assert.*


class LongUnitTest {
    @Test
    fun toBoolean_isCorrect() {
        assertEquals(1L.toBoolean(), true)
        assertEquals(0L.toBoolean(), false)
        assertEquals(201L.toBoolean(), true)
        val longNull: Long? = null
        assertEquals(longNull.toBoolean(), false)
    }

    @Test
    fun msToSeconds_isCorrect() {
        assertEquals(1000L.msToSeconds(), 1)
        assertEquals(3600L.msToSeconds(), 3)
    }

    @Test
    fun secondsToMs_isCorrect() {
        assertEquals(1L.secondsToMs(), 1000)
        assertEquals(36L.secondsToMs(), 36000)
    }

    @Test
    fun sumByLong_isCorrect() {
        val longList = mutableListOf(2L, 5L, 10L)
        assertEquals(longList.sumByLong { it * 10 }, 170)
    }
}
