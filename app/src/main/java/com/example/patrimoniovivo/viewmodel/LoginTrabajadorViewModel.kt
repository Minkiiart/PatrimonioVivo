package com.example.patrimoniovivo.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.patrimoniovivo.model.Usuario

class LoginTrabajadorViewModel : ViewModel() {

    var mailTrabajador by mutableStateOf("")
    var passTrabajador by mutableStateOf("")

    var alertaCredencialTrabajador by mutableStateOf(false)

    fun cambiarPassTrabajador(nuevaPass: String) {
        passTrabajador = nuevaPass
    }

    fun cambiarMail(nuevoMail: String) {
        mailTrabajador = nuevoMail
    }

    val usuariocorrecto = Usuario("Admin@gmail.com", "1234")

    fun loginTrabajador(): Boolean {
        return mailTrabajador.trim().equals(usuariocorrecto.mail, ignoreCase = true) &&
                passTrabajador == usuariocorrecto.pass
    }
}