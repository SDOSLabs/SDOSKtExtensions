package es.sdos.ktextensions

private const val EMPTY_STRING = ""
private const val SPACE_STRING = " "
private const val NULL = "null"
private const val VALUE_TRUE_NUMBER = "1"
private const val VALUE_TRUE_BOOLEAN = "true"

fun String.htmlToText() =
    if (this.isNotEmpty()) this.replace("<(.*?)>".toRegex(), SPACE_STRING)
        .replace("<(.*?)\n".toRegex(), SPACE_STRING)
        .replaceFirst("(.*?)>".toRegex(), SPACE_STRING)
        .replace("&nbsp;".toRegex(), SPACE_STRING)
        .replace("&amp;".toRegex(), SPACE_STRING) else EMPTY_STRING

fun String.head() = if (length > 1) {
        this.substring(0, 1)
    } else {
        EMPTY_STRING
    }

fun String.tag(tag: String) = "<$tag>$this</$tag>"

fun String?.toCapitalizeWords() =
    this?.split(SPACE_STRING)?.joinToString(SPACE_STRING) { it.capitalize() } ?: EMPTY_STRING

fun String?.toSentenceCase() =
    this?.toLowerCase()?.capitalize() ?: EMPTY_STRING

fun String?.toUpperCaseSafe() =
    this?.toUpperCase() ?: EMPTY_STRING

fun String?.isNullOrHasNullValue() =
    this == null ||
            NULL.equals(this, true)

fun String?.takeWithDots(num: Int): String? {
    var result = this
    if (this != null &&
            this.length > num) {
        result = "${this.substring(0, num)}..."
    }
    return result
}

fun String.countOccurrences(sub: String): Int = split(sub).size - 1

fun String?.isTrue() =
    VALUE_TRUE_NUMBER == this ||
        VALUE_TRUE_BOOLEAN.equals(this, true)

fun String?.isIndex(string: String, index: Int) =
    this?.indexOf(string) == index

fun String?.isIndex(character: Char, index: Int) =
    isIndex(character.toString(), index)

fun String?.isANumber() =
    try {
        if (this != null) {
            toInt()
            true

        } else {
            false
        }
    } catch (e: NumberFormatException) {
        false
    }

fun <R> String?.doIfNotBlank(whatToDo: (String) -> R) {
    if (this?.isNotBlank() == true) {
        whatToDo(this)
    }
}

tailrec fun String.removeUrlParams(params: List<String>): String =
    if (params.isNotEmpty()) {
        val whenParamIsTheFirstOne = Regex("\\?${params[0]}=(.[^&]*&)")
        val whenParamIsNotTheFirstOne = Regex("&${params[0]}=(.[^&]*)")
        val whenParamIsTheOnlyParam = Regex("\\?${params[0]}=(.[^&]*)$")

        replace(whenParamIsTheFirstOne, "?")
            .replace(whenParamIsNotTheFirstOne, "")
            .replace(whenParamIsTheOnlyParam, "")
            .removeUrlParams(params.slice(1 until params.size))

    } else {
        this
    }

fun String.removeUrlParams(vararg params: String): String =
    this.removeUrlParams(params.toList())
