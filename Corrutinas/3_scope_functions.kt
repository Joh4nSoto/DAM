// =============================================================================
// EJEMPLO: FUNCIONES DE ÁMBITO (Scope Functions)
// =============================================================================
// Las funciones de ámbito permiten ejecutar bloques de código en el contexto
// de un objeto. Las principales son: apply, let, run, with, also

data class Configuracion(
    var servidor: String = "",
    var puerto: Int = 0,
    var ssl: Boolean = false,
    var timeout: Int = 30
)

data class PerfilUsuario(
    val nombre: String,
    val edad: Int,
    val email: String?
)

class ServicioDatos {
    fun obtenerDatos(): String? {
        // Simula que a veces no hay datos
        return if ((1..10).random() > 3) "Datos importantes" else null
    }
}

fun main() {
    println("🔧 === FUNCIONES DE ÁMBITO (SCOPE FUNCTIONS) ===\n")
    
    // -------------------------------------------------------------------------
    // 1. APPLY - Configura un objeto y lo devuelve
    // -------------------------------------------------------------------------
    println("🛠️ === APPLY ===")
    println("• Usa 'this' para referenciar el objeto")
    println("• Devuelve el mismo objeto")
    println("• Ideal para configuración/inicialización")
    
    val config = Configuracion().apply {
        // 'this' se refiere al objeto Configuracion
        servidor = "api.miapp.com"
        puerto = 8080
        ssl = true
        timeout = 60
        println("🔧 Configurando servidor: $servidor:$puerto")
    }
    
    println("Configuración final: $config")
    println()
    
    // -------------------------------------------------------------------------
    // 2. LET - Opera con objeto no-null y devuelve resultado
    // -------------------------------------------------------------------------
    println("🔍 === LET ===")
    println("• Usa 'it' para referenciar el objeto")
    println("• Devuelve el resultado del bloque")
    println("• Ideal para operaciones con objetos nullable")
    
    val email1: String? = "usuario@email.com"
    val email2: String? = null
    
    val resultado1 = email1?.let { emailNoNull ->
        // 'it' o el parámetro nombrado se refiere al objeto no-null
        println("✅ Email válido: $emailNoNull")
        "Email procesado: ${emailNoNull.uppercase()}"
    } ?: "❌ Email nulo"
    
    val resultado2 = email2?.let { emailNoNull ->
        println("✅ Email válido: $emailNoNull")
        "Email procesado: ${emailNoNull.uppercase()}"
    } ?: "❌ Email nulo"
    
    println("Resultado 1: $resultado1")
    println("Resultado 2: $resultado2")
    println()
    
    // -------------------------------------------------------------------------
    // 3. RUN - Ejecuta código y devuelve resultado
    // -------------------------------------------------------------------------
    println("🏃 === RUN ===")
    println("• Usa 'this' para referenciar el objeto")
    println("• Devuelve el resultado del bloque")
    println("• Ideal para cálculos basados en propiedades del objeto")
    
    val perfil = PerfilUsuario("María González", 28, "maria@email.com")
    
    val descripcion = perfil.run {
        // 'this' se refiere al objeto perfil
        val categoria = when {
            edad < 18 -> "Menor"
            edad < 60 -> "Adulto"
            else -> "Adulto Mayor"
        }
        "👤 $nombre ($categoria) - Email: ${email ?: "No disponible"}"
    }
    
    println("Descripción generada: $descripcion")
    println()
    
    // -------------------------------------------------------------------------
    // 4. WITH - Similar a run pero no es función de extensión
    // -------------------------------------------------------------------------
    println("🤝 === WITH ===")
    println("• No es función de extensión")
    println("• Usa 'this' para referenciar el objeto")
    println("• Ideal cuando ya tienes el objeto como parámetro")
    
    val resumenConfig = with(config) {
        // 'this' se refiere al objeto config
        """
        🌐 Configuración del servidor:
        📍 URL: ${if (ssl) "https" else "http"}://$servidor:$puerto
        ⏱️ Timeout: $timeout segundos
        🔒 SSL: ${if (ssl) "Habilitado" else "Deshabilitado"}
        """.trimIndent()
    }
    
    println(resumenConfig)
    println()
    
    // -------------------------------------------------------------------------
    // 5. ALSO - Ejecuta código adicional sin cambiar el objeto
    // -------------------------------------------------------------------------
    println("➕ === ALSO ===")
    println("• Usa 'it' para referenciar el objeto")
    println("• Devuelve el mismo objeto")
    println("• Ideal para acciones adicionales (logging, validación)")
    
    val usuarioFinal = perfil
        .also { println("🔍 Validando usuario: ${it.nombre}") }
        .also { println("📧 Verificando email: ${it.email}") }
        .also { println("🎂 Edad verificada: ${it.edad} años") }
    
    println("Usuario final: $usuarioFinal")
    println()
    
    // -------------------------------------------------------------------------
    // EJEMPLO PRÁCTICO: Combinando scope functions
    // -------------------------------------------------------------------------
    println("🎯 === EJEMPLO PRÁCTICO COMBINADO ===")
    
    val servicio = ServicioDatos()
    
    val resultado = servicio.obtenerDatos()?.let { datos ->
        // LET: procesa datos si no son null
        println("📄 Datos recibidos: $datos")
        datos.uppercase()
    }?.also { datosProcessados ->
        // ALSO: logging adicional sin cambiar el resultado
        println("📊 Datos procesados: $datosProcessados")
    } ?: run {
        // RUN: maneja el caso null
        println("⚠️ No se encontraron datos")
        "SIN DATOS"
    }
    
    println("🎁 Resultado final: $resultado")
    
    println("\n📚 RESUMEN SCOPE FUNCTIONS:")
    println("• APPLY: configura objeto, devuelve objeto (this)")
    println("• LET: procesa objeto no-null, devuelve resultado (it)")
    println("• RUN: ejecuta código, devuelve resultado (this)")
    println("• WITH: como run pero no es extensión")
    println("• ALSO: acción adicional, devuelve objeto (it)")
}
