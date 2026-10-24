package com.example.patrimoniovivo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.patrimoniovivo.view.HomeEstudiante
import com.example.patrimoniovivo.view.HomeScreen
import com.example.patrimoniovivo.view.HomeTrabajador
import com.example.patrimoniovivo.view.HomeTurista
import com.example.patrimoniovivo.view.LoginEstudiante
import com.example.patrimoniovivo.view.LoginTrabajador

import com.example.patrimoniovivo.view.LoginTurista
import com.example.patrimoniovivo.view.LoginTurista


@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    )
    {
        composable(Routes.HOME) { HomeScreen( navController ) }
        composable (Routes.LOGINTURISTA) { LoginTurista(navController) }
        composable(Routes.LoginTrabajador) {
            LoginTrabajador(navController)
        }

        composable(Routes.LoginTrabajador) {
            LoginTrabajador(navController)
        }
        composable(Routes.HomeTrabajador) {
            HomeTrabajador()
        }
        composable(Routes.HomeTurista) {
            HomeTurista(navController)
        }

        composable(Routes.LoginEstudiante) {
            LoginEstudiante(navController)
        }
        composable(
            route = Routes.HomeEstudiante,
            arguments = listOf(
                navArgument("codigo") { type = NavType.StringType },
                navArgument("ids") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val codigo = backStackEntry.arguments?.getString("codigo") ?: ""
            val ids = (backStackEntry.arguments?.getString("ids") ?: "")
                .split("-")
                .mapNotNull { it.toIntOrNull() }
            HomeEstudiante(navController, codigo, ids)
        }



    }
    }




