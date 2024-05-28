package com.sisrawat.mobile

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sisrawat.mobile.ui.navigation.Screen
import com.sisrawat.mobile.ui.screen.login.Login
import com.sisrawat.mobile.ui.screen.register.Register

@Composable
fun SisrawatApp(
    navController: NavHostController = rememberNavController()
) {
    // Initial UI
    val startDestination = Screen.Login.route

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Login.route) {
            Login(navController = navController)
        }
        composable(Screen.Register.route) {
            Register(navController = navController)
        }
    }
}