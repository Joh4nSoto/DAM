// =============================================================================
// EJEMPLO: CLASES DE DATOS (Data Classes)
// =============================================================================
// Las data classes en Kotlin generan automáticamente:
// - toString(): representación en string del objeto
// - equals(): comparación por valor (no por referencia)
// - hashCode(): código hash para usar en colecciones
// - copy(): crear copias con modificaciones

data class Persona(
    val id: Int,
    val nombre: String,
    val edad: Int,
    val email: String
)

data class Producto(
    val codigo: String,
    val nombre: String,
    val precio: Double,
    val disponible: Boolean = true
)

fun main() {
    println("📋 === CLASES DE DATOS (DATA CLASSES) ===\n")
    
    // Creamos objetos
    val persona1 = Persona(1, "Carlos López", 25, "carlos@email.com")
    val persona2 = Persona(1, "Carlos López", 25, "carlos@email.com")
    val persona3 = Persona(2, "Ana Martín", 30, "ana@email.com")
    
    // -------------------------------------------------------------------------
    // DEMOSTRACIÓN DE toString() automático
    // -------------------------------------------------------------------------
    println("🔤 toString() automático:")
    println("Persona 1: $persona1")
    println("Persona 2: $persona2")
    println("Persona 3: $persona3")
    println()
    
    // -------------------------------------------------------------------------
    // DEMOSTRACIÓN DE equals() automático
    // -------------------------------------------------------------------------
    println("⚖️ equals() automático (compara por VALOR, no por referencia):")
    println("¿persona1 == persona2? ${persona1 == persona2}") // true (mismo contenido)
    println("¿persona1 == persona3? ${persona1 == persona3}") // false (diferente contenido)
    println("¿persona1 === persona2? ${persona1 === persona2}") // false (referencias diferentes)
    println()
    
    // -------------------------------------------------------------------------
    // DEMOSTRACIÓN DE hashCode() automático
    // -------------------------------------------------------------------------
    println("🔢 hashCode() automático:")
    println("HashCode persona1: ${persona1.hashCode()}")
    println("HashCode persona2: ${persona2.hashCode()}") // Mismo que persona1
    println("HashCode persona3: ${persona3.hashCode()}") // Diferente
    println()
    
    // -------------------------------------------------------------------------
    // DEMOSTRACIÓN DE copy() automático
    // -------------------------------------------------------------------------
    println("📋 copy() automático:")
    val personaModificada = persona1.copy(edad = 26, email = "carlos.nuevo@email.com")
    println("Original: $persona1")
    println("Copia modificada: $personaModificada")
    println()
    
    // -------------------------------------------------------------------------
    // USO EN COLECCIONES
    // -------------------------------------------------------------------------
    println("📦 Uso en colecciones:")
    val personas = listOf(persona1, persona2, persona3, personaModificada)
    val personasUnicas = personas.toSet() // Usa equals() y hashCode()
    
    println("Lista original (${personas.size} elementos):")
    personas.forEach { println("  - $it") }
    
    println("Set único (${personasUnicas.size} elementos únicos):")
    personasUnicas.forEach { println("  - $it") }
    
    println("\n✨ VENTAJAS DE DATA CLASSES:")
    println("• Código más limpio y conciso")
    println("• Funciones útiles generadas automáticamente")
    println("• Ideal para objetos que representan datos")
    println("• Perfectas para transferir datos entre capas")
}
