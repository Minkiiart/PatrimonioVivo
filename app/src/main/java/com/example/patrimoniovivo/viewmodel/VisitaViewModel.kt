package com.example.patrimoniovivo.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.patrimoniovivo.model.Visita

class VisitaViewModel : ViewModel() {
    var colegio by mutableStateOf("")
    var fecha by mutableStateOf("")
    var hora by mutableStateOf("")
    var cantidadAlumnos by mutableStateOf("")
    var requiereGuia by mutableStateOf(false)

    var visitaCreada by mutableStateOf<Visita?>(null)
    var alertaError by mutableStateOf(false)
    val templosSeleccionados = mutableStateListOf<Int>()


    fun alternarTemplo(id: Int) {
        if (templosSeleccionados.contains(id)) {
            templosSeleccionados.remove(id)
        } else {
            templosSeleccionados.add(id)
        }
    }

    fun agendar(): Boolean {
        val cantidad = cantidadAlumnos.toIntOrNull()

        if (colegio.isBlank() || fecha.isBlank() || hora.isBlank() ||
            cantidad == null || cantidad <= 0 || templosSeleccionados.isEmpty()
        ) {
            alertaError = true
            return false
        }

        alertaError = false
        visitaCreada = Visita(
            codigo = "V" + (1000..9999).random(),
            colegio = colegio,
            fecha = fecha,
            hora = hora,
            cantidadAlumnos = cantidad,
            requiereGuia = requiereGuia,
            templosIds = templosSeleccionados.toList()
        )
        return true
    }

    fun contenidoQr(): String {
        val v = visitaCreada ?: return ""
        return "PV;${v.codigo};${v.templosIds.joinToString(",")}"
    }

}