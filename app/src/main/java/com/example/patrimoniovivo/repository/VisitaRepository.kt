package com.example.patrimoniovivo.repository

import androidx.compose.runtime.mutableStateListOf
import com.example.patrimoniovivo.model.Visita

class VisitaRepository {

    companion object {
        private val visitas = mutableStateListOf<Visita>()
    }

    fun agregar(visita: Visita) {
        visitas.add(visita)
    }

    fun obtenerPorRecinto(recintoId: Int): List<Visita> {
        return visitas.filter { it.templosIds.contains(recintoId) }
    }
}