package es.sdos.library.ktextensions

import org.junit.Test

import org.junit.Assert.*

class StringUnitTest {

    //region Test properties
    private val nullText = "null"
    private val helloText = "Hola"
    private val firstCharFromHello = "H"
    private val bTag = "b"
    private val helloWithBTagText = "<b>$helloText</b>"
    private val helloWithDotsText = "hola..."
    private val helloWorldNotCapitalizedText = "hola mundo"
    private val helloWorldEachWordCapitalizedText = "Hola Mundo"
    private val helloWorldOnlyLastWordCapitalizedText = "hola Mundo"
    private val helloWorldSentenceCapitalizedText = "Hola mundo"
    private val helloWorldUpperCaseText = "HOLA MUNDO"
    private val booleanTrueText = "true"
    private val booleanNumberTrueText = "1"
    private val booleanNumberFalseText = "0"
    private val lCharText = 'l'
    private val indexToLChar = 2
    private val mCharText = 'm'
    private val onlyNumberText = "44"
    private val numberWithCharsText = "44as"
    private val emptyText = ""
    private val urlWithAllParams = "https://www.cualquiera.com?hola=2&mundo=3"
    private val urlOnlyWithHelloParam = "https://www.cualquiera.com?hola=2"
    private val urlOnlyWithWorldParam = "https://www.cualquiera.com?mundo=3"
    private val urlWithoutParams = "https://www.cualquiera.com"
    private val helloParam = "hola"
    private val worldParam = "mundo"
    private val nullObject: String? = null
    //endregion

    //region htmlToText
    @Test
    fun htmlToText_textWithTags_shouldReturnTextWithoutTags() {
        assertEquals(helloWithBTagText.htmlToText().trim(), helloText)
    }
    //endregion

    //region head
    @Test
    fun head_helloText_shouldReturnFirstCharFromHello() {
        assertEquals(helloText.head(), firstCharFromHello)
    }
    //endregion

    //region tag
    @Test
    fun tag_addTagToText_shouldReturnTextWithBTag() {
        assertEquals(helloText.tag(bTag), helloWithBTagText)
    }
    //endregion

    //region toCapitalizeWords
    @Test
    fun toCapitalizeWords_notCapitalizedText_shouldReturnEachWordCapitalized() {
        assertEquals(helloWorldNotCapitalizedText.toCapitalizeWords(), helloWorldEachWordCapitalizedText)
    }

    @Test
    fun toCapitalizeWords_notCapitalizedText_notShouldReturnOnlyLastWordCapitalized() {
        assertNotEquals(helloWorldNotCapitalizedText.toCapitalizeWords(), helloWorldOnlyLastWordCapitalizedText)
    }
    //endregion

    //region toSentenceCase
    @Test
    fun toSentenceCase_notCapitalizedText_shouldReturnSentenceCapitalized() {
        assertEquals(helloWorldNotCapitalizedText.toSentenceCase(), helloWorldSentenceCapitalizedText)
    }

    @Test
    fun toSentenceCase_notCapitalizedText_notShouldReturnEachWordCapitalized() {
        assertNotEquals(helloWorldNotCapitalizedText.toSentenceCase(), helloWorldEachWordCapitalizedText)
    }
    //endregion

    //region toUpperCaseSafe
    @Test
    fun toUpperCaseSafe_nullObject_shouldReturnEmptyText() {
        assertEquals(nullObject.toUpperCaseSafe(), emptyText)
    }

    @Test
    fun toUpperCaseSafe_notCapitalizedText_shouldReturnUpperCaseText() {
        assertEquals(helloWorldNotCapitalizedText.toUpperCaseSafe(), helloWorldUpperCaseText)
    }
    //endregion

    //region isNullOrHasNullValue
    @Test
    fun isNullOrHasNullValue_nullObject_shouldReturnTrue() {
        assertEquals(nullObject.isNullOrHasNullValue(), true)
    }

    @Test
    fun isNullOrHasNullValue_notNullObjectOrString_shouldReturnFalse() {
        assertEquals(helloWorldNotCapitalizedText.isNullOrHasNullValue(), false)
    }

    @Test
    fun isNullOrHasNullValue_nullText_shouldReturnTrue() {
        assertEquals(nullText.isNullOrHasNullValue(), true)
    }
    //endregion

    //region takeWithDots
    @Test
    fun takeWithDots_notCapitalizedText_shouldReturnTextWithDots() {
        assertEquals(helloWorldNotCapitalizedText.takeWithDots(4), helloWithDotsText)
    }
    //endregion

    //region countOccurrences
    @Test
    fun countOccurrences_textWithSixOccurrencesOfHelloTxt_shouldReturnSix() {
        val text = "$helloParam $worldParam $helloParam $worldParam $helloParam $worldParam $worldParam $worldParam$worldParam"
        assertEquals(text.countOccurrences(worldParam), 6)
    }
    //endregion

    //region isTrue
    @Test
    fun isTrue_booleanTrueText_shouldReturnTrue() {
        assertEquals(booleanTrueText.isTrue(), true)
    }

    @Test
    fun isTrue_booleanNumberTrueText_shouldReturnTrue() {
        assertEquals(booleanNumberTrueText.isTrue(), true)
    }

    @Test
    fun isTrue_booleanNumberFalseText_shouldReturnFalse() {
        assertEquals(booleanNumberFalseText.isTrue(), false)
    }
    //endregion

    //region isIndex
    @Test
    fun isIndex_lChartTextIsEqualCorrectIndex_shouldReturnTrue() {
        assertEquals(helloWorldNotCapitalizedText.isIndex(lCharText, indexToLChar), true)
    }

    @Test
    fun isIndex_mChartTextIsEqualIncorrectIndex_shouldReturnFalse() {
        assertEquals(helloWorldNotCapitalizedText.isIndex(mCharText, indexToLChar), false)
    }
    //endregion

    //region isANumber
    @Test
    fun isANumber_onlyNumberText_shouldReturnTrue() {
        assertEquals(onlyNumberText.isANumber(), true)
    }

    @Test
    fun isANumber_numberWithCharsText_shouldReturnFalse() {
        assertEquals(numberWithCharsText.isANumber(), false)
    }
    //endregion

    //region doIfNotBlank
    @Test
    fun doIfNotBlank_emptyText_shouldReturnValueNotModified() {
        var resEmpty = false
        emptyText.doIfNotBlank {
            resEmpty = true
        }
        assertEquals(resEmpty, false)
    }

    @Test
    fun doIfNotBlank_notEmptyText_shouldReturnValueModified() {
        var resText = false
        helloWorldNotCapitalizedText.doIfNotBlank {
            resText = true
        }
        assertEquals(resText, true)
    }
    //endregion

    //region removeUrlParams
    @Test
    fun removeUrlParams_removeOnlyHelloParam_shouldReturnUrlWithWorldParam() {
        assertEquals(urlWithAllParams.removeUrlParams(helloParam), urlOnlyWithWorldParam)
    }

    @Test
    fun removeUrlParams_removeOnlyWorldParam_shouldReturnUrlWithHelloParam() {
        assertEquals(urlWithAllParams.removeUrlParams(worldParam), urlOnlyWithHelloParam)
    }

    @Test
    fun removeUrlParams_removeAllParams_shouldReturnUrlWithoutParams() {
        assertEquals(urlWithAllParams.removeUrlParams(helloParam, worldParam), urlWithoutParams)
    }
    //endregion
}
