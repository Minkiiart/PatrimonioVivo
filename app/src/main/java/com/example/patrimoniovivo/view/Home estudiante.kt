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
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.patrimoniovivo.model.EstadoRecinto
import com.example.patrimoniovivo.viewmodel.RecintoViewModel

fun colorDeEstado(estado: EstadoRecinto): Color {
    return when (estado) {
        EstadoRecinto.ABIERTO, EstadoRecinto.EN_CELEBRACION -> Color(0xFF2E7D32)
        EstadoRecinto.CERRADO -> Color(0xFFC62828)
    }
}

@Composable
fun HomeEstudiante(
    navController: NavController,
    codigo: String,
    templosIds: List<Int>,
    recintoViewModel: RecintoViewModel = viewModel()
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
        items(templos) { recinto ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
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
                }
            }
        }
    }


}