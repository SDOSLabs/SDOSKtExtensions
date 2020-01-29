package es.sdos.library.ktextensions

import org.junit.Assert.*
import org.junit.Test

class ObjectUnitTest {
    //region Test properties
    private val defaultValue = 0L
    private val firstNumber = 10L
    private val secondNumber = 20L
    private val thirdNumber = 30L
    private val nullNumber: Long? = null
    private val multiplier = 10
    //endregion

    //region whenNotNull
    @Test
    fun whenNotNull_notNullNumber_shouldReturnOperationResult() {
        val resultWithoutTypeTransformation = firstNumber.whenNotNull {
            it * multiplier
        }
        assertEquals(resultWithoutTypeTransformation, firstNumber * multiplier)
    }

    @Test
    fun whenNotNull_nullNumber_shouldReturnNull() {
        val resultWithTypeTransformation = nullNumber.whenNotNull {
            "" + it * multiplier
        }
        assertEquals(resultWithTypeTransformation, null)
    }
    //endregion

    //region doIfNotNull
    @Test
    fun doIfNotNull_twoValuesWithNotNull_shouldReturnResultOperation() {
        var firstOp = defaultValue
        doIfNotNull(firstNumber, secondNumber) { first, second ->
            firstOp = first * second
        }
        assertEquals(firstOp, firstNumber * secondNumber)
    }

    @Test
    fun doIfNotNull_twoValuesWithOneNull_shouldReturnDefaultResult() {
        var secondOp = defaultValue
        doIfNotNull(firstNumber, nullNumber) { first, second ->
            secondOp = first * second
        }
        assertEquals(secondOp, defaultValue)
    }

    @Test
    fun doIfNotNull_threeValuesWithNotNull_shouldReturnResultOperation() {
        var firstOp = defaultValue
        doIfNotNull(firstNumber, secondNumber, thirdNumber) { first, second, third ->
            firstOp = first * second * third
        }
        assertEquals(firstOp, firstNumber * secondNumber * thirdNumber)
    }

    @Test
    fun doIfNotNull_threeValuesWithOneNull_shouldReturnDefaultResult() {
        var secondOp = defaultValue
        doIfNotNull(firstNumber, nullNumber, thirdNumber) { first, second, third ->
            secondOp = first * second * third
        }
        assertEquals(secondOp, defaultValue)
    }
    //endregion
}
