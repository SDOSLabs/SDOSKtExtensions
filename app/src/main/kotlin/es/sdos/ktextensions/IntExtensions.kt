package es.sdos.ktextensions

fun Int.toStringWithZero(): String =
    if (this < 10) {
        "0$this"
    } else {
        this.toString()
    }

fun Int?.toInt(defaultValue: Int): Int {
    return this ?: defaultValue
}