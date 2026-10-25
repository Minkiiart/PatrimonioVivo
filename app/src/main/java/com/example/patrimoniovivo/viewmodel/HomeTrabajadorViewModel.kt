package com.example.patrimoniovivo.viewmodel

import androidx.lifecycle.ViewModel
import com.example.patrimoniovivo.model.EstadoRecinto
import com.example.patrimoniovivo.model.Recinto
import com.example.patrimoniovivo.model.Visita
import com.example.patrimoniovivo.repository.RecintoRepository
import com.example.patrimoniovivo.repository.VisitaRepository

class HomeTrabajadorViewModel : ViewModel() {

    private val recintoRepository = RecintoRepository()
    private val visitaRepository = VisitaRepository()

    private val recintoId = 1

    val recinto: Recinto?
        get() = recintoRepository.buscarPorId(recintoId)

    val visitasDelRecinto: List<Visita>
        get() = visitaRepository.obtenerPorRecinto(recintoId)

    fun cambiarEstado(nuevoEstado: EstadoRecinto) {
        recintoRepository.cambiarEstado(recintoId, nuevoEstado)
    }
}