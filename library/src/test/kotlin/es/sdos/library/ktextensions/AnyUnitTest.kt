package es.sdos.library.ktextensions

import org.junit.Assert.*
import org.junit.Test

class AnyUnitTest {

    //region Test properties
    private val floatNumber: Float = 100.542F
    private val doubleNumber: Double = 100.542
    private val testString = "Prueba"
    private val stringClassName = String::class.java.simpleName
    private val floatClassName = Float::class.java.simpleName
    private val doubleClassName = Double::class.java.simpleName
    //endregion

    //region tag
    @Test
    fun tag_correctTag_shouldReturnTrue() {
        assertEquals(floatNumber.TAG == floatClassName.capitalize(), true)
        assertEquals(doubleNumber.TAG == doubleClassName.capitalize(), true)
        assertEquals(testString.TAG == stringClassName.capitalize(), true)
    }

    @Test
    fun tag_errorTag_shouldReturnFalse() {
        assertEquals(testString.TAG == floatClassName, false)
    }
    //endregion
}
