package com.example.patrimoniovivo.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.patrimoniovivo.model.Usuario

class LoginTuristaViewModel: ViewModel() {

    var mail by mutableStateOf("")
    var pass by mutableStateOf("")

    var alertaCredencial by mutableStateOf(false)

    fun cambiarPass (NuevaPass : String){
        pass = NuevaPass
    }

    fun cambiarMail (NuevoMail : String) {
        mail = NuevoMail
    }

    val usuariocorrecto = Usuario("Turista@gmail.com","1234")

    fun login(): Boolean {
        var validador = false

        if (mail == usuariocorrecto.mail && pass == usuariocorrecto.pass) {
            validador = true
        }
return validador

}
}