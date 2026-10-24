package com.example.patrimoniovivo.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.patrimoniovivo.navigation.Routes
import com.example.patrimoniovivo.viewmodel.LoginTuristaViewModel

@Composable
fun LoginTurista(
    navController: NavController,
    loginTuristaViewModel: LoginTuristaViewModel = viewModel()
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(30.dp)
    ) {
        Text(
            text = "Portal Turistas",
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Inicia Sesión",
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold
        )

        OutlinedTextField(
            value = loginTuristaViewModel.mail,
            onValueChange = { loginTuristaViewModel.cambiarMail(it) },
            label = { Text("Correo electronico") },
            modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
        )

        OutlinedTextField(
            value = loginTuristaViewModel.pass,
            onValueChange = { loginTuristaViewModel.cambiarPass(it) },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        Button(
            onClick = {
                val validador = loginTuristaViewModel.login()

                if (validador) {
                    loginTuristaViewModel.alertaCredencial = false
                    navController.navigate(Routes.HomeTurista) {
                        popUpTo(Routes.LOGINTURISTA) { inclusive = true }
                    }
                } else {
                    loginTuristaViewModel.alertaCredencial = true
                }
            },
            modifier = Modifier.fillMaxWidth().padding(top = 30.dp)
        ) {
            Text(text = "Ingresar")
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (loginTuristaViewModel.alertaCredencial) {
            Text(
                text = "Credenciales Invalidas",
                fontSize = 20.sp,
                color = Color.Red
            )
        }
    }
}