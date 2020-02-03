package es.sdos.library.ktextensions

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import java.lang.NullPointerException
import java.util.logging.Filter
import java.util.logging.Level
import java.util.logging.Logger

class LoggerUnitTest {

    private data class TestObject(val title: String) {
        override fun toString(): String {
            return "$TAG [$title]"
        }
    }

    //region Test properties
    private val logTitle = "Esto es una prueba de log"
    private val logTest = "Prueba"
    private val logExceptionTitleText = "Ha ocurrido una excepción: "
    private val exceptionText = "¡Boom!"
    private val nullPointerExceptionTag = "NullPointerException"
    private var log: Logger? = null
    private var objectTest: TestObject? = null
    //endregion

    //region warning
    @Before
    fun setUpObjectTest() {
        log = Logger.getLogger(TAG)
        objectTest = TestObject(logTest)
    }

    @Test
    fun warning_logNullPointerException_shouldReturnTrue() {
        log?.filter = Filter {
            assertEquals(it.level == Level.WARNING, true)
            assertEquals(it.message.contains(logExceptionTitleText), true)
            assertEquals(it.thrown.TAG.contains(nullPointerExceptionTag), true)
            assertEquals(it.thrown.message?.contains(exceptionText), true)
            true
        }
        log?.warning(logExceptionTitleText, NullPointerException(exceptionText))
    }
    //endregion

    //region info
    @Test
    fun info_logObjectTest_shouldReturnLogTitleWithObjectToString() {
        log?.filter = Filter {
            assertEquals(it.level == Level.INFO, true)
            assertEquals(it.message.contains("$logTitle: ${objectTest.toString()}"), true)
            true
        }
        log?.info(logTitle, objectTest)
    }

    @Test
    fun info_logNullObject_shouldReturnTrue() {
        log?.filter = Filter {
            assertEquals(it.level == Level.INFO, true)
            assertEquals(it.message.contains("$logTitle: null"), true)
            true
        }
        log?.info(logTitle, null)
    }
    //endregion
}
