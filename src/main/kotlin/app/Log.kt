package app

import java.io.File

class Log(val logDirectory: String) {

    fun verificarOCrearDirectorio(){
        val dir = File(logDirectory)
        if (!dir.exists()){
            dir.mkdirs()
            println("Archivo $logDirectory creado")
        }else{
            return
        }
   }

    fun obtenerLog(): Array<out File>? {
        val dir = File(logDirectory)
        return dir.listFiles()
    }

}