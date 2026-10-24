package com.example.patrimoniovivo.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.patrimoniovivo.navigation.Routes
import com.example.patrimoniovivo.ui.theme.BotonEncargado
import com.example.patrimoniovivo.ui.theme.BotonEstudiante
import com.example.patrimoniovivo.ui.theme.BotonTurista

@Composable
fun HomeScreen(
    navController: NavController
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()

    ) {
        Text(
            text = "¡Bienvenido!",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Inicia Sesión",
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold
        )

        Button(
            onClick = {
                navController.navigate(Routes.LoginEstudiante)},
            modifier = Modifier.padding(top = 40.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = BotonEstudiante
            )
        ) {
            Text(text = "Ingresa como estudiante")
        }


            Button(
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = BotonTurista
                )
            ) {
                Text(text = "Ingresa como Profesor")
            }



            Button(
                onClick = {
                    navController.navigate(Routes.LOGINTURISTA)


                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = BotonTurista
                )
            ) {
                Text(text = "Ingresa como turista")

            }

        Spacer(
            modifier = Modifier.height(40.dp)
        )

            Button(
                onClick = {
                    navController.navigate(Routes.LoginTrabajador)


                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = BotonEncargado
                )

            ) {
                Text(text = "Acceso Personal Templo")
            }


        }
    }
