package com.example.patrimoniovivo.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.patrimoniovivo.model.Mision
import com.example.patrimoniovivo.model.Pregunta

class HomeEstudianteViewModel : ViewModel() {

    val preguntas = listOf(
        Pregunta(1, 1, "¿En qué plaza está la Catedral Metropolitana?",
            listOf("Plaza de Armas", "Plaza Italia", "Plaza Brasil"), 0),
        Pregunta(2, 2, "¿En qué avenida está la Iglesia de San Francisco?",
            listOf("Av. Providencia", "Av. Libertador Bernardo O'Higgins", "Av. Vicuña Mackenna"), 1),
        Pregunta(3, 3, "¿En qué calle está la Basílica de la Merced?",
            listOf("Bandera", "Huérfanos", "Merced"), 2),
        Pregunta(4, 4, "¿En qué avenida está la Iglesia de los Sacramentinos?",
            listOf("Av. Santa Isabel", "Av. Grecia", "Av. Macul"), 0)
    )

    val misiones = listOf(
        Mision(1, 1, "Encuentra la puerta principal y toma una foto", 100),
        Mision(2, 2, "Cuenta cuántas torres tiene la fachada", 100),
        Mision(3, 3, "Busca el nombre del templo escrito en la entrada", 100),
        Mision(4, 4, "Pregúntale al guía por la historia del templo", 150)
    )

    var puntos by mutableStateOf(0)
    val respuestas = mutableStateMapOf<Int, Int>()
    val misionesCompletadas = mutableStateListOf<Int>()

    fun responder(pregunta: Pregunta, opcion: Int) {
        if (respuestas.containsKey(pregunta.id)) return

        respuestas[pregunta.id] = opcion
        if (opcion == pregunta.correcta) {
            puntos += 50
        }
    }

    fun completarMision(mision: Mision) {
        if (misionesCompletadas.contains(mision.id)) return

        misionesCompletadas.add(mision.id)
        puntos += mision.puntos
    }
}