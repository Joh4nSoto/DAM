// Ejemplo de Encapsulamiento en Kotlin
// Demostramos los diferentes modificadores de acceso

open class CuentaBancaria(
    public val titular: String,           // public (por defecto) - accesible desde cualquier lugar
    private var saldo: Double,            // private - solo accesible dentro de esta clase
    protected var numeroCuenta: String,   // protected - accesible en esta clase y subclases
    internal val banco: String            // internal - accesible solo en este módulo
) {
    
    // Método público para consultar saldo (getter seguro)
    fun consultarSaldo(): Double {
        return saldo
    }
    
    // Método público para depositar dinero
    fun depositar(cantidad: Double): Boolean {
        return if (cantidad > 0) {
            saldo += cantidad
            println("Depósito exitoso. Nuevo saldo: $$saldo")
            true
        } else {
            println("Error: La cantidad debe ser positiva")
            false
        }
    }
    
    // Método público para retirar dinero
    fun retirar(cantidad: Double): Boolean {
        return if (validarRetiro(cantidad)) {
            saldo -= cantidad
            println("Retiro exitoso. Nuevo saldo: $$saldo")
            true
        } else {
            false
        }
    }
    
    // Método PRIVATE - solo accesible dentro de esta clase
    private fun validarRetiro(cantidad: Double): Boolean {
        return when {
            cantidad <= 0 -> {
                println("Error: La cantidad debe ser positiva")
                false
            }
            cantidad > saldo -> {
                println("Error: Saldo insuficiente")
                false
            }
            cantidad > limiteDiario() -> {
                println("Error: Excede el límite diario")
                false
            }
            else -> true
        }
    }
    
    // Método PRIVATE - lógica interna de negocio
    private fun limiteDiario(): Double = 1000.0
    
    // Método PROTECTED - accesible en subclases
    protected fun generarReporte(): String {
        return "Cuenta: $numeroCuenta | Titular: $titular | Saldo: $$saldo"
    }
    
    // Método público que muestra información básica
    fun mostrarInfo() {
        println("Titular: $titular")
        println("Banco: $banco")
        println("Saldo disponible: $$saldo")
    }
}

// Clase que hereda de CuentaBancaria
class CuentaAhorro(
    titular: String,
    saldoInicial: Double,
    numeroCuenta: String,
    banco: String,
    private val tasaInteres: Double  // Propiedad específica de CuentaAhorro
) : CuentaBancaria(titular, saldoInicial, numeroCuenta, banco) {
    
    fun aplicarInteres() {
        val interes = consultarSaldo() * tasaInteres / 100
        depositar(interes)
        println("Interés aplicado: $$interes")
    }
    
    // Puede acceder a método PROTECTED de la clase padre
    fun generarReporteDetallado() {
        val reporteBase = generarReporte() // Accesible porque es protected
        println("$reporteBase | Tasa de interés: $tasaInteres%")
    }
    
    // No puede acceder a propiedades/métodos PRIVATE de la clase padre
    /*
    fun intentoAccesoPrivado() {
        // Esto NO funcionaría:
        // val limite = limiteDiario()  // Error: limiteDiario() es private
        // saldo += 100                 // Error: saldo es private
    }
    */
}

fun main() {
    println("=== EJEMPLO DE ENCAPSULAMIENTO ===\n")
    
    // Creamos una cuenta básica
    val cuenta1 = CuentaBancaria("Juan Pérez", 500.0, "123456", "Banco Nacional")
    
    println("--- CUENTA BÁSICA ---")
    cuenta1.mostrarInfo()
    
    // Podemos acceder a propiedades/métodos PUBLIC
    println("Titular: ${cuenta1.titular}")  // public por defecto
    println("Banco: ${cuenta1.banco}")      // internal (accesible en el mismo módulo)
    
    // Podemos usar métodos públicos
    cuenta1.depositar(200.0)
    cuenta1.retirar(100.0)
    println("Saldo actual: $${cuenta1.consultarSaldo()}")
    
    // NO podemos acceder a propiedades/métodos PRIVATE
    /*
    println(cuenta1.saldo)           // Error: saldo es private
    cuenta1.validarRetiro(50.0)      // Error: validarRetiro es private
    */
    
    // NO podemos acceder a propiedades PROTECTED desde fuera de la clase
    /*
    println(cuenta1.numeroCuenta)    // Error: numeroCuenta es protected
    cuenta1.generarReporte()         // Error: generarReporte es protected
    */
    
    println("\n--- CUENTA DE AHORRO ---")
    
    // Creamos una cuenta de ahorro (subclase)
    val cuentaAhorro = CuentaAhorro("María García", 1000.0, "789012", "Banco Nacional", 2.5)
    
    cuentaAhorro.mostrarInfo()
    cuentaAhorro.aplicarInteres()
    cuentaAhorro.generarReporteDetallado() // Puede acceder a método protected
    
    println("\n=== RESUMEN DE MODIFICADORES ===")
    println("• PUBLIC: titular, banco, consultarSaldo(), depositar(), etc.")
    println("• PRIVATE: saldo, validarRetiro(), limiteDiario()")
    println("• PROTECTED: numeroCuenta, generarReporte()")
    println("• INTERNAL: banco")
}
