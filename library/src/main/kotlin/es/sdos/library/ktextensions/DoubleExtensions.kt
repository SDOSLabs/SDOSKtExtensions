package es.sdos.library.ktextensions

/**
 * @return 0.0 -> false; else true
 */
fun Double.toBoolean() = when (this) {
    0.0 -> false
    else -> true
}