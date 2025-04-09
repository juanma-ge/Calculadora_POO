package app

import model.Operadores
import ui.IEntradaSalida

class Calculadora(private val ui: IEntradaSalida){

    private fun pedirNumero(msj: String, msjError: String = "Número no válido!"): Double {
        return ui.pedirDouble(msj) ?: throw InfoCalcException(msjError)
    }

    private fun pedirInfo(): Triple<Double, Operadores, Double> {
        val numero1 = pedirNumero("Introduce el primer número: ", "El primer número no es válido!")
        val operador = Operadores.getOperador(ui.pedirInfo("Introduce el operador (+, -, *, /): ").firstOrNull())
            ?: throw InfoCalcException("El operador no es válido!")
        val numero2 = pedirNumero("Introduce el segundo número: ", "El segundo número no es válido!")
        return Triple(numero1, operador, numero2)
    }

    private fun realizarCalculo(numero1: Double, operador: Operadores, numero2: Double) =
        when (operador) {
            Operadores.SUMA -> numero1 + numero2
            Operadores.RESTA -> numero1 - numero2
            Operadores.MULTIPLICACION -> numero1 * numero2
            Operadores.DIVISION -> numero1 / numero2
        }

    fun iniciar() {
        do {
            try {
                ui.limpiarPantalla()
                val (numero1, operador, numero2) = pedirInfo()
                val resultado = realizarCalculo(numero1, operador, numero2)
                ui.mostrar("Resultado: %.2f".format(resultado))
            } catch (e: NumberFormatException) {
                ui.mostrarError(e.message ?: "Se ha producido un error!")
            }catch (e: IllegalArgumentException){
                throw e
            }catch (e: IllegalArgumentException){
                throw e
            }catch (e: IllegalArgumentException){
                throw e
            }
        } while (ui.preguntar())
        ui.limpiarPantalla()
    }

}