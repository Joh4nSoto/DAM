# 📦 Colecciones en Kotlin

Guía completa de las estructuras de datos más importantes en Kotlin.

## 📋 Tipos de Colecciones

### 📝 **List (Lista)**
Colección **ordenada** que **permite duplicados**

```kotlin
// Inmutable (solo lectura)
val lista = listOf("🍎", "🍌", "🍎")

// Mutable (modificable)
val listaMutable = mutableListOf("🍎", "🍌")
listaMutable.add("🍊")
```

### 🎯 **Set (Conjunto)**
Colección **sin duplicados**, orden no garantizado

```kotlin
// Inmutable
val conjunto = setOf("🍎", "🍌", "🍎") // Solo guarda uno de los 🍎

// Mutable
val conjuntoMutable = mutableSetOf("🍎", "🍌")
conjuntoMutable.add("🍊")
```

### 🗂️ **Map (Mapa/Diccionario)**
Colección de **pares clave-valor**

```kotlin
// Inmutable
val mapa = mapOf("nombre" to "Juan", "edad" to "25")

// Mutable
val mapaMutable = mutableMapOf("nombre" to "Juan")
mapaMutable["edad"] = "25"
```

## 🛠️ Operaciones Comunes

### Transformación
- **map()**: Transforma cada elemento
- **filter()**: Filtra elementos que cumplen condición
- **sorted()**: Ordena la colección

### Agregación
- **reduce()**: Combina elementos en uno solo
- **fold()**: Como reduce pero con valor inicial
- **sum()**, **count()**, **max()**, **min()**

### Búsqueda
- **find()**: Encuentra el primer elemento que cumple condición
- **contains()**: Verifica si contiene un elemento
- **any()**, **all()**, **none()**

## 🎯 Cuándo usar cada una

| Colección | Usar cuando... | Ejemplo |
|-----------|----------------|---------|
| **List** | Necesitas orden y duplicados | Lista de calificaciones |
| **Set** | Necesitas elementos únicos | Lista de usuarios activos |
| **Map** | Necesitas buscar por clave | Configuración de app |

## 📊 Ejemplos Prácticos

### Lista de Estudiantes
```kotlin
val estudiantes = listOf("Ana", "Carlos", "María")
val aprobados = estudiantes.filter { it.length > 4 }
```

### Inventario Único
```kotlin
val productos = setOf("Laptop", "Mouse", "Laptop") // Solo uno
val disponibles = productos.filter { inventario.contains(it) }
```

### Configuración de App
```kotlin
val config = mapOf(
    "tema" to "oscuro",
    "idioma" to "español",
    "notificaciones" to "activas"
)
```

## 🚀 Ejercicios Sugeridos

1. **Lista**: Crea una lista de tus películas favoritas y filtra por año
2. **Set**: Haz un conjunto de tags únicos para posts
3. **Map**: Crea un diccionario de traducciones español-inglés
4. **Combinado**: Usa las tres colecciones en un sistema de biblioteca

## 💡 Tips Importantes

- 🔒 **Inmutables** por defecto (más seguro)
- 🔧 **Mutables** solo cuando necesites modificar
- ⚡ **Funciones de orden superior** hacen el código más elegante
- 📱 **Fundamentales** para desarrollo mobile

---
*Parte del curso de Desarrollo Mobile - DuocUC*
