// =============================================================================
// EJEMPLO: Declarar una función de orden superior en Kotlin 
// ( funciones que reciben otras funciones como parámetros )
// =============================================================================

// operación(a,b,f()x) es una función que se comportará dependiendo de la función que se le pase como argumento
// si le pasamos una suma, se comportará como una suma, si le pasamos una resta, se comportará como una resta
fun operacion(a: Int, b: Int, operacion: (Int, Int) -> Int): Int {
    return operacion(a, b)
}

// función para sumar dos números
fun suma(a: Int, b: Int): Int {
    return a + b
}

// función para restar dos números
fun resta(a: Int, b: Int): Int {
    return a - b
}

fun main() {
    // pasamos la función suma y resta como argumentos a la función operación
    val resultadoSuma = operacion(5, 3, ::suma)
    val resultadoResta = operacion(5, 3, ::resta)

    println("Resultado de la suma: $resultadoSuma")
    println("Resultado de la resta: $resultadoResta")
    // esta es la base para entender polimorfismo
}