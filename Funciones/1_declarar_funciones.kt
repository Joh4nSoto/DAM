// =============================================================================
// EJEMPLO: Declarar funciones en Kotlin ( bloques de código reutilizables )
// =============================================================================

fun main(){
   val a = 10
   val b = 5

   println("Suma: ${sumar(a, b)}")
   println("Resta: ${restar(a, b)}")
   println("Multiplicación: ${multiplicar(a, b)}")
   println("División: ${dividir(a, b)}")
}

fun sumar(a: Int, b: Int): Int {
    return a + b
}
fun restar(a: Int, b: Int): Int {
    return a - b
}
fun multiplicar(a: Int, b: Int): Int {
    return a * b
}
fun dividir(a: Int, b: Int): Int {
    // no se puede dividir por cero
    if (b == 0) {
        println("❌Error: División por cero")
        return 0 // o lanzar una excepción
    }
    else {
        return a / b
    }
}