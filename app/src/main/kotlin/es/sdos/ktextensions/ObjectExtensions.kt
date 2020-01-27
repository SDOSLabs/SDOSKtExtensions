package es.sdos.ktextensions

inline fun <T : Any, R> T?.whenNotNull(callback: (T) -> R): R? {
    return this?.let(callback)
}

inline fun <F, S, R> doIfNotNull(first: F?, second: S?, doCall: (F, S) -> R) {
    if (first != null &&
        second != null) {
        doCall(first, second)
    }
}

inline fun <F, S, T, R> doIfNotNull(first: F?, second: S?, third: T?, doCall: (F, S, T) -> R) {
    if (first != null &&
        second != null &&
        third != null) {
        doCall(first, second, third)
    }
}