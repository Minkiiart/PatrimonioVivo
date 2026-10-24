package com.example.patrimoniovivo.view

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.patrimoniovivo.navigation.Routes
import com.example.patrimoniovivo.viewmodel.QrViewModel
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning

@Composable
fun LoginEstudiante(
    navController: NavController,
    qrViewModel: QrViewModel = viewModel()
) {
    val context = LocalContext.current

    val scanner = remember(context) {
        val opciones = GmsBarcodeScannerOptions.Builder()
            .setBarcodeFormats(Barcode.FORMAT_QR_CODE)
            .build()
        GmsBarcodeScanning.getClient(context, opciones)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(40.dp)
    ) {
        Text(
            text = "Bienvenido estudiante",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "¡Un momento!, Escanea el QR generado con tu profesor para comenzar",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )

        Button(
            onClick = {
                scanner.startScan()
                    .addOnSuccessListener { barcode ->
                        val contenido = barcode.rawValue.orEmpty()
                        if (qrViewModel.validarQr(contenido)) {
                            navController.navigate(
                                Routes.homeEstudiante(qrViewModel.codigoVisita, qrViewModel.templosIds)
                            ) {
                                popUpTo(Routes.LoginEstudiante) { inclusive = true }
                            }
                        }
                    }
                    .addOnFailureListener { error ->
                        Toast.makeText(context, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
                    }
            },
            modifier = Modifier.fillMaxWidth().padding(top = 30.dp)
        ) {
            Text("Escanear QR")
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (qrViewModel.alertaQr) {
            Text(
                text = "Código QR inválido",
                fontSize = 20.sp,
                color = Color.Red
            )
        }
    }
}
