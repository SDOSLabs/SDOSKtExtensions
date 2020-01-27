package es.sdos.ktextensions

fun Boolean?.isTrue(): Boolean = this == true

/**
 * @return false -> 0L; true -> -1L, //- All bits to 1, supports bitwise not to be false
 */
fun Boolean.toLong() = when (this) {
    false -> 0L
    true -> -1L
}

/**
 * @return false -> 0.0; true -> -1.0, //- All bits to 1, supports bitwise not to be false
 */
fun Boolean.toDouble() = when (this) {
    false -> 0.0
    true -> -1.0
}