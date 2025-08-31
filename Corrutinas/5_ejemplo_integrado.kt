// =============================================================================
// EJEMPLO INTEGRADO: Todos los conceptos juntos
// =============================================================================
// Este archivo demuestra cómo todos los conceptos trabajan juntos
// en una aplicación real

import kotlinx.coroutines.*

// Data classes para el modelo de datos
data class Cliente(
    val id: Int,
    val nombre: String,
    val email: String,
    val activo: Boolean = true
)

data class Pedido(
    val id: Int,
    val clienteId: Int,
    val productos: List<String>,
    val total: Double,
    val estado: EstadoPedido = EstadoPedido.Pendiente
)

// Sealed class para los estados
sealed class EstadoPedido {
    object Pendiente : EstadoPedido()
    data class Confirmado(val fecha: String) : EstadoPedido()
    data class Enviado(val tracking: String) : EstadoPedido()
    object Entregado : EstadoPedido()
    data class Cancelado(val razon: String) : EstadoPedido()
}

// Sealed class para resultados de operaciones
sealed class ResultadoOperacion<out T> {
    data class Exito<T>(val data: T) : ResultadoOperacion<T>()
    data class Error(val mensaje: String) : ResultadoOperacion<Nothing>()
    object Procesando : ResultadoOperacion<Nothing>()
}

// =============================================================================
// SERVICIO QUE INTEGRA TODOS LOS CONCEPTOS
// =============================================================================

class ServicioPedidos {
    
    // Simula base de datos con suspend functions
    suspend fun obtenerCliente(id: Int): Cliente? {
        delay(500) // Simula consulta a BD
        return Cliente(id, "Cliente $id", "cliente$id@tienda.com")
    }
    
    suspend fun calcularTotal(productos: List<String>): Double {
        delay(300) // Simula cálculo complejo
        return productos.size * 25.99
    }
    
    suspend fun validarInventario(productos: List<String>): Boolean {
        delay(400) // Simula validación
        return productos.size <= 5 // Máximo 5 productos
    }
    
    suspend fun guardarPedido(pedido: Pedido): ResultadoOperacion<String> {
        delay(600) // Simula guardado
        return if ((1..10).random() > 2) {
            ResultadoOperacion.Exito("Pedido ${pedido.id} guardado exitosamente")
        } else {
            ResultadoOperacion.Error("Error al guardar en la base de datos")
        }
    }
}

// =============================================================================
// PROCESADOR QUE USA SCOPE FUNCTIONS
// =============================================================================

class ProcesadorPedidos {
    
    fun crearPedidoConApply(clienteId: Int, productos: List<String>, total: Double): Pedido {
        // APPLY para configurar el objeto
        return Pedido(
            id = (1000..9999).random(),
            clienteId = clienteId,
            productos = productos,
            total = total
        ).apply {
            // Configuraciones adicionales usando apply
            println("🛒 Pedido creado: ID $id para cliente $clienteId")
            println("🛒 Total: $$total (${productos.size} productos)")
        }
    }
    
    fun validarClienteConLet(cliente: Cliente?): String {
        // LET para manejo seguro de nullables
        return cliente?.let { clienteValido ->
            if (clienteValido.activo) {
                "✅ Cliente ${clienteValido.nombre} validado"
            } else {
                "❌ Cliente ${clienteValido.nombre} inactivo"
            }
        } ?: "❌ Cliente no encontrado"
    }
    
    fun obtenerDescripcionEstado(estado: EstadoPedido): String {
        // Pattern matching con sealed classes
        return when (estado) {
            is EstadoPedido.Pendiente -> "⏳ Esperando confirmación"
            is EstadoPedido.Confirmado -> "✅ Confirmado el ${estado.fecha}"
            is EstadoPedido.Enviado -> "📦 Enviado (Tracking: ${estado.tracking})"
            is EstadoPedido.Entregado -> "🎉 Entregado exitosamente"
            is EstadoPedido.Cancelado -> "❌ Cancelado: ${estado.razon}"
        }
    }
}

// =============================================================================
// FUNCIÓN PRINCIPAL QUE INTEGRA TODO
// =============================================================================

