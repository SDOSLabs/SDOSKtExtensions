package es.sdos.library.ktextensions

val Any.TAG: String
    get() {
        return javaClass.simpleName
    }