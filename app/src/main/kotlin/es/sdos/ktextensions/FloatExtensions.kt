package es.sdos.ktextensions

import kotlin.math.roundToInt

fun Float.round() = ((this * 100.0).roundToInt() / 100.0).toFloat()

/**
 * @return 0F -> "false", else "true"
 */
fun Float.toBoolean() = when (this) {
    0F -> false
    else -> true
}