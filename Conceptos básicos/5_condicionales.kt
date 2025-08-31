// =============================================================================
// EJEMPLO: Condicionales en Kotlin ( si se cumple una condición, hacer algo )
// =============================================================================


fun main(){

    val a = 5
    val b = 10

    // la condición va entre paréntesis
    if (a > b) {
        // si se cumple la condición se ejecuta este bloque
        println("a es mayor que b")
    } else if (a < b) {
        println("a es menor que b")
    } else {
        println("a es igual a b")
    }

}