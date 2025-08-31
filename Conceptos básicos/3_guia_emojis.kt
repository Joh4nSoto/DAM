// =============================================================================
// GUÍA DE EMOJIS PARA PROGRAMACIÓN EN KOTLIN
// =============================================================================

fun main() {
    println("📝 === GUÍA DE EMOJIS PARA CÓDIGO ===\n")
    
    // -------------------------------------------------------------------------
    // ESTADOS Y RESULTADOS
    // -------------------------------------------------------------------------
    println("🎯 === ESTADOS Y RESULTADOS ===")
    println("✅ Éxito, correcto, completado")
    println("❌ Error, fallo, incorrecto")
    println("⚠️ Advertencia, precaución")
    println("ℹ️ Información, nota")
    println("⏳ Cargando, esperando")
    println("🔄 Procesando, en progreso")
    println("🎉 Celebración, terminado con éxito")
    println("💥 Explosión, error crítico")
    println("🛑 Stop, detenido")
    println("🟢 Verde, activo, disponible")
    println("🔴 Rojo, inactivo, error")
    println("🟡 Amarillo, advertencia, pendiente")
    println()
    
    // -------------------------------------------------------------------------
    // TECNOLOGÍA Y DESARROLLO
    // -------------------------------------------------------------------------
    println("💻 === TECNOLOGÍA Y DESARROLLO ===")
    println("🚀 Lanzar, iniciar, rápido")
    println("⚡ Rápido, energía, corrutinas")
    println("🔧 Configuración, herramientas")
    println("🛠️ Construcción, build")
    println("⚙️ Engranajes, procesamiento")
    println("🔍 Buscar, encontrar")
    println("📊 Datos, estadísticas")
    println("📈 Gráfico creciente, mejora")
    println("📉 Gráfico decreciente, reducción")
    println("💾 Guardar, almacenamiento")
    println("📁 Carpeta, directorio")
    println("📄 Archivo, documento")
    println("🔗 Enlace, conexión")
    println("🌐 Web, internet, global")
    println("☁️ Nube, servidor")
    println("🔒 Seguridad, encriptación")
    println("🔓 Abierto, desbloqueado")
    println("🔑 Clave, autenticación")
    println()
    
    // -------------------------------------------------------------------------
    // OBJETOS Y CONCEPTOS
    // -------------------------------------------------------------------------
    println("📦 === OBJETOS Y CONCEPTOS ===")
    println("👤 Usuario, persona")
    println("👥 Usuarios, grupo")
    println("🏪 Tienda, comercio")
    println("🛒 Carrito de compras")
    println("💳 Pago, tarjeta")
    println("📦 Paquete, envío")
    println("🎁 Regalo, resultado")
    println("📋 Lista, clipboard")
    println("📝 Escribir, crear")
    println("🗃️ Archivo, base de datos")
    println("🎯 Objetivo, target")
    println("🔤 Texto, string")
    println("🔢 Números, matemáticas")
    println("📐 Medición, cálculo")
    println()
    
    // -------------------------------------------------------------------------
    // TIEMPO Y FLUJO
    // -------------------------------------------------------------------------
    println("⏰ === TIEMPO Y FLUJO ===")
    println("⏰ Tiempo, reloj")
    println("⏱️ Cronómetro, medición")
    println("⏳ Esperando, timeout")
    println("🕐 Hora específica")
    println("📅 Fecha, calendario")
    println("🔄 Repetir, loop")
    println("▶️ Reproducir, ejecutar")
    println("⏸️ Pausar")
    println("⏹️ Detener")
    println("⏭️ Siguiente")
    println("⏮️ Anterior")
    println("🔀 Aleatorio, shuffle")
    println("🔁 Repetir todo")
    println()
    
    // -------------------------------------------------------------------------
    // COMUNICACIÓN Y NOTIFICACIONES
    // -------------------------------------------------------------------------
    println("📢 === COMUNICACIÓN ===")
    println("📧 Email")
    println("📱 Móvil, app")
    println("💬 Chat, mensaje")
    println("🔔 Notificación")
    println("📞 Llamada")
    println("📤 Enviar")
    println("📥 Recibir")
    println("📨 Mensaje recibido")
    println("✉️ Carta, correo")
    println()
    
    // -------------------------------------------------------------------------
    // EJEMPLO PRÁCTICO DE USO
    // -------------------------------------------------------------------------
    println("🎨 === EJEMPLO PRÁCTICO ===")
    
    fun simularOperacion(exito: Boolean): String {
        return if (exito) {
            "🎉 ¡Operación completada exitosamente!"
        } else {
            "💥 Error crítico en la operación"
        }
    }
    
    fun mostrarEstadoServidor(activo: Boolean): String {
        return if (activo) {
            "🟢 Servidor activo y funcionando"
        } else {
            "🔴 Servidor inactivo o con problemas"
        }
    }
    
    fun progresoCarga(porcentaje: Int): String {
        return when {
            porcentaje < 25 -> "🔴 Cargando... $porcentaje%"
            porcentaje < 50 -> "🟡 Cargando... $porcentaje%"
            porcentaje < 75 -> "🟠 Cargando... $porcentaje%"
            porcentaje < 100 -> "🟢 Casi listo... $porcentaje%"
            else -> "✅ ¡Completado! 100%"
        }
    }
    
    // Demostramos el uso
    println(simularOperacion(true))
    println(simularOperacion(false))
    println(mostrarEstadoServidor(true))
    println(mostrarEstadoServidor(false))
    
    for (i in 0..100 step 25) {
        println(progresoCarga(i))
    }
    
    println("\n💡 CONSEJOS PARA USAR EMOJIS EN CÓDIGO:")
    println("• Úsalos en println() y comentarios para mayor claridad")
    println("• Ayudan a identificar rápidamente tipos de mensajes")
    println("• Hacen el código más legible y divertido")
    println("• Especialmente útiles en logs y mensajes de debug")
    println("• No abuses: úsalos con propósito, no decoración")
    
    println("\n🔥 ATAJOS ÚTILES:")
    println("• Windows: Win + . (abre panel de emojis)")
    println("• VS Code: Instala extensión 'Emoji'")
    println("• Web: Emojipedia.org para buscar emojis específicos")
}
