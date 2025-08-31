
// Definimos la clase Vehiculo con sus propiedades y métodos
// La clase es marcada como open para permitir herencia 
open class Vehiculo(val marca: String, val modelo: String, var anio: Int) {
    open fun info() {
        println("$marca $modelo | Año: $anio")
    }
}

// La clase Auto hereda de Vehiculo y añade una propiedad y métodos propios
// La clase Auto también sobrescribe el método info para incluir la cantidad de puertas
class Auto(marca: String, modelo: String, anio: Int, val cantidadPuertas: Int): Vehiculo(marca, modelo, anio){
    // Sobrescribimos el método info para incluir la cantidad de puertas
    override fun info() {
        println("$marca $modelo | Año: $anio | Puertas: $cantidadPuertas")
    }
}

// La clase Moto hereda de Vehiculo pero no añade nuevas propiedades ni métodos
class Moto(marca: String, modelo: String, anio: Int): Vehiculo(marca, modelo, anio){
    // sin nada nuevo por ahora
}

fun main(){

    // creamos un objeto de la clase Auto
    val miAuto = Auto("Toyota", "Corolla", 2020, 4)
    // el método info es el de Auto, no el de Vehiculo
    // porque Auto sobrescribe info()
    // esto es polimorfismo: el mismo método (info) se comporta diferente según el objeto que lo llama
    miAuto.info()

    println() // línea en blanco para separar

    // creamos un objeto de la clase Moto   
    val miMoto = Moto("Honda", "CBR600RR", 2019)
    miMoto.info()

}
