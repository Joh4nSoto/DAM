fun main(){

    val numeros = listOf(1,2,3,4,5)
    println("numeros (colección original): $numeros")

    // en vez de usar un rango, iteramos sobre la colección
    for(numero in numeros){
        // en este caso, número es el elemento de la colección ( vamos a ir recorriendo todos )
        println("número: $numero")
    }

    val datos = mapOf("nombre" to "Alvaro", "celular" to "+56912345678", "direccion" to "Calle Falsa 123")
    println("datos (colección original): $datos")
    // iteramos sobre el map y mostramos su clave ( key ) y su valor ( value )
    datos.forEach{ (clave, valor) ->
        println("$clave : $valor")
    }

}