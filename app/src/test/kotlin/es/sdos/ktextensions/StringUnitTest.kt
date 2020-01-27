package es.sdos.ktextensions

import org.junit.Test

import org.junit.Assert.*


class StringUnitTest {
    @Test
    fun htmlToText_isCorrect() {
        assertEquals("<p>This text is italic</p>".htmlToText().trim(), "This text is italic")
        assertEquals("<b>This text is italic</b>".htmlToText().trim(), "This text is italic")
    }

    @Test
    fun head_isCorrect() {
        assertEquals("Hola".head(), "H")
    }

    @Test
    fun tag_isCorrect() {
        assertEquals("Hola".tag("b"), "<b>Hola</b>")
    }

    @Test
    fun capitalizeWords_isCorrect() {
        val textToCapitalize = "hola mundo"
        assertEquals(textToCapitalize.toCapitalizeWords(), "Hola Mundo")
        assertNotEquals(textToCapitalize.toCapitalizeWords(), "hola Mundo")
    }

    @Test
    fun toSentenceCase_isCorrect() {
        val textToCapitalize = "hola mundo"
        assertEquals(textToCapitalize.toSentenceCase(), "Hola mundo")
        assertNotEquals(textToCapitalize.toSentenceCase(), "Hola Mundo")
    }

    @Test
    fun toUpperCaseSafe_isCorrect() {
        val nullText: String? = null
        val textToUpperCaseSafe = "hola mundo"
        assertEquals(nullText.toUpperCaseSafe(), "")
        assertEquals(textToUpperCaseSafe.toUpperCaseSafe(), "HOLA MUNDO")
    }

    @Test
    fun isNullOrHasNullValue_isCorrect() {
        val nullText: String? = null
        val textNotNull = "hola mundo"
        val textNull = "null"
        assertEquals(nullText.isNullOrHasNullValue(), true)
        assertEquals(textNotNull.isNullOrHasNullValue(), false)
        assertEquals(textNull.isNullOrHasNullValue(), true)
    }

    @Test
    fun takeWithDots_isCorrect() {
        val text = "hola mundo"
        assertEquals(text.takeWithDots(4), "hola...")
    }

    @Test
    fun countOccurrences_isCorrect() {
        val text = "hola mundo hola mundo hola mundo mundo mundomundo"
        assertEquals(text.countOccurrences("mundo"), 6)
    }

    @Test
    fun isTrue_isCorrect() {
        val textBoolean = "true"
        val textNumber = "1"
        val textFalseNumber = "0"
        assertEquals(textBoolean.isTrue(), true)
        assertEquals(textNumber.isTrue(), true)
        assertEquals(textFalseNumber.isTrue(), false)
    }

    @Test
    fun isIndex_isCorrect() {
        val text = "Hola mundo"
        assertEquals(text.isIndex('l', 2), true)
        assertEquals(text.isIndex('m', 2), false)
    }

    @Test
    fun isANumber_isCorrect() {
        val textNumber = "44"
        val text = "44as"
        assertEquals(textNumber.isANumber(), true)
        assertEquals(text.isANumber(), false)
    }

    @Test
    fun doIfNotBlank_isCorrect() {
        val emptyText = ""
        val text = "Hola mundo"
        var resEmpty = false
        var resText = false
        emptyText.doIfNotBlank {
            resEmpty = true
        }
        text.doIfNotBlank {
            resText = true
        }
        assertEquals(resEmpty, false)
        assertEquals(resText, true)
    }

    @Test
    fun removeUrlParams_isCorrect() {
        val urlWithParams = "https://www.cualquiera.com?hola=2&mundo=3"
        val urlWithoutParams = "https://www.cualquiera.com"
        assertEquals(urlWithParams.removeUrlParams("hola"),
            "$urlWithoutParams?mundo=3")
        assertEquals(urlWithParams.removeUrlParams("mundo"),
            "$urlWithoutParams?hola=2")
        assertEquals(urlWithParams.removeUrlParams("hola", "mundo"),
            urlWithoutParams)
    }
}
