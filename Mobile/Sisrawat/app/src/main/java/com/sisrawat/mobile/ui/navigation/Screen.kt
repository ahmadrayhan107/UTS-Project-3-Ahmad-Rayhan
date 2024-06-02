package com.sisrawat.mobile.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Login : Screen("login")
    object Register : Screen("register")
    object JadwalTemu : Screen("jadwal_temu")
    object RekamMedis : Screen("rekam_medis")
    object Profile : Screen("profile")
    object Pasien : Screen("pasien")
}
