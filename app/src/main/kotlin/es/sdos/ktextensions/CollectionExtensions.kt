package es.sdos.ktextensions

val Collection<*>.half: Int get() = size / 2

fun <T> Collection<T>?.isBlank(): Boolean = this == null || isEmpty()
fun <T> Collection<T?>.anyNull(): Boolean = any { it == null }
fun <T> Collection<T?>.allNull(): Boolean = all { it == null }

fun <T> Collection<T?>.countNulls(): Int = count { it == null }
fun <T> Collection<T?>.countNonNulls(): Int = size - countNulls()

fun <T : Any> Iterable<T?>.trimNulls(): List<T> = filterNotNull()
fun <T : Any> Iterable<T?>.trimNullsToMutableList(): MutableList<T> = filterNotNullTo(mutableListOf())
fun Iterable<String?>.trim(): List<String> = trimNulls().filterNot { it.isBlank() }
fun Iterable<String?>.trimToMutableList(): MutableList<String> = trimNulls().filterNotTo(mutableListOf()) { it.isBlank() }

fun <T> Collection<T>.split(index: Int): Pair<List<T>, List<T>> = take(index) to drop(index)
fun <T> Collection<T>.split(): Pair<List<T>, List<T>> = split(half)

fun <K, V> Map<K, V>?.isNotEmpty() = this != null && !isEmpty()