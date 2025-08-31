fun main(){

    var a: String? = "Hola" // declaramos una variable que puede ser nula con el "?"
    a = null // esta variable puede ser nula porque tiene el "?"
    println("a = $a")

    val largo = a?.length // si a es nulo, largo será 0, si no, será la longitud de a
    println("El largo de a es $largo")

}