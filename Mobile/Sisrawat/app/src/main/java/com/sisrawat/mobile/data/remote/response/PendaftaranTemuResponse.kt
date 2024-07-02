package com.sisrawat.mobile.data.remote.response

import com.google.gson.annotations.SerializedName

data class PendaftaranTemuResponse(

	@field:SerializedName("daftarTemu")
	val daftarTemu: List<DaftarTemuItem>,

	@field:SerializedName("status")
	val status: Int
)

data class DaftarTemuItem(

	@field:SerializedName("tanggal_pendaftaran")
	val tanggalPendaftaran: String,

	@field:SerializedName("img_profile")
	val imgProfile: String,

	@field:SerializedName("nama_dokter")
	val namaDokter: String,

	@field:SerializedName("jam_akhir")
	val jamAkhir: String,

	@field:SerializedName("jam_awal")
	val jamAwal: String
)
