package com.sisrawat.mobile.data.remote.model

import com.google.gson.annotations.SerializedName

data class PendaftaranTemu(
    @field:SerializedName("tanggal_pendaftaran")
    val tanggalPendaftaraan: String,
    @field:SerializedName("jam")
    val jam: String,
    @field:SerializedName("dokter_id")
    val dokterId: Int,
    @field:SerializedName("pasien_id")
    val pasienId: Int
)
