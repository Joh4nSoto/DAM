// =============================================================================
// EJEMPLO: Operadores aritméticos en Kotlin
// =============================================================================


fun main(){

    val sum = 5+3
    val rest = 5-3
    val mult = 5*3
    val div = 5/3
    val mod = 5%3 // módulo, el resto de la división
    // si mod es 0, significa que es divisible exacto
    // por ejemplo 10%2 = 0 significa que 10 es divisible por 2 ( es par)

    println("5 + 3 = $sum")
    println("5 - 3 = $rest")
    println("5 * 3 = $mult")
    println("5 / 3 = $div")
    println("5 % 3 = $mod")

}