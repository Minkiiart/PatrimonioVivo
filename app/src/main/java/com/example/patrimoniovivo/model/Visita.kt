package com.example.patrimoniovivo.model

data class Visita(
    val codigo: String,
    val colegio: String,
    val fecha: String,
    val hora: String,
    val cantidadAlumnos: Int,
    val requiereGuia: Boolean,
    val templosIds: List<Int>
)

