package es.sdos.ktextensions

const val SENCOND_IN_MILIS = 1000
/**
 * @return 0L -> "false" else "true"
 */
fun Long?.toBoolean() = when (this) {
    0L -> false
    null -> false
    else -> true
}

fun Long?.msToSeconds(): Long {
    return this?.div(SENCOND_IN_MILIS) ?: 0
}

fun Long?.secondsToMs(): Long {
    return this?.times(SENCOND_IN_MILIS) ?: 0
}

inline fun <T> Iterable<T>.sumByLong(selector: (T) -> Long): Long {
    var sum = 0L
    for (element in this) {
        sum += selector(element)
    }
    return sum
}

