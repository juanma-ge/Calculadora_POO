package org.example.ui

interface IEntradaSalida {

    fun pedirEntero(a: Int, b: Int)
    fun pedirDouble(a: Double, b: Double)
    fun mostrarError(msj: String)
    fun pausar(msj: String = "Pulse Enter para Continuar...")
    fun limpiarPantalla(numSaltos: Int = 20)

}