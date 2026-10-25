package com.example.patrimoniovivo.model

data class Pregunta(
    val id: Int,
    val temploId: Int,
    val enunciado: String,
    val opciones: List<String>,
    val correcta: Int
)

data class Mision(
    val id: Int,
    val temploId: Int,
    val descripcion: String,
    val puntos: Int
)