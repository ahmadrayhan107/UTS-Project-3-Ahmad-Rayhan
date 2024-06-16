package com.sisrawat.mobile.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Login : Screen("login")
    object Register : Screen("register")
    object JadwalTemu : Screen("jadwal_temu")
    object RekamMedis : Screen("rekam_medis")
    object ProfileDokter : Screen("profile_dokter")
    object ProfilePasien : Screen("profile_pasien")
    object Pasien : Screen("pasien")
    object DetailDokter : Screen("detail-dokter")
    object CreatePendaftaranTemu : Screen("create-pendaftaran-temu")
}
