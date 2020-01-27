package es.sdos.library.ktextensions

fun Boolean?.isTrue(): Boolean = this == true

/**
 * Supports bitwise NOT to be false
 *
 * @return false -> 0L; true -> -1L, //- All bits to 1
 */
fun Boolean.toLong() = when (this) {
    false -> 0L
    true -> -1L
}

/**
 * Supports bitwise NOT to be false
 *
 * @return false -> 0.0; true -> -1.0, //- All bits to 1
 */
fun Boolean.toDouble() = when (this) {
    false -> 0.0
    true -> -1.0
}