package es.sdos.ktextensions

val Any.TAG: String
    get() {
        return javaClass.simpleName
    }