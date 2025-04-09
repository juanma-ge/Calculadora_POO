package org.example.operacion

class Calculadora(

    val scanner: Scanner

): Operar {

    fun iniciar() {
        var continuar = true

        while (continuar) {
            println("Introduce el primer número: ")
            val num1 = readln().toDouble()

            println("Introduce el operador (+, -, *, /): ")
            val operador = readln()[0]

            println("Introduce el segundo número:")
            val num2 = readln().toDouble()

            val resultado = calcular(num1, num2, operador)

            if (resultado != null) {
                println("Resultado: $resultado")
            }

            println("\n¿Quieres hacer otra operación? (s/n)")
            continuar = readln() == "s"
        }

        println("¡Adiós!")
    }

    override fun calcular(a: Double, b: Double, operador: Char): Double? {
        return when (operador) {
            '+' -> a + b
            '-' -> a - b
            '*' -> a * b
            '/' -> {
                if (b == 0.0) {
                    println("Error: No se puede dividir por cero")
                    null
                } else {
                    a / b
                }
            }
            else -> {
                println("Error: Operador no válido")
                null
            }
        }
    }
}
