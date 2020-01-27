package es.sdos.ktextensions

import org.junit.Assert.*
import org.junit.Test

class AnyUnitTest {
    @Test
    fun tag_isCorrect() {
        assertEquals(100.542F.TAG, "Float")
        assertEquals(100.542.TAG, "Double")
        assertEquals("Prueba".TAG, "String")
    }
}
