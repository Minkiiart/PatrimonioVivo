package com.example.patrimoniovivo.repository

import androidx.compose.runtime.mutableStateListOf
import com.example.patrimoniovivo.model.EstadoRecinto
import com.example.patrimoniovivo.model.Recinto

class RecintoRepository {

    companion object {
        private val recintos = mutableStateListOf(
            Recinto(1, "Catedral Metropolitana", "Plaza de Armas s/n", -33.4372, -70.6506, "Descripción histórica...", EstadoRecinto.ABIERTO),
            Recinto(2, "Iglesia de San Francisco", "Av. Libertador Bernardo O'Higgins 834", -33.4443, -70.6498, "Descripción histórica...", EstadoRecinto.ABIERTO),
            Recinto(3, "Basílica de la Merced", "Enrique Mac Iver 341 (esquina Merced)", -33.4388, -70.6479, "Descripción histórica...", EstadoRecinto.EN_CELEBRACION),
            Recinto(4, "Iglesia de los Sacramentinos", "Santa Isabel 1127 (esquina Arturo Prat)", -33.4465, -70.6359, "Descripción histórica...", EstadoRecinto.CERRADO)
        )
    }

    fun obtenerTodos(): List<Recinto> {
        return recintos
    }

    fun buscarPorId(id: Int): Recinto? {
        return recintos.find { it.id == id }
    }

    fun cambiarEstado(id: Int, nuevoEstado: EstadoRecinto) {
        val indice = recintos.indexOfFirst { it.id == id }
        if (indice != -1) {
            recintos[indice] = recintos[indice].copy(estado = nuevoEstado)
        }
    }
}
