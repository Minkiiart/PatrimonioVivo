package com.example.patrimoniovivo.model

fun telefonoValido(telefono: String, esExtranjero: Boolean): Boolean {
    val limpio = telefono.replace(" ", "").replace("-", "")

    if (esExtranjero) {
        val digitos = limpio.removePrefix("+")
        return digitos.length in 8..15 && digitos.all { it.isDigit() }
    }

    var digitos = limpio.removePrefix("+")
    if (digitos.startsWith("56")) digitos = digitos.removePrefix("56")
    return digitos.length == 9 && digitos.startsWith("9") && digitos.all { it.isDigit() }
}