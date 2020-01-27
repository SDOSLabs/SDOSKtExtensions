package es.sdos.ktextensions

import org.junit.Test
import org.junit.Assert.*

class CollectionUnitTest {
    @Test
    fun isBlank_isCorrect() {
        val emptyList = listOf<String>()
        assertEquals(emptyList.isBlank(), true)

        val notEmptyList = listOf("1", "2")
        assertEquals(notEmptyList.isBlank(), false)

        val listWithNulls = listOf(null, null)
        assertEquals(listWithNulls.isBlank(), false)
    }

    @Test
    fun anyNull_isCorrect() {
        val listWithNulls = listOf("1", "2", null)
        assertEquals(listWithNulls.anyNull(), true)
    }

    @Test
    fun allNull_isCorrect() {
        val listWithAllNulls = listOf(null, null, null)
        assertEquals(listWithAllNulls.allNull(), true)

        val listWithNulls = listOf(null, "1", null)
        assertEquals(listWithNulls.allNull(), false)
    }

    @Test
    fun countNulls_isCorrect() {
        val listWithAllNulls = listOf(null, null, null)
        assertEquals(listWithAllNulls.countNulls(), 3)

        val listWithNulls = listOf(null, "1", null)
        assertEquals(listWithNulls.countNulls(), 2)

        val list = listOf("1", "2")
        assertEquals(list.countNulls(), 0)
    }

    @Test
    fun countNonNulls_isCorrect() {
        val listWithAllNulls = listOf(null, null, null)
        assertEquals(listWithAllNulls.countNonNulls(), 0)

        val listWithNulls = listOf(null, "1", null)
        assertEquals(listWithNulls.countNonNulls(), 1)
    }

    @Test
    fun trimNulls_isCorrect() {
        val listWithAllNulls = listOf(null, null, null)
        assertEquals(listWithAllNulls.trimNulls().size, 0)

        val listWithNulls = listOf(null, "1", null)
        assertEquals(listWithNulls.trimNulls().size, 1)
    }

    @Test
    fun trimNullsToMutableList_isCorrect() {
        val listWithAllNulls = listOf(null, null, null)
        assertEquals(listWithAllNulls.trimNullsToMutableList().size, 0)

        val listWithNulls = listOf(null, "1", null)
        assertEquals(listWithNulls.trimNullsToMutableList() is MutableList, true)
    }

    @Test
    fun trim_isCorrect() {
        val listWithBlankValues = listOf("", "", "1", " ")
        assertEquals(listWithBlankValues.trim().size, 1)
    }

    @Test
    fun trimToMutableList_isCorrect() {
        val listWithBlankValues = listOf("", "", "1", " ")
        assertEquals(listWithBlankValues.trimToMutableList().size, 1)

        val listToCompareClass = listOf("", "1", "")
        assertEquals(listToCompareClass.trimToMutableList() is MutableList, true)
    }

    @Test
    fun split_isCorrect() {
        val list = listOf("1", "2", "3", "4")
        assertEquals(list.split(3), Pair(listOf("1", "2", "3"), listOf("4")))

        val listWithImparValues = listOf("1", "2", "3", "4", "5")
        assertEquals(listWithImparValues.split(), Pair(listOf("1", "2"), listOf("3", "4", "5")))
    }

    @Test
    fun isNotEmpty_isCorrect() {
        val mapWithValues = mapOf<String, Any>("1" to 1, "2" to 2, "3" to 3)
        assertEquals(true, mapWithValues.isNotEmpty())

        val emptyMap = mapOf<String, String>()
        assertEquals(false, emptyMap.isNotEmpty())

        val nullMap: Map<String, String>? = null
        assertEquals(false, nullMap.isNotEmpty())
    }
}