suspend fun main() = coroutineScope {
    println("🏪 === TIENDA ONLINE - EJEMPLO INTEGRADO ===\n")
    
    val servicio = ServicioPedidos()
    val procesador = ProcesadorPedidos()
    
    println("🛍️ Procesando nuevo pedido...")
    
    // -------------------------------------------------------------------------
    // PROCESAMIENTO ASÍNCRONO CON ASYNC
    // -------------------------------------------------------------------------
    
    val productos = listOf("Laptop", "Mouse", "Teclado")
    val clienteId = 123
    
    val tiempoTotal = measureTimeMillis {
        
        // Ejecutamos operaciones en paralelo con ASYNC
        val clienteDeferred = async {
            println("👤 Obteniendo datos del cliente...")
            servicio.obtenerCliente(clienteId)
        }
        
        val totalDeferred = async {
            println("💰 Calculando total...")
            servicio.calcularTotal(productos)
        }
        
        val inventarioDeferred = async {
            println("📦 Validando inventario...")
            servicio.validarInventario(productos)
        }
        
        // Esperamos todos los resultados
        val cliente = clienteDeferred.await()
        val total = totalDeferred.await()
        val inventarioOk = inventarioDeferred.await()
        
        // -------------------------------------------------------------------------
        // PROCESAMIENTO CON SCOPE FUNCTIONS
        // -------------------------------------------------------------------------
        
        // Validamos cliente con LET
        val validacionCliente = procesador.validarClienteConLet(cliente)
        println(validacionCliente)
        
        if (cliente != null && inventarioOk) {
            // Creamos pedido con APPLY
            val pedido = procesador.crearPedidoConApply(clienteId, productos, total)
            
            // -------------------------------------------------------------------------
            // SIMULACIÓN DE ESTADOS CON SEALED CLASSES
            // -------------------------------------------------------------------------
            
            val estados = listOf(
                EstadoPedido.Pendiente,
                EstadoPedido.Confirmado("2024-08-30"),
                EstadoPedido.Enviado("TRK123456"),
                EstadoPedido.Entregado
            )
            
            // Simulamos progreso del pedido con LAUNCH
            launch {
                estados.forEach { estado ->
                    val pedidoActualizado = pedido.copy(estado = estado)
                    println("📋 Estado: ${procesador.obtenerDescripcionEstado(estado)}")
                    delay(800)
                }
            }
            
            // Guardamos el pedido con manejo de resultado
            val resultadoGuardado = servicio.guardarPedido(pedido)
            
            // Pattern matching con sealed class
            when (resultadoGuardado) {
                is ResultadoOperacion.Exito -> {
                    println("🎉 ${resultadoGuardado.data}")
                }
                is ResultadoOperacion.Error -> {
                    println("💥 Error: ${resultadoGuardado.mensaje}")
                }
                is ResultadoOperacion.Procesando -> {
                    println("⏳ Aún procesando...")
                }
            }
            
        } else {
            println("❌ No se puede procesar el pedido")
            if (!inventarioOk) println("   - Inventario insuficiente")
            if (cliente == null) println("   - Cliente no encontrado")
        }
    }
    
    println("\n⏱️ Tiempo total de procesamiento: ${tiempoTotal}ms")
    
    // -------------------------------------------------------------------------
    // EJEMPLO DE MÚLTIPLES PEDIDOS EN PARALELO
    // -------------------------------------------------------------------------
    
    println("\n🔀 === PROCESAMIENTO PARALELO ===")
    
    val tiempoParalelo = measureTimeMillis {
        val nombresArchivos = listOf("pedido1", "pedido2", "pedido3")
        
        println("🚀 Iniciando procesamiento paralelo de ${nombresArchivos.size} archivos...")
        val resultados = gestor.procesarVariosArchivosParalelo(nombresArchivos)
        
        println("✅ Todos los archivos procesados:")
        resultados.forEach { archivo ->
            println("   📄 $archivo")
        }
    }
    
    println("⏱️ Tiempo paralelo: ${tiempoParalelo}ms")
    
    println("\n🎓 === CONCEPTOS DEMOSTRADOS ===")
    println("✅ Data Classes: Cliente y Pedido con funciones automáticas")
    println("✅ Sealed Classes: EstadoPedido y ResultadoOperacion")
    println("✅ Scope Functions: apply para configurar, let para validar")
    println("✅ Suspend Functions: operaciones que se pueden pausar")
    println("✅ Launch: tareas en background")
    println("✅ Async/Await: operaciones paralelas con resultado")
    println("✅ CoroutineScope: gestión del ciclo de vida")
}
