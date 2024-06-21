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
    object DetailRekamMedis : Screen("detail-rekam-medis")
    object DetailPasien : Screen("detail-pasien")
    object CreateProfile : Screen("create-profile")
    object EditProfile : Screen("edit-profile")
    object Transaksi : Screen("transaksi")
    object JadwalDokter : Screen("jadwal-dokter")
    object Settings : Screen("settings")
    object About : Screen("about")
}
