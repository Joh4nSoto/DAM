fun dividir(a: Int, b: Int): Int {
    
    // se intenta ejecutar el try
    // si falla se ejecuta el catch
    // finally se ejecuta siempre
    return try {
        a / b
    } catch(e: Exception) {
        println("Error: ${e.message}")
        0 // Retorna 0 como valor por defecto cuando hay error
    } finally {
        println("Esto se ejecuta siempre")
    }
    
}

fun main() {
    
    // se divide 10/2
    // esto no da error, por lo cual no llega al catch
    val resultado1 = dividir(10, 2)
    println("Resultado 1: $resultado1")

    // se divide 10/2
    // esto da un error, por lo cual se ejecuta el catch
    val resultado2 = dividir(10, 0)
    println("Resultado 2: $resultado2")
    
}