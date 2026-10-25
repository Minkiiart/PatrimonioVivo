package com.example.patrimoniovivo.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.patrimoniovivo.model.correoInstitucional
import com.example.patrimoniovivo.model.correoValido
import com.example.patrimoniovivo.model.pasaporteValido
import com.example.patrimoniovivo.model.rutValido
import com.example.patrimoniovivo.model.telefonoValido

class CrearCuentaViewModel : ViewModel() {

    var esProfesor by mutableStateOf(false)
    var esExtranjero by mutableStateOf(false)

    var nombre by mutableStateOf("")
    var documento by mutableStateOf("")
    var correo by mutableStateOf("")
    var telefono by mutableStateOf("")
    var pass by mutableStateOf("")
    var confirmarPass by mutableStateOf("")

    var mensajeError by mutableStateOf("")

    fun cambiarNacionalidad(extranjero: Boolean) {
        esExtranjero = extranjero
        documento = ""
    }

    fun crearCuenta(): Boolean {
        val documentoValido = if (esExtranjero) pasaporteValido(documento) else rutValido(documento)

        mensajeError = when {
            nombre.isBlank() -> "Ingresa tu nombre"
            !documentoValido -> if (esExtranjero) "Pasaporte inválido" else "RUT inválido"
            !correoValido(correo) -> "Correo inválido"
            esProfesor && !correoInstitucional(correo) ->
                "Los profesores deben usar su correo institucional (no Gmail, Hotmail, etc.)"
            !telefonoValido(telefono, esExtranjero) ->
                if (esExtranjero) "Teléfono inválido (incluye el código de país)" else "Teléfono inválido (ej: 9 1234 5678)"
            pass.length < 6 -> "La contraseña debe tener al menos 6 caracteres"
            pass != confirmarPass -> "Las contraseñas no coinciden"
            else -> ""
        }

        return mensajeError.isEmpty()
    }
}