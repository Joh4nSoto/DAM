# Ejemplos de Kotlin - Conceptos Avanzados

Este directorio contiene ejemplos separados de conceptos importantes de Kotlin:

## 📁 Archivos incluidos:

### 1. `1_data_classes.kt` - Clases de Datos
- **toString()**: Representación automática en string
- **equals()**: Comparación por valor 
- **hashCode()**: Código hash para colecciones
- **copy()**: Crear copias con modificaciones

### 2. `2_sealed_classes.kt` - Clases Selladas
- Jerarquías restringidas de tipos
- Pattern matching exhaustivo y seguro
- Ideales para estados y resultados de operaciones

### 3. `3_scope_functions.kt` - Funciones de Ámbito
- **apply**: Configura objeto, devuelve el mismo objeto
- **let**: Opera con objeto no-null, devuelve resultado
- **run**: Ejecuta código, devuelve resultado
- **with**: Como run pero no es función de extensión
- **also**: Acción adicional, devuelve el objeto

### 4. `4_corrutinas.kt` - Corrutinas Básicas
- **suspend fun**: Funciones que se pueden pausar
- **coroutineScope**: Define ámbito de corrutinas
- **launch**: Inicia corrutina sin valor de retorno
- **async/await**: Inicia corrutina que devuelve valor
- Programación asíncrona y paralela

### 5. `5_ejemplo_integrado.kt` - Todos los Conceptos Juntos
- Aplicación completa de tienda online
- Integra todos los conceptos anteriores
- Demuestra cómo trabajar en conjunto

## 🚀 Cómo ejecutar:

### Opción 1: Kotlin Playground (Recomendado)
1. Ve a https://play.kotlinlang.org/
2. Copia el código de cualquier archivo
3. Ejecuta directamente en el navegador

### Opción 2: Proyecto Kotlin local
Para ejecutar los archivos con corrutinas necesitarás:

1. **build.gradle.kts**:
```kotlin
dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
}
```

2. **Ejecutar**:
```bash
kotlinc archivo.kt -include-runtime -d output.jar
java -jar output.jar
```

## 📚 Orden de estudio recomendado:
1. **Data Classes** (conceptos básicos)
2. **Scope Functions** (sintaxis útil)
3. **Sealed Classes** (manejo de estados)
4. **Corrutinas** (programación asíncrona)
5. **Ejemplo Integrado** (aplicación práctica)

¡Cada archivo es independiente y contiene comentarios detallados!
