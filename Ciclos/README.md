# 🔄 Ciclos en Kotlin

Ejemplos de estructuras de control iterativas en Kotlin.

## 📋 Contenido

### FOR Loop
- **Rangos**: `for (i in 1..10)`
- **Listas**: `for (item in lista)`
- **Índices**: `for (i in lista.indices)`
- **Con índice y valor**: `for ((index, value) in lista.withIndex())`
- **Paso personalizado**: `for (i in 1..10 step 2)`
- **Descendente**: `for (i in 10 downTo 1)`

### WHILE Loop
- **While**: Repite mientras la condición sea verdadera
- **Do-While**: Ejecuta al menos una vez, luego evalúa

### Casos de Uso Comunes
- Iteración sobre colecciones
- Contadores y acumuladores
- Búsquedas en listas
- Validación de entrada repetida

## 🎯 Conceptos Clave

### Cuándo usar cada ciclo:
- **FOR**: Cuando sabes cuántas veces iterar o tienes una colección
- **WHILE**: Cuando la condición de parada es dinámica
- **DO-WHILE**: Cuando necesitas ejecutar al menos una vez

## 📝 Ejemplos Prácticos

```kotlin
// FOR con rango
for (i in 1..5) {
    println("Número: $i")
}

// FOR con lista
val frutas = listOf("🍎", "🍌", "🍊")
for (fruta in frutas) {
    println("Fruta: $fruta")
}

// WHILE para entrada de usuario
var continuar = true
while (continuar) {
    // Lógica del programa
    continuar = false // Condición de salida
}
```

## 🚀 Cómo practicar

1. **Ejecuta los ejemplos** en [Kotlin Playground](https://play.kotlinlang.org/)
2. **Modifica los rangos** y observa los cambios
3. **Crea tus propias listas** para iterar
4. **Combina ciclos** con condicionales

## 💡 Tips importantes

- ⚡ **FOR** es más eficiente para colecciones conocidas
- 🔒 Evita **ciclos infinitos** con WHILE
- 🎯 Usa **break** y **continue** para controlar el flujo
- 📊 Los ciclos son fundamentales para procesar datos

---
*Parte del curso de Desarrollo Mobile - DuocUC*
