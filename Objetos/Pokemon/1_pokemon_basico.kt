// =============================================================================
// EJEMPLO: Crear un objeto Pokemon en Kotlin
// =============================================================================


// crearemos un objeto para representar un pokemon
class Pokemon(
    // aquí van las propiedades del objeto
	val nombre: String,
    val hp: Int,
    val atk: Int
){
    // aquí van los métodos del objeto
    fun info(){
        println("$nombre | HP:$hp ATK:$atk")
    }
}

fun main() {
    println("Comienza la batalla Pokemon")

    // primero instanciamos un objeto de la clase Pokemon
    val char = Pokemon("charmander", 100, 40) // este es un charmander con 100 de hp y 40 de atk

    // ahora podemos usar el método info para mostrar sus datos
    char.info()
}