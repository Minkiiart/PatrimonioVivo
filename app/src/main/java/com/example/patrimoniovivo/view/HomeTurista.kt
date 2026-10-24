package com.example.patrimoniovivo.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.patrimoniovivo.model.Recinto
import com.example.patrimoniovivo.viewmodel.RecintoViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.graphics.Color
import com.example.patrimoniovivo.model.EstadoRecinto

@Composable
fun HomeTurista(
    navController: NavController,
    recintoViewModel: RecintoViewModel = viewModel()
) {
    fun colorDeEstado(estado: EstadoRecinto): Color {
        return when (estado) {
            EstadoRecinto.ABIERTO, EstadoRecinto.EN_CELEBRACION -> Color(0xFF2E7D32)
            EstadoRecinto.CERRADO -> Color(0xFFC62828)
        }
    }
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(40.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)

    ) {
        item {
            Text("Recintos patrimoniales", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        }
        items(recintoViewModel.recintos) { recinto ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(recinto.nombre, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                    Text(recinto.direccion)
                    Text("Estado: ${recinto.estado}", color = colorDeEstado(recinto.estado))
                }
            }
        }

    }


}