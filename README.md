# SDOS KtExtensions 

Librería de extensiones puras de Kotlin.

## 1.- Dependencia

```xml
implementation 'es.sdos.android:sdosktextensions:1.0.0'
```

## 2.- Métodos
### Any
 - **TAG**.  Representa el nombre de la clase, es útil para pintar logs y no utilizar el nombre de la clase a fuego en un String.

```kotlin
CustomLog.TAG //- "CustomLog"
String.TAG //- "String"
```
### Float
 - **round**. Redondea un float al número de decimales que se le puede pasar por parámetros. Si no recibe nada, por defecto se toma a 2. El redondeo con respecto al último decimal a redondear es:
	 - Está entre 0 y 5 --> No se incrementa el decimal siguiente.
	 - Está entre 6 y 9 --> Se incrementa en 1 el decimal siguiente.

```kotlin
100.54432F.round(2) //- 100.54F
100.54432F.round() //- 100.54F
100.54436F.round(4) //- 100.5444F
```
 - **toBoolean**. Convierte un Float en Boolean. Cualquier valor distinto de cero se toma como true, si no, como false.

```kotlin
100F.toBoolean() //- true
0F.toBoolean() //- false
```
### Int
 - **toStringWithZero**. Genera un String rellenado con ceros por la izquierda hasta tener el mismo tamaño que el valor pasado por parámetro.

```kotlin
0.toStringWithZero() //- "00"
10.toStringWithZero(4) //- "0010"
1000.toStringWithZero(2) //- "1000"
```
 - **toInt**.

```kotlin
val intNull: Int? = null
val number = 2

intNull.toInt(1) //- 1
number.toInt(1) //- 2
```
### String
 - **htmlToText()**. Elimina todo el código html.

```kotlin
"<b>Hola</b>".htmlToText().trim() //- "Hola"
```
 - **head()**. Obtiene el primer carácter.

```kotlin
"Hola".head() //- "H"
```
 - **tag(tag: String)**. Añade un tag HTML pasado por parámetro.

```kotlin
"Helo".tag("b") //- "<b>Hola</b>"
```
 - **toCapitalizeWords()**. Establece en mayúscula la primera letra de cada palabra.

```kotlin
"hola mundo".toCapitalizeWords() //- "Hola Mundo"
```
 - **toSentenceCase()**. Establece en mayúscula sólo la primera letra de una frase.

```kotlin
"hola mundo".toSentenceCase() //- "Hola mundo"
```
 - **toUpperCaseSafe()**. Establece todo el String en mayúscula, en caso de ser nulo, retorna un String vacío.

```kotlin
val nullObject: String? = null

nullObject.toUpperCaseSafe() //- ""
"hola mundo".toUpperCaseSafe() //- "HOLA MUNDO"
```
 - **isNullOrHasNullValue()**. Indica si un String es nulo o es igual a la palabra "null".

```kotlin
val nullObject: String? = null

nullObject.isNullOrHasNullValue() //- true
"hola mundo".isNullOrHasNullValue() //- false
"null".isNullOrHasNullValue() //- true
```
 - **takeWithDots(num: Int)**. Establece puntos suspensivos desde el índice que se le indica por parámetro.

```kotlin
"hola mundo".takeWithDots(4) //- "hola..."
```
 - **countOccurrences(sub: String)**. Retorna el número de veces que aparece el String pasado por parámetro.

```kotlin
val helloParam = "hola"
val worldParam = "mundo"
val text = "$helloParam $worldParam $helloParam $worldParam $helloParam $worldParam $worldParam $worldParam$worldParam"

text.countOccurrences(worldParam) // 6
```
 - **isTrue()**. Indica si un String es verdadero ("1" ó "true") o no.

```kotlin
"true".isTrue() //- true
"1".isTrue() //- true
"0".isTrue() //- false
```
 - **isIndex(character: Char, index: Int)**. Indica si el índice pasado por parámetro es igual al carácter también pasado.

```kotlin
"hola mundo".isIndex('l', 2) //- true
"hola mundo".isIndex('m', 2) //- false
```
 - **isANumber()**. Indica si un String es un número.

```kotlin
"44".isANumber() //- true
"44as".isANumber() //- false
```
 - **doIfNotBlank(whatToDo: (String) -> R)**. Ejecuta la lambda pasada por parámetros si el String no es vacío.

```kotlin
var resEmpty = false  

"".doIfNotBlank {  
  resEmpty = true  
}
//- resEmpty = false

------ * ------

var resEmpty = false  

"test".doIfNotBlank {  
  resEmpty = true  
}
//- resEmpty = true
```
 - **removeUrlParams(vararg params: String)**. Elimina parámetros de una URL.

```kotlin
val urlWithAllParams = "https://www.cualquiera.com?hola=2&mundo=3"  

urlWithAllParams.removeUrlParams(helloParam) //- "https://www.cualquiera.com?mundo=3"  
urlWithAllParams.removeUrlParams(worldParam) //- "https://www.cualquiera.com?hola=2"
urlWithAllParams.removeUrlParams(helloParam, worldParam) //- "https://www.cualquiera.com"
```

 - **padLeftByValue(length: Int, valueToPad: String)**. Añade al inicio del String el valor de valueToPad hasta completar el tamaño indicado por length.

