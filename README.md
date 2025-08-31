
# 📱 Kotlin para Desarrollo Mobile - DuocUC

Repositorio de ejemplos de Kotlin para el curso de **Desarrollo de Aplicaciones Mobile** del DuocUC.

## 🎯 Descripción

Este repositorio contiene ejemplos prácticos de Kotlin organizados por temas, diseñados para aprender los conceptos fundamentales del lenguaje de programación Kotlin aplicado al desarrollo mobile.

## 🚀 Cómo ejecutar los ejemplos

Los ejemplos pueden ejecutarse de varias formas:

### **Opción 1: Kotlin Playground (Recomendado) 🌐**
1. Ve a [https://play.kotlinlang.org/](https://play.kotlinlang.org/)
2. Copia el código de cualquier archivo `.kt`
3. Pégalo en el editor online
4. Presiona **Run** para ejecutar

### **Opción 2: Android Studio / IntelliJ IDEA**
1. Abre el proyecto en tu IDE
2. Ejecuta directamente los archivos `.kt`

### **Opción 3: Línea de comandos**
```bash
kotlinc archivo.kt -include-runtime -d output.jar
java -jar output.jar
```

## 📚 Estructura del Repositorio

### 🟢 **Conceptos Básicos**
Fundamentos del lenguaje Kotlin:
- Declaración de variables (`val`, `var`)
- Tipos de datos básicos
- Condicionales (`if`, `when`)
- Funciones básicas
- Entrada y salida de datos

### 🔄 **Ciclos**
Estructuras de control iterativas:
- **FOR**: Iteración con rangos, listas y arrays
- **WHILE**: Bucles condicionales
- **DO-WHILE**: Bucles que se ejecutan al menos una vez

### 📦 **Colecciones**
Estructuras de datos fundamentales:
- **List**: Listas ordenadas (mutables e inmutables)
- **Set**: Conjuntos únicos sin duplicados
- **Map**: Mapas clave-valor (diccionarios)
- Operaciones comunes: filtrado, mapeo, reducción

### 🏗️ **Objetos** 
Programación Orientada a Objetos:
- **Pokemon/Básico**: Clases básicas y objetos
- **Pokemon/Avanzado**: Herencia y polimorfismo
- **Encapsulamiento**: Modificadores de acceso
- **Herencia**: Clases padre e hijas

### ⚡ **Corrutinas**
Programación asíncrona y conceptos avanzados:
- **Data Classes**: Clases de datos automáticas
- **Sealed Classes**: Jerarquías cerradas de tipos
- **Scope Functions**: `apply`, `let`, `run`, `with`, `also`
- **Corrutinas**: `suspend fun`, `launch`, `async`, `await`
- **Ejemplo Integrado**: Aplicación completa

### 🛡️ **Control de Errores**
Manejo de excepciones:
- **Try-Catch-Finally**: Captura y manejo de errores
- Validación de entradas
- Recuperación de errores

## 📝 Ejemplos Destacados

```kotlin
// Data Class (automática)
data class Usuario(val nombre: String, val edad: Int)

// Sealed Class (estados seguros)
sealed class Estado {
    object Cargando : Estado()
    data class Exito(val data: String) : Estado()
    data class Error(val mensaje: String) : Estado()
}

// Corrutina básica
suspend fun operacionAsincrona() {
    delay(1000)
    println("¡Operación completada!")
}
```

## 🎓 Objetivos de Aprendizaje

Al completar estos ejemplos, los estudiantes podrán:

- ✅ Dominar la sintaxis básica de Kotlin
- ✅ Implementar POO con clases, herencia y encapsulamiento
- ✅ Trabajar con colecciones de datos eficientemente
- ✅ Usar programación asíncrona con corrutinas
- ✅ Manejar errores de forma robusta
- ✅ Aplicar buenas prácticas de código limpio

## 🛠️ Requisitos

- **Kotlin 1.9+**
- **JDK 11+** (para ejecución local)
- **Navegador web** (para Kotlin Playground)

## 📖 Cómo estudiar

1. **Comienza con Conceptos Básicos** 🟢
2. **Practica con Ciclos y Colecciones** 🔄📦
3. **Aprende POO con Objetos** 🏗️
4. **Domina Corrutinas** ⚡
5. **Implementa Control de Errores** 🛡️

## 👨‍🏫 Autor

**Profesor Álvaro Maurelia**  
📧 Email: [al.maurelia@profesor.duoc.cl](mailto:al.maurelia@profesor.duoc.cl)  
🏫 DuocUC - Desarrollo de Aplicaciones Mobile

---

## 📄 Licencia

Este proyecto es de uso educativo para el curso de Desarrollo Mobile del DuocUC.

## 🤝 Contribuciones

Este repositorio es mantenido por el profesor del curso. Para dudas o sugerencias, contactar por email.

---

*Última actualización: Agosto 2025*