package com.example.patrimoniovivo.model



enum class EstadoRecinto { ABIERTO, CERRADO, EN_CELEBRACION }

data class Recinto(
    val id: Int,
    val nombre: String,
    val direccion: String,
    val latitud: Double,
    val longitud: Double,
    val descripcion: String,
    val estado: EstadoRecinto
)