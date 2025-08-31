// =============================================================================
// EJEMPLO: Herencia y Polimorfismo en Kotlin
// =============================================================================

// Definimos la clase Vehiculo con sus propiedades y métodos
// La clase es marcada como open para permitir herencia 
open class Vehiculo(val marca: String, val modelo: String, var anio: Int) {
    open fun info() {
        println("$marca $modelo | Año: $anio")
    }
    fun tocarBocina() {
        println("¡$marca $modelo toca la bocina! Beep Beep!")
    }
    
}

// La clase Auto hereda de Vehiculo y añade una propiedad y métodos propios
// La clase Auto también sobrescribe el método info para incluir la cantidad de puertas
// la cantidad de puertas es una propiedad nueva propia de Auto, no de Vehiculo
class Auto(marca: String, modelo: String, anio: Int, val cantidadPuertas: Int): Vehiculo(marca, modelo, anio){
    fun abrirMaletero() {
        println("Abriendo el maletero del $marca $modelo")
    }
    
    // Sobrescribimos el método info para incluir la cantidad de puertas
    // esto es polimorfismo: el mismo método (info) se comporta diferente según el objeto que lo llama
    override fun info() {
        println("$marca $modelo | Año: $anio | Puertas: $cantidadPuertas")
    }
}

// La clase Moto hereda de Vehiculo y añade un método propio
class Moto(marca: String, modelo: String, anio: Int): Vehiculo(marca, modelo, anio){
    fun hacerCaballito() {
        println("¡La $marca $modelo está haciendo un caballito!")
    }
}

fun main(){

    // creamos un objeto de la clase Auto
    val miAuto = Auto("Toyota", "Corolla", 2020, 4)
    miAuto.info()
    miAuto.tocarBocina()
    miAuto.abrirMaletero()

    println() // línea en blanco para separar

    // creamos un objeto de la clase Moto   
    val miMoto = Moto("Honda", "CBR600RR", 2019)
    miMoto.info()
    miMoto.tocarBocina()
    miMoto.hacerCaballito()

}