```kotlin
"10".padLeftByValue(4, "**") //- "**10"
"10".padLeftByValue(2, "**") //- "10"
```
### Double
 - **toBoolean()**. Transforma un Double a Boolean. 0.0 -> false, otra cosa -> true.

```kotlin
200.0.toBoolean() //- true
0.0.toBoolean() //- false
```
### Long
 - **toBoolean()**. Transforma un Long a Boolean. 0L ó null -> false, otra cosa -> true.

```kotlin
200L.toBoolean() //- true
0L.toBoolean() //- false
```
 - **msToSeconds()**. Transforma los milisegundos en segundos.

```kotlin
2000L.msToSeconds() //- 2L
```
 - **secondsToMs()**. Transforma los segundos en milisegundos.

```kotlin
2L.secondsToMs() //- 2000L
```
 - **secondsToMs()**. Transforma los segundos en milisegundos.

```kotlin
2L.secondsToMs() //- 2000L
```
### Collections
 - **sumByLong(selector: (T) -> Long)**. Suma todos los valores dada una lambda.

```kotlin
val itemsList = mutableListOf<TestObject>()  
var result = 0L  
val multiplier = 10

for (index in 0..10) {  
    result += index * multiplier  
  itemsList.add(TestObject("Item $index", index.toLong()))  
}  

//- result = 550L
```
 - **anyNull()**.

```kotlin
val listWithoutNulls = listOf("1", "2", "3")
val listWithNullsAndNotNullValues = listOf("1", "2", null)

listWithNullsAndNotNullValues.anyNull() //- true
listWithoutNulls.anyNull() //- false
```
 - **allNull()**.

```kotlin
val listWithAllNulls = listOf(null, null, null)
val listWithNullsAndNotNullValues = listOf("1", "2", null)

listWithAllNulls.allNull() //- true
listWithNullsAndNotNullValues.allNull() //- false

```
 - **countNulls()**.

```kotlin
val listWithAllNulls = listOf(null, null, null)
val listWithoutNulls = listOf("1", "2", "3")
val listWithNullsAndNotNullValues = listOf("1", "2", null)

listWithAllNulls.countNulls() //- 3
listWithNullsAndNotNullValues.countNulls() //- 1
listWithoutNulls.countNulls() //- 0
```
 - **countNonNulls()**.

```kotlin
val listWithAllNulls = listOf(null, null, null)
val listWithNullsAndNotNullValues = listOf("1", "2", null)

listWithAllNulls.countNonNulls() //- 0
listWithNullsAndNotNullValues.countNonNulls() //- 2
```
 - **trimNulls()**.

```kotlin
val listWithAllNulls = listOf(null, null, null)
val listWithNullsAndNotNullValues = listOf("1", "2", null)

listWithAllNulls.trimNulls() //- 0
listWithNullsAndNotNullValues.trimNulls() //- 2
```
 - **trimNullsToMutableList()**.

```kotlin
val mutableEmptyList = listOf<String>().trimNullsToMutableList()  
mutableEmptyList.add("2")
```
 - **trim()**.

```kotlin
val listWithBlankValues = listOf("", "", "1", " ")
val listWithoutNulls = listOf("1", "2", "3")

listWithBlankValues.trim() //- 1
listWithoutNulls.trim() //- 3
```
 - **split()**.

```kotlin
val listPairSize = listOf("1", "2", "3", "4")  
val listWithOddSize = listOf("1", "2", "3", "4", "5")

listPairSize.split(3) //- Pair(listOf("1", "2", "3"), listOf("4"))
listWithOddSize.split() //- Pair(listOf("1", "2"), listOf("3", "4", "5"))
```
 - **isNotEmpty()**.

```kotlin
val mapWithValues = mapOf<String, Any>("1" to 1, "2" to 2, "3" to 3)
val emptyMap = mapOf<String, String>()
val nullMap: Map<String, String>? = null

mapWithValues.isNotEmpty() //- true
emptyMap.isNotEmpty() //- false
nullMap.isNotEmpty() //- false
```
### Logger
 - **warning(text: String, exception: Exception)**.

```kotlin
val log = Logger.getLogger(TAG)
log?.warning(logExceptionTitleText, NullPointerException(exceptionText))
```
 - **info(text: String, objectToLog: Any?)**.

```kotlin
val log = Logger.getLogger(TAG)
log?.info(logTitle, objectTest)
```
### Object
 - **whenNotNull(callback: (T) -> R)**.

```kotlin
val resultWithoutTypeTransformation = firstNumber.whenNotNull {  
 it * multiplier  
}
```
 - **doIfNotNull(first: F?, second: S?, doCall: (F, S) -> R)**.

```kotlin
var firstOp = defaultValue  
doIfNotNull(firstNumber, secondNumber) { first, second ->  
  firstOp = first * second  
}
```
 - **doIfNotNull(first: F?, second: S?, third: T?, doCall: (F, S, T) -> R)**.

```kotlin
var firstOp = defaultValue  
doIfNotNull(firstNumber, secondNumber, thirdNumber) { first, second, third ->  
  firstOp = first * second * third  
}
```
