// =============================================================================
// EJEMPLO: Crear un objeto básico en Kotlin
// =============================================================================

/*
los objetos tienen propiedades (características) y métodos (acciones o comportamientos)
un nuevo objeto se define así:

class NombreDelObjeto (propiedad1: Tipo, propiedad2: Tipo, ...) {

    fun metodo1() {
        // código del método 1
    }

    fun metodo2() {
        // código del método 2
    }
}
*/

// definimos la clase Vehiculo con sus propiedades y métodos
class Vehiculo(val marca: String, val modelo: String, var anio: Int) {

    // el método info muestra la información del vehículo
    fun info() {
        println("$marca $modelo | Año: $anio")
    }
    //el método tocarBocina simula tocar la bocina del vehículo
    fun tocarBocina() {
        println("¡$marca $modelo toca la bocina! Beep Beep!")
    }

}

fun main(){

    // creamos un objeto de la clase Vehiculo
    val miVehiculo = Vehiculo("Toyota", "Corolla", 2020)

    // mostramos la información del vehículo y tocamos la bocina
    miVehiculo.info()
    miVehiculo.tocarBocina()

}
