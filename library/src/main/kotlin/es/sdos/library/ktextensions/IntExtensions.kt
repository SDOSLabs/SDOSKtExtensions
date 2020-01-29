package es.sdos.library.ktextensions

private const val ZERO_STR = "0"

fun Int.toStringWithZero(minDigits: Int = 2): String =
    this.toString().padLeftByValue(minDigits, ZERO_STR)

fun Int?.toInt(defaultValue: Int): Int {
    return this ?: defaultValue
}