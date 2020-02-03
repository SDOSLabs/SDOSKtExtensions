package es.sdos.library.ktextensions

import org.junit.Test
import org.junit.Assert.*

class CollectionUnitTest {

    //region Test properties
    private val listWithoutNulls = listOf("1", "2", "3")
    private val listWithAllNulls = listOf(null, null, null)
    private val listWithNullsAndNotNullValues = listOf("1", "2", null)
    private val listWithBlankValues = listOf("", "", "1", " ")
    private val listPairSize = listOf("1", "2", "3", "4")
    private val listWithOddSize = listOf("1", "2", "3", "4", "5")
    private val emptyMap = mapOf<String, String>()
    private val nullMap: Map<String, String>? = null
    private val countNullValues = 1
    private val countNotNullValues = 2
    private val countNotBlankValues = 1
    private val mapWithValues = mapOf<String, Any>("1" to 1, "2" to 2, "3" to 3)
    //endregion

    //region anyNull
    @Test
    fun anyNull_listWithNullValues_shouldReturnTrue() {
        assertEquals(listWithNullsAndNotNullValues.anyNull(), true)
    }

    @Test
    fun anyNull_listWithoutNullValues_shouldReturnFalse() {
        assertEquals(listWithoutNulls.anyNull(), false)
    }
    //endregion

    //region allNull
    @Test
    fun allNull_listWithAllNulls_shouldReturnTrue() {
        assertEquals(listWithAllNulls.allNull(), true)
    }

    @Test
    fun allNull_listWithNotNullValues_shouldReturnFalse() {
        assertEquals(listWithNullsAndNotNullValues.allNull(), false)
    }
    //endregion

    //region countNulls
    @Test
    fun countNulls_listWithAllNullValues_shouldReturnListSize() {
        assertEquals(listWithAllNulls.countNulls(), listWithAllNulls.size)
    }

    @Test
    fun countNulls_listWithOnlyOneValueNotNull_shouldReturnCountNullValues() {
        assertEquals(listWithNullsAndNotNullValues.countNulls(), countNullValues)
    }

    @Test
    fun countNulls_listWithAllNotNullValues_shouldReturnZero() {
        assertEquals(listWithoutNulls.countNulls(), 0)
    }
    //endregion

    //region countNonNulls
    @Test
    fun countNonNulls_listWithAllNullValues_shouldReturnZero() {
        assertEquals(listWithAllNulls.countNonNulls(), 0)
    }

    @Test
    fun countNonNulls_listWithOnlyOneValueNotNull_shouldReturnOne() {
        assertEquals(listWithNullsAndNotNullValues.countNonNulls(), countNotNullValues)
    }
    //endregion

    //region trimNulls
    @Test
    fun trimNulls_listWithAllNulls_shouldReturnZero() {
        assertEquals(listWithAllNulls.trimNulls().size, 0)
    }

    @Test
    fun trimNulls_listWithNullsAndNotNullValues_shouldReturnCountNotNullValues() {
        assertEquals(listWithNullsAndNotNullValues.trimNulls().size, countNotNullValues)
    }
    //endregion

    //region trimNullsToMutableList
    @Test
    fun trimNullsToMutableList_canAddItem_shouldReturnTrue() {
        val mutableEmptyList = listOf<String>().trimNullsToMutableList()
        assertEquals(mutableEmptyList.add("2"), true)
    }
    //endregion

    //region trim
    @Test
    fun trim_listWithBlankValues_shouldReturnCountNotBlankValues() {
        assertEquals(listWithBlankValues.trim().size, countNotBlankValues)
    }

    @Test
    fun trim_listWithBlankValues_shouldReturnListSize() {
        assertEquals(listWithoutNulls.trim().size, listWithoutNulls.size)
    }
    //endregion

    //region trimToMutableList
    @Test
    fun trimToMutableList_canAddItem_shouldReturnTrue() {
        val mutableEmptyList = listOf<String>().trimToMutableList()
        assertEquals(mutableEmptyList.add("2"), true)
    }
    //endregion

    //region split
    @Test
    fun split_listPairSize_shouldReturnTrue() {
        assertEquals(listPairSize.split(3), Pair(listOf("1", "2", "3"), listOf("4")))
    }

    @Test
    fun split_listWithOddSize_shouldReturnTrue() {
        assertEquals(listWithOddSize.split(), Pair(listOf("1", "2"), listOf("3", "4", "5")))
    }
    //endregion

    //region isNotEmpty
    @Test
    fun isNotEmpty_mapWithValues_shouldReturnTrue() {
        assertEquals(mapWithValues.isNotEmpty(), true)
    }

    @Test
    fun isNotEmpty_emptyMap_shouldReturnFalse() {
        assertEquals(emptyMap.isNotEmpty(), false)
    }

    @Test
    fun isNotEmpty_nullMap_shouldReturnFalse() {
        assertEquals(nullMap.isNotEmpty(), false)
    }
    //endregion
}
