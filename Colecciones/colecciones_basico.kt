fun main(){

    // definimos colecciones inmutables
    val numeros = listOf(1,2,3,4,5)
    var conjunto = setOf(1,2,3,4,5)
    val mapa = mapOf(1 to "uno", 2 to "dos", 3 to "tres")
    println(numeros)
    println(conjunto)
    println(mapa)

    // definimos colecciones mutables
    val numerosMutables = mutableListOf(1,2,3,4,5)
    var conjuntoMutable = mutableSetOf(1,2,3,4,5)
    val mapaMutable = mutableMapOf(1 to "uno", 2 to "dos", 3 to "tres")
    println(numerosMutables)
    println(conjuntoMutable)
    println(mapaMutable)

}