// =============================================================================
// EJEMPLO: CORRUTINAS BÁSICAS (Suspend Functions, Launch, Async)
// =============================================================================
// Las corrutinas permiten programación asíncrona sin bloquear hilos.
// IMPORTANTE: Este ejemplo requiere la dependencia kotlinx-coroutines-core

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

// =============================================================================
// SUSPEND FUNCTIONS
// =============================================================================

// SUSPEND FUNCTION: puede ser pausada y reanudada
suspend fun operacionLenta(nombre: String, duracion: Long): String {
    println("⏳ Iniciando $nombre (${duracion}ms)")
    delay(duracion) // delay es una suspend function que pausa sin bloquear
    println("✅ $nombre completada")
    return "Resultado de $nombre"
}

suspend fun descargarArchivo(nombre: String): String {
    println("📥 Descargando $nombre...")
    delay(2000) // Simula descarga de 2 segundos
    return "archivo_$nombre.dat"
}

suspend fun procesarArchivo(archivo: String): String {
    println("⚙️ Procesando $archivo...")
    delay(1500) // Simula procesamiento de 1.5 segundos
    return "procesado_$archivo"
}

suspend fun subirAServidor(archivo: String): Boolean {
    println("☁️ Subiendo $archivo al servidor...")
    delay(1000) // Simula subida de 1 segundo
    return true
}

// =============================================================================
// CLASE PARA DEMOSTRAR CORRUTINAS
// =============================================================================

class GestorArchivos {
    
    // Operación secuencial (una tras otra)
    suspend fun procesarArchivoSecuencial(nombre: String): String {
        val archivo = descargarArchivo(nombre)
        val archivoProcesado = procesarArchivo(archivo)
        subirAServidor(archivoProcesado)
        return archivoProcesado
    }
    
    // Operación paralela (varias al mismo tiempo)
    suspend fun procesarVariosArchivosParalelo(nombres: List<String>): List<String> {
        return coroutineScope {
            // Creamos múltiples operaciones async que se ejecutan en paralelo
            nombres.map { nombre ->
                async {
                    procesarArchivoSecuencial(nombre)
                }
            }.awaitAll() // Esperamos todos los resultados
        }
    }
}

// =============================================================================
// FUNCIÓN PRINCIPAL
// =============================================================================

suspend fun main() = coroutineScope {
    println("⚡ === CORRUTINAS BÁSICAS ===\n")
    
    val gestor = GestorArchivos()
    
    // -------------------------------------------------------------------------
    // 1. SUSPEND FUNCTIONS básicas
    // -------------------------------------------------------------------------
    println("🔧 === SUSPEND FUNCTIONS ===")
    
    val resultado1 = operacionLenta("Operación A", 1000)
    val resultado2 = operacionLenta("Operación B", 800)
    
    println("Resultados: $resultado1, $resultado2")
    println()
    
    // -------------------------------------------------------------------------
    // 2. LAUNCH - Corrutina sin valor de retorno
    // -------------------------------------------------------------------------
    println("🚀 === LAUNCH (Fire and Forget) ===")
    
    // LAUNCH inicia corrutinas que se ejecutan independientemente
    val job1 = launch {
        repeat(3) { i ->
            println("🔄 Tarea background $i")
            delay(500)
        }
    }
    
    val job2 = launch {
        println("📊 Generando reporte...")
        delay(1200)
        println("📋 Reporte completado")
    }
    
    println("⏰ Mientras las tareas se ejecutan, puedo hacer otras cosas...")
    delay(300)
    println("🎯 Otra operación realizada")
    
    // Esperamos que terminen las tareas launch
    joinAll(job1, job2)
    println()
    
    // -------------------------------------------------------------------------
    // 3. ASYNC - Corrutina que devuelve valor
    // -------------------------------------------------------------------------
    println("🔄 === ASYNC (Con valor de retorno) ===")
    
    val tiempo = measureTimeMillis {
        // ASYNC permite ejecutar operaciones en paralelo
        val deferred1 = async { operacionLenta("Cálculo A", 1000) }
        val deferred2 = async { operacionLenta("Cálculo B", 1200) }
        val deferred3 = async { operacionLenta("Cálculo C", 800) }
        
        // AWAIT obtiene los resultados cuando estén listos
        val resultados = listOf(
            deferred1.await(),
            deferred2.await(), 
            deferred3.await()
        )
        
        println("🎁 Todos los resultados: $resultados")
    }
    
    println("⏱️ Tiempo total (paralelo): ${tiempo}ms")
    println("💡 Sin async habría tomado ~3000ms (1000+1200+800)")
    println()
    
    // -------------------------------------------------------------------------
    // 4. EJEMPLO PRÁCTICO: Procesamiento de archivos
    // -------------------------------------------------------------------------
    println("📁 === EJEMPLO PRÁCTICO ===")
    
    // Procesamiento secuencial
    println("🔄 Procesamiento secuencial:")
    val tiempoSecuencial = measureTimeMillis {
        val resultado = gestor.procesarArchivoSecuencial("documento1")
        println("✅ Secuencial terminado: $resultado")
    }
    println("⏱️ Tiempo secuencial: ${tiempoSecuencial}ms")
    println()
    
    // Procesamiento paralelo
    println("🚀 Procesamiento paralelo:")
    val tiempoParalelo = measureTimeMillis {
        val archivos = listOf("documento2", "documento3", "documento4")
        val resultados = gestor.procesarVariosArchivosParalelo(archivos)
        println("✅ Paralelo terminado: $resultados")
    }
    println("⏱️ Tiempo paralelo: ${tiempoParalelo}ms")
    println()
    
    // -------------------------------------------------------------------------
    // 5. MANEJO DE EXCEPCIONES EN CORRUTINAS
    // -------------------------------------------------------------------------
    println("⚠️ === MANEJO DE EXCEPCIONES ===")
    
    try {
        val operacionRiesgosa = async {
            delay(500)
            if ((1..10).random() > 7) {
                throw Exception("Algo salió mal en la operación")
            }
            "Operación exitosa"
        }
        
        val resultado = operacionRiesgosa.await()
        println("✅ $resultado")
        
    } catch (e: Exception) {
        println("❌ Error capturado: ${e.message}")
    }
    
    println("\n📚 RESUMEN CORRUTINAS:")
    println("• SUSPEND FUN: funciones que se pueden pausar sin bloquear hilos")
    println("• COROUTINESCOPE: define el ámbito y ciclo de vida de las corrutinas")
    println("• LAUNCH: inicia corrutina sin retorno (fire and forget)")
    println("• ASYNC: inicia corrutina que devuelve Deferred<T>")
    println("• AWAIT: espera el resultado de una corrutina async")
    println("• DELAY: pausa la corrutina sin bloquear el hilo")
    println("• Las corrutinas son más eficientes que los hilos tradicionales")
}
