package es.sdos.library.ktextensions

import java.util.concurrent.TimeUnit

/**
 * @return 0L -> "false" else "true"
 */
fun Long?.toBoolean() = when (this) {
    0L, null -> false
    else -> true
}

fun Long?.msToSeconds() =
    TimeUnit.MILLISECONDS.toSeconds(this ?: 0)

fun Long?.secondsToMs() =
    TimeUnit.SECONDS.toMillis(this ?: 0)

inline fun <T> Iterable<T>.sumByLong(selector: (T) -> Long): Long {
    var sum = 0L
    for (element in this) {
        sum += selector(element)
    }
    return sum
}

