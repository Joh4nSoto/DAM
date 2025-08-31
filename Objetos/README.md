# 🏗️ Programación Orientada a Objetos

Ejemplos de POO en Kotlin: clases, objetos, herencia y encapsulamiento.

## 📁 Estructura

### 🎮 **Pokemon/**
Ejemplos progresivos con el sistema de combate Pokemon:

#### **Básico/** 
- `pokemon.kt`: Clases básicas y instanciación
- Conceptos: propiedades, métodos, constructores

#### **Avanzado/**
- `pokemon_avanzado.kt`: Herencia y polimorfismo
- Clases especializadas: TipoFuego, TipoAgua, etc.
- Sistema de combate completo

### 🚗 **Ejemplos Adicionales**
- `objeto_basico.kt`: Introducción a objetos
- `herencia.kt`: Herencia con Vehículo → Auto/Moto
- `encapsulamiento.kt`: Modificadores de acceso

## 🎯 Conceptos Cubiertos

### 1. **Clases y Objetos Básicos**
```kotlin
class Pokemon(val nombre: String, var hp: Int) {
    fun atacar() {
        println("$nombre ataca!")
    }
}

val pikachu = Pokemon("Pikachu", 100)
```

### 2. **Herencia**
```kotlin
open class Vehiculo(val marca: String)

class Auto(marca: String, val puertas: Int) : Vehiculo(marca)
```

### 3. **Encapsulamiento**
```kotlin
class CuentaBancaria(
    public val titular: String,     // Acceso público
    private var saldo: Double,      // Acceso privado
    protected val numero: String,   // Solo subclases
    internal val banco: String      // Solo este módulo
)
```

### 4. **Polimorfismo**
- Sobrescritura de métodos (`override`)
- Clases y métodos abiertos (`open`)
- Implementaciones específicas por tipo

## 🎮 Ruta de Aprendizaje Pokemon

### **Nivel 1: Básico** 🟢
1. Ejecuta `pokemon.kt` 
2. Entiende clases, propiedades y métodos
3. Experimenta creando diferentes Pokemon

### **Nivel 2: Avanzado** 🔥
1. Estudia `pokemon_avanzado.kt`
2. Observa cómo cada tipo tiene habilidades únicas
3. Modifica el sistema de combate

### **Nivel 3: Maestro** ⚡
1. Agrega nuevos tipos de Pokemon
2. Implementa sistema de experiencia
3. Crea torneos de combate

## 🚀 Ejercicios Prácticos

### **Ejercicio 1: Extender Pokemon**
- Agrega tipo Eléctrico con habilidad "Rayo"
- Implementa sistema de efectividad de tipos
- Crea evoluciones de Pokemon

### **Ejercicio 2: Sistema de Vehículos**
- Extiende con Camión y Bicicleta
- Agrega consumo de combustible
- Implementa sistema de mantenimiento

### **Ejercicio 3: Banco Seguro**
- Agrega diferentes tipos de cuenta
- Implementa historial de transacciones
- Crea sistema de autenticación

## 💡 Conceptos Clave para Mobile

En desarrollo mobile, estos conceptos son esenciales:

- **Encapsulamiento**: Protege datos sensibles de la app
- **Herencia**: Reutiliza código entre Activities/Fragments
- **Polimorfismo**: Diferentes comportamientos según el dispositivo
- **Abstracción**: Simplifica interfaces complejas

## 🔍 Archivos Recomendados

| Archivo | Dificultad | Conceptos |
|---------|------------|-----------|
| `objeto_basico.kt` | 🟢 Fácil | Clases básicas |
| `herencia.kt` | 🟡 Medio | Herencia simple |
| `pokemon.kt` | 🟡 Medio | POO aplicada |
| `encapsulamiento.kt` | 🔴 Avanzado | Modificadores acceso |
| `pokemon_avanzado.kt` | 🔴 Avanzado | Sistema completo |

## 🎓 Para el Examen

Asegúrate de entender:
1. **Diferencia** entre `val` y `var`
2. **Cuándo usar** cada modificador de acceso
3. **Cómo implementar** herencia correctamente
4. **Pattern matching** con `when`

---
*Programación Orientada a Objetos - Desarrollo Mobile DuocUC*
