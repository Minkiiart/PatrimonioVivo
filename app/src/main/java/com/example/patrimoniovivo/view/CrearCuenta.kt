package com.example.patrimoniovivo.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.patrimoniovivo.viewmodel.CrearCuentaViewModel

@Composable
fun OpcionRadio(texto: String, seleccionado: Boolean, alElegir: () -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = seleccionado, onClick = alElegir)
        Text(texto)
    }
}

@Composable
fun CrearCuenta(
    navController: NavController,
    vm: CrearCuentaViewModel = viewModel()
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(30.dp)
    ) {
        Text("Crear cuenta", fontSize = 36.sp, fontWeight = FontWeight.Bold)

        Text("¿Cómo vas a usar la app?", fontWeight = FontWeight.SemiBold, modifier = Modifier.fillMaxWidth())
        Row {
            OpcionRadio("Visitante", !vm.esProfesor) { vm.esProfesor = false }
            OpcionRadio("Profesor", vm.esProfesor) { vm.esProfesor = true }
        }

        Text("¿De dónde eres?", fontWeight = FontWeight.SemiBold, modifier = Modifier.fillMaxWidth())
        Row {
            OpcionRadio("Chileno/a", !vm.esExtranjero) { vm.cambiarNacionalidad(false) }
            OpcionRadio("Extranjero/a", vm.esExtranjero) { vm.cambiarNacionalidad(true) }
        }

        OutlinedTextField(
            value = vm.nombre,
            onValueChange = { vm.nombre = it },
            label = { Text("Nombre completo") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = vm.documento,
            onValueChange = { vm.documento = it },
            label = { Text(if (vm.esExtranjero) "Pasaporte" else "RUT (ej: 12.345.678-5)") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = vm.correo,
            onValueChange = { vm.correo = it },
            label = { Text(if (vm.esProfesor) "Correo institucional" else "Correo electrónico") },
            supportingText = {
                if (vm.esProfesor) Text("Usa el correo de tu colegio, no uno personal")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = vm.telefono,
            onValueChange = { nuevo ->
                vm.telefono = nuevo.filter { it.isDigit() || it == '+' || it == ' ' }
            },
            label = { Text("Teléfono") },
            prefix = { if (!vm.esExtranjero) Text("+56 ") },
            placeholder = { Text(if (vm.esExtranjero) "+1 555 123 4567" else "9 1234 5678") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = vm.pass,
            onValueChange = { vm.pass = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = vm.confirmarPass,
            onValueChange = { vm.confirmarPass = it },
            label = { Text("Confirmar contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                if (vm.crearCuenta()) {
                    navController.popBackStack()
                }
            },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text("Crear cuenta")
        }

        if (vm.mensajeError.isNotEmpty()) {
            Text(text = vm.mensajeError, color = Color.Red, fontSize = 18.sp)
        }

        TextButton(onClick = { navController.popBackStack() }) {
            Text("Volver")
        }
    }
}