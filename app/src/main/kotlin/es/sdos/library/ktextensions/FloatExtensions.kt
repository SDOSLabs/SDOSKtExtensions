package es.sdos.library.ktextensions

import kotlin.math.pow
import kotlin.math.roundToInt

fun Float.round(numDecimals: Int = 2): Float {
    val powValue = 10.0.pow(numDecimals)
    return if (powValue > Float.MAX_VALUE ||
            Float.MAX_VALUE / powValue < this) {
        this
    } else {
        ((this * powValue).roundToInt() / powValue).toFloat()
    }
}

/**
 * @return 0F -> "false", else "true"
 */
fun Float.toBoolean() = when (this) {
    0F -> false
    else -> true
}