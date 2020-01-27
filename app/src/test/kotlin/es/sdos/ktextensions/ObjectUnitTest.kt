package es.sdos.ktextensions

import org.junit.Assert.*
import org.junit.Test

class ObjectUnitTest {
    @Test
    fun whenNotNull_isCorrect() {
        val number = 10L
        val resultWithoutTypeTransformation = number.whenNotNull {
            it * 10
        }
        val resultWithTypeTransformation = number.whenNotNull {
            "" + it * 10
        }
        assertEquals(resultWithoutTypeTransformation, 100L)
        assertEquals(resultWithTypeTransformation, "100")
    }

    @Test
    fun doIfNotNull_twoValues_isCorrect() {
        val firstNumber = 10L
        val secondNumber = 20L
        val nullNumber: Long? = null
        var firstOp = 0L
        var secondOp = 0L
        doIfNotNull(firstNumber, secondNumber) { first, second ->
            firstOp = first * second
        }
        doIfNotNull(firstNumber, nullNumber) { first, second ->
            secondOp = first * second
        }
        assertEquals(firstOp, 200L)
        assertEquals(secondOp, 0L)
    }

    @Test
    fun doIfNotNull_threeValues_isCorrect() {
        val firstNumber = 10L
        val secondNumber = 20L
        val thirdNumber = 30L
        val nullNumber: Long? = null
        var firstOp = 0L
        var secondOp = 0L
        doIfNotNull(firstNumber, secondNumber, thirdNumber) { first, second, third ->
            firstOp = first * second * third
        }
        doIfNotNull(firstNumber, nullNumber, thirdNumber) { first, second, third ->
            secondOp = first * second * third
        }
        assertEquals(firstOp, 6000L)
        assertEquals(secondOp, 0L)
    }
}
