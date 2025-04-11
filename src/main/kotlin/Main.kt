import app.Calculadora
import app.Log
import app.InfoCalcException
import model.Operadores
import ui.Consola

fun main(args: Array<String>) {
    when (args.size) {
        0 -> manejarSinArgumentos()
        1 -> manejarUnArgumento(args[0])
        4 -> manejarCuatroArgumentos(args[0], args[1], args[2], args[3])
        else -> {
            println("Error: Número incorrecto de argumentos. Usos válidos:")
            println("1. Sin argumentos (usa ./log como directorio)")
            println("2. Un argumento (ruta de logs)")
            println("3. Cuatro argumentos (ruta num1 operador num2)")
            return
        }
    }

    Calculadora(Consola()).iniciar()
}

private fun manejarSinArgumentos() {
}

private fun manejarUnArgumento(ruta: String) {
}

private fun manejarCuatroArgumentos(ruta: String, num1Str: String, operadorStr: String, num2Str: String) {
    val logger = Log(ruta)
    val ui = Consola()

    try {
        val num1 = num1Str.toDouble()
        val num2 = num2Str.toDouble()
        val operador = Operadores.getOperador(operadorStr.firstOrNull())
            ?: throw InfoCalcException("Operador no válido")

        val resultado = when (operador) {
            Operadores.SUMA -> num1 + num2
            Operadores.RESTA -> num1 - num2
            Operadores.MULTIPLICACION -> num1 * num2
            Operadores.DIVISION -> num1 / num2
        }

        val resultadoFormateado = "%.2f".format(resultado)
        val operacionStr = "$num1 ${operador.simbolos.first()} $num2"

        println("Resultado: $resultadoFormateado")
        logger.registrarOperacion(operacionStr, resultadoFormateado)
    } catch (e: NumberFormatException) {
        println("Error: Número no válido")
        logger.registrarOperacion("Operación fallida", "Número no válido")
    } catch (e: ArithmeticException) {
        val errorMsg = e.message ?: "Error matemático"
        println("Error: $errorMsg")
        logger.registrarOperacion("Operación fallida", errorMsg)
    } catch (e: Exception) {
        val errorMsg = "Error: ${e.message ?: "desconocido"}"
        println(errorMsg)
        logger.registrarOperacion("Operación fallida", errorMsg)
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