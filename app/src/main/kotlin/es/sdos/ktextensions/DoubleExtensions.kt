package es.sdos.ktextensions

/**
 * @return 0.0 -> false; else true
 */
fun Double.toBoolean() = when (this) {
    0.0 -> false
    else -> true
}