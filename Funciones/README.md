# 🔧 Funciones en Kotlin

Guía completa sobre funciones, parámetros y técnicas avanzadas.

## 📋 Tipos de Funciones

### **Funciones Básicas**
```kotlin
fun saludar(nombre: String): String {
    return "Hola, $nombre"
}
```

### **Funciones de Expresión**
```kotlin
fun sumar(a: Int, b: Int) = a + b
```

### **Funciones con Parámetros por Defecto**
```kotlin
fun crearUsuario(nombre: String, edad: Int = 18, activo: Boolean = true) {
    // Implementación
}
```

### **Funciones de Orden Superior**
```kotlin
fun operar(a: Int, b: Int, operacion: (Int, Int) -> Int): Int {
    return operacion(a, b)
}
```

## 🎯 Conceptos Avanzados

### **Lambdas**
```kotlin
val multiplicar = { a: Int, b: Int -> a * b }
val numeros = listOf(1, 2, 3, 4, 5)
val dobles = numeros.map { it * 2 }
```

### **Funciones de Extensión**
```kotlin
fun String.esPalindromo(): Boolean {
    return this == this.reversed()
}

"radar".esPalindromo() // true
```

### **Funciones Inline**
```kotlin
inline fun medirTiempo(accion: () -> Unit) {
    val inicio = System.currentTimeMillis()
    accion()
    val fin = System.currentTimeMillis()
    println("Tiempo: ${fin - inicio}ms")
}
```

## 🛠️ Patrones Útiles

### **Validación con Retorno Temprano**
```kotlin
fun validarEdad(edad: Int): String {
    if (edad < 0) return "❌ Edad no puede ser negativa"
    if (edad > 150) return "❌ Edad no realista"
    return "✅ Edad válida"
}
```

### **Funciones que Devuelven Múltiples Valores**
```kotlin
data class Coordenadas(val x: Int, val y: Int)

fun calcularPosicion(): Coordenadas {
    return Coordenadas(10, 20)
}

// O usando Pair
fun calcularMinMax(numeros: List<Int>): Pair<Int, Int> {
    return Pair(numeros.minOrNull() ?: 0, numeros.maxOrNull() ?: 0)
}
```

## 🎮 Ejemplos Prácticos

### **Calculadora**
```kotlin
fun calculadora(a: Double, b: Double, operacion: String): Double? {
    return when (operacion) {
        "+" -> a + b
        "-" -> a - b
        "*" -> a * b
        "/" -> if (b != 0.0) a / b else null
        else -> null
    }
}
```

### **Validador de Email**
```kotlin
fun validarEmail(email: String): Boolean {
    return email.contains("@") && 
           email.contains(".") && 
           email.length > 5
}
```

### **Generador de IDs**
```kotlin
fun generarId(prefijo: String = "USER"): String {
    val numero = (1000..9999).random()
    return "$prefijo$numero"
}
```

## 📱 Aplicaciones en Mobile

### **Callbacks de UI**
```kotlin
fun configurarBoton(onClick: () -> Unit) {
    // El onClick es una función que se ejecuta al presionar
}

configurarBoton { 
    println("¡Botón presionado!") 
}
```

### **Procesamiento de Listas**
```kotlin
fun filtrarUsuariosActivos(usuarios: List<Usuario>): List<Usuario> {
    return usuarios.filter { it.activo }
                  .sortedBy { it.nombre }
}
```

### **Funciones de Utilidad**
```kotlin
fun formatearFecha(timestamp: Long): String {
    // Convierte timestamp a fecha legible
}

fun validarContraseña(password: String): Boolean {
    return password.length >= 8 && 
           password.any { it.isDigit() } &&
           password.any { it.isUpperCase() }
}
```

## 🎓 Niveles de Aprendizaje

| Concepto | Nivel | Importancia Mobile |
|----------|-------|-------------------|
| Funciones básicas | 🟢 Básico | ⭐⭐⭐⭐⭐ |
| Parámetros por defecto | 🟡 Intermedio | ⭐⭐⭐⭐ |
| Lambdas | 🟡 Intermedio | ⭐⭐⭐⭐⭐ |
| Funciones de orden superior | 🟠 Avanzado | ⭐⭐⭐⭐ |
| Funciones de extensión | 🔴 Experto | ⭐⭐⭐ |

## 💡 Tips Importantes

- 🎯 **Nombres descriptivos** para las funciones
- 📦 **Funciones pequeñas** que hagan una cosa bien
- 🔄 **Reutiliza** código común en funciones
- 🧪 **Testa** funciones por separado
- 📱 En mobile, las funciones **callbacks** son fundamentales

## 🧪 Ejercicios Sugeridos

1. **Crea** una función que valide un número de teléfono
2. **Implementa** una calculadora con funciones separadas
3. **Diseña** funciones para manejar configuraciones de app
4. **Experimenta** con lambdas en operaciones de listas

---
*Funciones - Desarrollo Mobile DuocUC*
