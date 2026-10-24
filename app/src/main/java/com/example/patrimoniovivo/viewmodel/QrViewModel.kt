
package com.example.patrimoniovivo.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class QrViewModel : ViewModel() {

    var codigoVisita by mutableStateOf("")
    var templosIds by mutableStateOf<List<Int>>(emptyList())
    var alertaQr by mutableStateOf(false)

    fun validarQr(contenido: String): Boolean {
        val partes = contenido.trim().split(";")

        if (partes.size != 3 || partes[0] != "PV") {
            alertaQr = true
            return false
        }

        val textoIds = partes[2].split(",")
        val ids = textoIds.mapNotNull { it.trim().toIntOrNull() }

        if (ids.isEmpty() || ids.size != textoIds.size) {
            alertaQr = true
            return false
        }

        codigoVisita = partes[1]
        templosIds = ids
        alertaQr = false
        return true
    }

    fun guardarQR(contenido: String) {}
}