package org.example.operacion

import java.util.Scanner

class Scanner {

    val scanner = Scanner(System.`in`)

    public fun pedirDatos(){
        println("Introduce el primer número:")
        val numero1 = scanner.nextDouble()
        println("Introduce el operador (+, -, *, /):")
        val operador = scanner.next()[0]
        println("Introduce el segundo número:")
        val numero2 = scanner.nextDouble()

    }


}