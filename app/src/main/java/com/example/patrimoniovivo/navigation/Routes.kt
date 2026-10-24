package com.example.patrimoniovivo.navigation

object Routes {


    const val LoginEstudiante = "loginestudiante"
    const val HOME = "home"
    const val LOGINTURISTA = "loginTurista"
    const val HOMETRABAJADOR = "hometrabajador"
    const val LoginTrabajador = "logintrabajador"
    const val HomeTrabajador = "hometrabajador"
    const val HomeTurista = "hometurista"
    const val EscanearQr = "escanearqr"
    const val HomeEstudiante = "home_estudiante/{codigo}/{ids}"
    fun homeEstudiante(codigo: String, ids: List<Int>) = "home_estudiante/$codigo/${ids.joinToString("-")}"


}