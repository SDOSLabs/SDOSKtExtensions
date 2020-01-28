package es.sdos.library.ktextensions

import java.lang.Exception
import java.util.logging.Level
import java.util.logging.Logger

fun Logger.warning(text: String, exception: Exception) {
    this.log(Level.WARNING, text, exception)
}

fun Logger.info(text: String, objectToLog: Any) {
    this.info("$text: $objectToLog")
}