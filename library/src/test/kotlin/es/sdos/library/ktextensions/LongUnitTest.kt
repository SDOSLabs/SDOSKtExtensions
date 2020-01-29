package es.sdos.library.ktextensions

import org.junit.Test

import org.junit.Assert.*

class LongUnitTest {

    //region Custom Data Class
    private data class TestObject(val title: String,
                                  val price: Long)
    //endregion

    //region Test properties
    private val multiplier = 10
    private val longNull: Long? = null
    private val valueInSeconds: Long? = 2L
    private val valueInMilliseconds: Long? = 2000L
    private val firstNumber = 2L
    private val secondNumber = 5L
    private val thirdNumber = 10L
    private val longList = mutableListOf(firstNumber, secondNumber, thirdNumber)
    private val resultLongListValues = (firstNumber + secondNumber + thirdNumber) * multiplier
    //endregion

    //region toBoolean
    @Test
    fun toBoolean_valuesNotEqualsZeroOrNull_shouldReturnTrue() {
        assertEquals(1L.toBoolean(), true)
        assertEquals(201L.toBoolean(), true)
    }

    @Test
    fun toBoolean_valuesEqualsZeroOrNull_shouldReturnFalse() {
        assertEquals(0L.toBoolean(), false)
        assertEquals(longNull.toBoolean(), false)
    }
    //endregion

    //region msToSeconds
    @Test
    fun msToSeconds_valueInMilliseconds_shouldReturnSameValueInSeconds() {
        assertEquals(valueInMilliseconds.msToSeconds(), valueInSeconds)
    }
    //endregion

    //region secondsToMs
    @Test
    fun secondsToMs_valueInSeconds_shouldReturnSameValueInMilliseconds() {
        assertEquals(valueInSeconds.secondsToMs(), valueInMilliseconds)
    }
    //endregion

    //region sumByLong
    @Test
    fun sumByLong_longList_shouldReturnResultLongList() {
        assertEquals(longList.sumByLong { it * multiplier }, resultLongListValues)
    }

    @Test
    fun sumByLong_customObjectWithLongProperty_shouldReturnResultOperation() {
        val itemsList = mutableListOf<TestObject>()
        var result = 0L
        for (index in 0..10) {
            result += index * multiplier
            itemsList.add(TestObject("Item $index", index.toLong()))
        }
        assertEquals(itemsList.sumByLong { it.price * multiplier }, result)
    }
    //endregion

}
