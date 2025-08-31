# 🛡️ Control de Errores en Kotlin

Manejo seguro de excepciones y validación de errores.

## 📋 Contenido

### Try-Catch-Finally
- **try**: Bloque de código que puede fallar
- **catch**: Manejo específico de excepciones
- **finally**: Código que siempre se ejecuta

### Tipos de Excepciones Comunes
- `ArithmeticException`: División por cero
- `NullPointerException`: Acceso a null
- `NumberFormatException`: Conversión de tipos
- `IndexOutOfBoundsException`: Índices inválidos

## 🎯 Conceptos Clave

### 1. **Manejo Básico**
```kotlin
try {
    val resultado = 10 / 0
} catch (e: ArithmeticException) {
    println("Error: ${e.message}")
} finally {
    println("Limpieza de recursos")
}
```

### 2. **Múltiples Catch**
```kotlin
try {
    // Código riesgoso
} catch (e: ArithmeticException) {
    // Manejo específico
} catch (e: Exception) {
    // Manejo genérico
}
```

### 3. **Validación Preventiva**
```kotlin
fun dividirSeguro(a: Int, b: Int): Int? {
    return if (b != 0) a / b else null
}
```

## 🚀 Buenas Prácticas

### ✅ **Haz esto:**
- Maneja excepciones específicas primero
- Usa `finally` para limpieza de recursos
- Valida entradas antes de procesarlas
- Proporciona mensajes de error útiles

### ❌ **Evita esto:**
- Capturar `Exception` genérica sin razón
- Ignorar excepciones (catch vacío)
- Usar try-catch para control de flujo normal
- Exponer detalles internos en mensajes de error

## 🎮 Ejemplos Prácticos

### **División Segura**
```kotlin
fun dividir(a: Int, b: Int): Int {
    return try {
        a / b
    } catch(e: ArithmeticException) {
        println("Error: ${e.message}")
        0 // Valor por defecto
    }
}
```

### **Conversión de Tipos**
```kotlin
fun convertirAEntero(texto: String): Int? {
    return try {
        texto.toInt()
    } catch (e: NumberFormatException) {
        println("'$texto' no es un número válido")
        null
    }
}
```

### **Acceso a Listas**
```kotlin
fun obtenerElemento(lista: List<String>, indice: Int): String? {
    return try {
        lista[indice]
    } catch (e: IndexOutOfBoundsException) {
        println("Índice $indice fuera de rango")
        null
    }
}
```

## 🔍 En Desarrollo Mobile

### **Casos Comunes:**
- **Conexión de red**: Timeout, sin internet
- **Parsing JSON**: Datos malformados
- **Base de datos**: Registros no encontrados
- **Permisos**: Acceso denegado
- **Almacenamiento**: Espacio insuficiente

### **Ejemplo Mobile:**
```kotlin
suspend fun cargarDatosUsuario(id: Int): ResultadoOperacion<Usuario> {
    return try {
        val usuario = apiService.obtenerUsuario(id)
        ResultadoOperacion.Exito(usuario)
    } catch (e: ConnectException) {
        ResultadoOperacion.Error("Sin conexión a internet")
    } catch (e: HttpException) {
        ResultadoOperacion.Error("Error del servidor: ${e.code()}")
    } catch (e: Exception) {
        ResultadoOperacion.Error("Error inesperado: ${e.message}")
    }
}
```

## 🎓 Para el Examen

**Puntos importantes:**
1. **Sintaxis correcta** de try-catch-finally
2. **Orden de catch** (específico → genérico)
3. **Cuándo usar** cada tipo de manejo
4. **Valores de retorno** en funciones con errores

## 💡 Consejos

- 🛡️ **Prevenir** es mejor que **curar**
- 📱 En mobile, los errores afectan la **experiencia del usuario**
- 🔍 **Log** los errores para debugging
- 💬 **Mensajes** claros y amigables para el usuario

---
*Control de Errores - Desarrollo Mobile DuocUC*
