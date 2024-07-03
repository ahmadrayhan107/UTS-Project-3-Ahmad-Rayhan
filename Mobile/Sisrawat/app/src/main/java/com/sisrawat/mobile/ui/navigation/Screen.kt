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
    object DetailDokter : Screen("detail-dokter/{idUser}") {
        fun createRoute(idUser: Int) = "detail-dokter/$idUser"
    }
    object CreatePendaftaranTemu : Screen("create-pendaftaran-temu/{idDokter}/{idJadwalDokter}") {
        fun createRoute(idDokter: Int, idJadwalDokter: Int) = "create-pendaftaran-temu/$idDokter/$idJadwalDokter"
    }
    object DetailRekamMedis : Screen("detail-rekam-medis/{idRekamMedis}") {
        fun createRoute(idRekamMedis: Int) = "detail-rekam-medis/$idRekamMedis"
    }
    object DetailPasien : Screen("detail-pasien")
    object CreateProfile : Screen("create-profile")
    object EditProfile : Screen("edit-profile")
    object Transaksi : Screen("transaksi")
    object JadwalDokter : Screen("jadwal-dokter")
    object CreateJadwalDokter : Screen("create-jadwal-dokter")
    object DetailTransaksi : Screen("detail-transaksi/{idTransaksi}") {
        fun createRoute(idTransaksi: Int) = "detail-transaksi/$idTransaksi"
    }
    object Notification : Screen("notification")
}
