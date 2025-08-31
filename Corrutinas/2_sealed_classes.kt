// =============================================================================
// EJEMPLO: CLASES SELLADAS (Sealed Classes)
// =============================================================================
// Las sealed classes representan jerarquías restringidas de tipos.
// Son útiles para representar estados, resultados, o tipos de datos limitados.
// Garantizan que el compilador conozca todos los subtipos posibles.

// Ejemplo 1: Resultado de operaciones (patrón común en programación)
sealed class Resultado<out T> {
    data class Exito<T>(val data: T) : Resultado<T>()
    data class Error(val mensaje: String, val codigo: Int = 0) : Resultado<Nothing>()
    object Cargando : Resultado<Nothing>()
}

// Ejemplo 2: Estados de un pedido en una tienda online
sealed class EstadoPedido {
    object Pendiente : EstadoPedido()
    data class Procesando(val numeroFactura: String) : EstadoPedido()
    data class Enviado(val numeroSeguimiento: String, val fechaEnvio: String) : EstadoPedido()
    data class Entregado(val fechaEntrega: String, val firmante: String) : EstadoPedido()
    data class Cancelado(val razon: String, val reembolsado: Boolean) : EstadoPedido()
}

// Ejemplo 3: Tipos de usuarios en una aplicación
sealed class TipoUsuario {
    object Invitado : TipoUsuario()
    data class Registrado(val fechaRegistro: String) : TipoUsuario()
    data class Premium(val fechaVencimiento: String, val beneficios: List<String>) : TipoUsuario()
    data class Administrador(val permisos: List<String>) : TipoUsuario()
}

// Funciones que trabajan con sealed classes
class ProcesadorResultados {
    
    // Pattern matching exhaustivo con when
    fun manejarResultado(resultado: Resultado<String>): String {
        return when (resultado) {
            is Resultado.Exito -> {
                "✅ Operación exitosa: ${resultado.data}"
            }
            is Resultado.Error -> {
                "❌ Error ${resultado.codigo}: ${resultado.mensaje}"
            }
            is Resultado.Cargando -> {
                "⏳ Operación en progreso..."
            }
            // ✨ El compilador garantiza que cubrimos todos los casos
            // Si agregamos un nuevo subtipo, obtendremos un error de compilación
        }
    }
    
    fun obtenerDescripcionEstado(estado: EstadoPedido): String {
        return when (estado) {
            is EstadoPedido.Pendiente -> 
                "🕐 Pedido recibido, esperando procesamiento"
            is EstadoPedido.Procesando -> 
                "🔄 Procesando pedido (Factura: ${estado.numeroFactura})"
            is EstadoPedido.Enviado -> 
                "📦 Enviado el ${estado.fechaEnvio} (Tracking: ${estado.numeroSeguimiento})"
            is EstadoPedido.Entregado -> 
                "✅ Entregado el ${estado.fechaEntrega} - Firmado por: ${estado.firmante}"
            is EstadoPedido.Cancelado -> {
                val reembolso = if (estado.reembolsado) "con reembolso" else "sin reembolso"
                "❌ Cancelado ($reembolso): ${estado.razon}"
            }
        }
    }
    
    fun obtenerNivelAcceso(tipoUsuario: TipoUsuario): String {
        return when (tipoUsuario) {
            is TipoUsuario.Invitado -> "Acceso básico de solo lectura"
            is TipoUsuario.Registrado -> "Acceso completo desde ${tipoUsuario.fechaRegistro}"
            is TipoUsuario.Premium -> {
                "Acceso premium hasta ${tipoUsuario.fechaVencimiento}\n" +
                "Beneficios: ${tipoUsuario.beneficios.joinToString(", ")}"
            }
            is TipoUsuario.Administrador -> {
                "Acceso de administrador\n" +
                "Permisos: ${tipoUsuario.permisos.joinToString(", ")}"
            }
        }
    }
}

fun main() {
    println("🔒 === CLASES SELLADAS (SEALED CLASSES) ===\n")
    
    val procesador = ProcesadorResultados()
    
    // -------------------------------------------------------------------------
    // EJEMPLO 1: Manejo de resultados de operaciones
    // -------------------------------------------------------------------------
    println("💾 === RESULTADOS DE OPERACIONES ===")
    
    val resultados = listOf(
        Resultado.Cargando,
        Resultado.Exito("Datos guardados correctamente"),
        Resultado.Error("Conexión perdida", 404),
        Resultado.Error("Datos inválidos")
    )
    
    resultados.forEach { resultado ->
        println(procesador.manejarResultado(resultado))
    }
    println()
    
    // -------------------------------------------------------------------------
    // EJEMPLO 2: Estados de pedidos
    // -------------------------------------------------------------------------
    println("📦 === ESTADOS DE PEDIDOS ===")
    
    val estadosPedido = listOf(
        EstadoPedido.Pendiente,
        EstadoPedido.Procesando("FAC-2024-001"),
        EstadoPedido.Enviado("TRK123456", "2024-08-30"),
        EstadoPedido.Entregado("2024-08-31", "Juan Pérez"),
        EstadoPedido.Cancelado("Producto agotado", true)
    )
    
    estadosPedido.forEach { estado ->
        println(procesador.obtenerDescripcionEstado(estado))
    }
    println()
    
    // -------------------------------------------------------------------------
    // EJEMPLO 3: Tipos de usuarios
    // -------------------------------------------------------------------------
    println("👥 === TIPOS DE USUARIOS ===")
    
    val tiposUsuario = listOf(
        TipoUsuario.Invitado,
        TipoUsuario.Registrado("2024-01-15"),
        TipoUsuario.Premium("2024-12-31", listOf("Sin anuncios", "Descarga offline", "Soporte prioritario")),
        TipoUsuario.Administrador(listOf("Crear usuarios", "Eliminar contenido", "Ver estadísticas"))
    )
    
    tiposUsuario.forEach { tipo ->
        println("${tipo::class.simpleName}: ${procesador.obtenerNivelAcceso(tipo)}")
        println("---")
    }
    
    println("✨ VENTAJAS DE SEALED CLASSES:")
    println("• Pattern matching exhaustivo y seguro")
    println("• El compilador garantiza que cubrimos todos los casos")
    println("• Ideales para representar estados o tipos limitados")
    println("• Evitan errores de lógica al agregar nuevos subtipos")
}
