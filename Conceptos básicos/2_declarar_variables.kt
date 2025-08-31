// =============================================================================
// EJEMPLO: Declarar variables en Kotlin ( algunas pueden ser mutables y otras no )
// =============================================================================


fun main(){
    
    val a: Int = 1 // Inmutable (esta variable no puede cambiar su valor)
    var b: Int = 2 // Mutable (esta variable puede cambiar su valor)

    // mostramos los valores iniciales
    println("a = $a y b = $b")

    b = 3 // cambiamos el valor de b
    println("a = $a y b = $b")
    // a no puede cambiar su valor, si lo intentamos el programa no funcionará
    
}