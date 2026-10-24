package com.example.patrimoniovivo.viewmodel

import androidx.lifecycle.ViewModel
import com.example.patrimoniovivo.model.EstadoRecinto
import com.example.patrimoniovivo.model.Recinto

class RecintoViewModel : ViewModel() {

    val recintos = listOf(
        Recinto(1, "Catedral Metropolitana", "Plaza de Armas s/n", -33.4372, -70.6506, "Descripción histórica...", EstadoRecinto.ABIERTO),
        Recinto(2, "Iglesia de San Francisco", "Av. Libertador Bernardo O'Higgins 834", -33.4443, -70.6498, "Descripción histórica...", EstadoRecinto.ABIERTO),
        Recinto(3, "Basílica de la Merced", "Merced 341", -33.4388, -70.6479, "Descripción histórica...", EstadoRecinto.EN_CELEBRACION),
        Recinto(4, "Iglesia de los Sacramentinos", "Av. Santa Isabel 255", -33.4465, -70.6359, "Descripción histórica...", EstadoRecinto.CERRADO)
    )
}