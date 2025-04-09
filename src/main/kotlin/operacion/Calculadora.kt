package org.example.operacion

class Calculadora(

    val scanner: Scanner

): Operar {

    fun iniciar(){
        do {
            scanner.pedirDatos()
        }while (true)
    }

    override fun calcular(a: Double, b: Double, operador: Operador): Double {
        return try {
            when (operador) {
                Operador.SUMA -> a + b
                Operador.RESTA -> a - b
                Operador.MULTIPLICACION -> a * b
                Operador.DIVISION -> {
                    if (b == 0.0) throw ArithmeticException("No se puede dividir por cero")
                    a / b
                }
                else -> throw IllegalArgumentException("Operador no válido")
            }
        }catch (e: ArithmeticException){
            throw e
        }
    }


}