fun main(){

    val numeros = listOf(1,2,3,4,5)
    println("numeros (colección original): $numeros")

    // filter filtra mediante una condición
    // la condición va entre paréntesis { }
    // it%2 == 0 es para filtrar por elementos pares
    val numerosPares = numeros.filter { it % 2 == 0 }
    println("numeros Pares: $numerosPares")
    
    // it%2 != 0 es para filtrar por elementos impares
    val numerosImpares = numeros.filter { it % 2 != 0 }
    println("numeros Impares: $numerosImpares")

    // map recorre la colección y modifica el valor de cada elemento
    // en este caso los duplica
    val doble = numeros.map { it * 2 }
    println("doble: $doble")

    // suma los elementos ( de uno en uno )
    val suma = numeros.reduce { acc, i -> acc + i }
    println("suma: $suma")

    // otra forma de sumar los elementos
    val sumatoria = numeros.sum()
    println("sumatoria: $sumatoria")

    // find buscará el primer elemento que cumpla con una condición
    val mayor = numeros.find { it > 3 }
    println("primer elemento mayor a 3: $mayor")

    // first busca el primer elemento
    val pimerElemento = numeros.first()
    println("primer Elemento: $pimerElemento")

    // last busca el último elemento
    val ultimoElemento = numeros.last()
    println("último Elemento: $ultimoElemento")

}