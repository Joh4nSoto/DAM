class Pokemon(
	val nombre: String,
    var hp: Int,
    var atk: Int
){
    fun info(){
        println("$nombre | HP:$hp ATK:$atk")
    }
    // creamos la función para recibir daño (si su hp es igual a cero el pkmn es derrotado)
    fun recibeDano(dano: Int) {
        println("$nombre recibe $dano de daño")
        hp -= dano
        if (hp < 0){
            hp = 0
            println("$nombre ha sido derrotado")
        }
    }
}

fun main() {
    println("Comienza la batalla Pokemon")

    val char = Pokemon("charmander", 100, 40)
    val mewt = Pokemon("mewtwo", 200, 110)
    char.info() 
    mewt.info()

    // los pkmns comienzan a hacerse daño
    mewt.recibeDano(char.atk)
    char.recibeDano(mewt.atk)
}