import app.Calculadora
import ui.Consola

/*
fun main() {
    val scanner = Scanner(System.`in`)

    println("Introduce el primer número:")
    val numero1 = scanner.nextDouble()
    println("Introduce el operador (+, -, *, /):")
    val operador = scanner.next()[0]
    println("Introduce el segundo número:")
    val numero2 = scanner.nextDouble()

    val resultado = when (operador) {
        '+' -> numero1 + numero2
        '-' -> numero1 - numero2
        '*' -> numero1 * numero2
        '/' -> numero1 / numero2
        else -> "Operador no válido"
    }

    println("Resultado: $resultado")
}
*/

fun main() {
    Calculadora(Consola()).iniciar()

    fun manejarSinArgumentos(){

    }

    fun manejarConArgumento(arg: String){

    }

    fun manejarCon4Argumentos(arg: String, num1: String, num2: String, operador: String){




    }

    fun recibirArgumentos(args: Array<String>): String {
        when (args.size) {
            0 -> manejarSinArgumentos()
            1 -> manejarConArgumento(args[0])
            2 -> manejarCon4Argumentos(args[0], args[1], args[2], args[3])
            else -> {
                return "**ERROR**: Número Incorrecto"
            }
        }
    }


}


/*
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    val numLineas = scanner.nextInt()
    scanner.nextLine() // Limpia el salto de línea pendiente

    var resultado = 1

    for (i in 1..numLineas) {
        var suma = 0
        while (scanner.hasNextInt()) {
            suma += scanner.nextInt()
        }
        resultado *= suma
        if (scanner.hasNextLine()) scanner.nextLine() // pasar a la siguiente línea
    }

    println(resultado)
}
*/