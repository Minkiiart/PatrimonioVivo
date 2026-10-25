package com.example.patrimoniovivo.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.patrimoniovivo.viewmodel.HomeEstudianteViewModel
import com.example.patrimoniovivo.viewmodel.RecintoViewModel

@Composable
fun HomeEstudiante(
    navController: NavController,
    codigo: String,
    templosIds: List<Int>,
    recintoViewModel: RecintoViewModel = viewModel(),
    estudianteViewModel: HomeEstudianteViewModel = viewModel()
) {
    val templos = recintoViewModel.recintos.filter { templosIds.contains(it.id) }

    LazyColumn(
        modifier = Modifier.fillMaxSize().statusBarsPadding().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text("Tu visita", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        }
        item {
            Text("Código: $codigo")
        }
        item {
            Card(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "⭐ Puntos: ${estudianteViewModel.puntos}",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        items(templos) { recinto ->
            val pregunta = estudianteViewModel.preguntas.find { it.temploId == recinto.id }
            val mision = estudianteViewModel.misiones.find { it.temploId == recinto.id }

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(recinto.nombre, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                    Text(recinto.direccion)
                    Row {
                        Text("Estado: ")
                        Text(
                            text = recinto.estado.name,
                            color = colorDeEstado(recinto.estado),
                            fontWeight = FontWeight.Bold
                        )
                    }

                    if (pregunta != null) {
                        val elegida = estudianteViewModel.respuestas[pregunta.id]

                        Text("Trivia", fontWeight = FontWeight.Bold)
                        Text(pregunta.enunciado)

                        pregunta.opciones.forEachIndexed { indice, texto ->
                            OutlinedButton(
                                onClick = { estudianteViewModel.responder(pregunta, indice) },
                                enabled = elegida == null,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(texto)
                            }
                        }

                        if (elegida != null) {
                            if (elegida == pregunta.correcta) {
                                Text("¡Correcto! +50 puntos", color = Color(0xFF2E7D32))
                            } else {
                                Text(
                                    "Incorrecto. La respuesta era: ${pregunta.opciones[pregunta.correcta]}",
                                    color = Color(0xFFC62828)
                                )
                            }
                        }
                    }

                    if (mision != null) {
                        val completada = estudianteViewModel.misionesCompletadas.contains(mision.id)

                        Text("Misión", fontWeight = FontWeight.Bold)
                        Text(mision.descripcion)
                        Button(
                            onClick = { estudianteViewModel.completarMision(mision) },
                            enabled = !completada,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                if (completada) "Misión cumplida ✓"
                                else "Completar misión (+${mision.puntos} pts)"
                            )
                        }
                    }
                }
            }
        }
    }
}