package com.sisrawat.mobile.data.remote.response

import com.google.gson.annotations.SerializedName

data class JadwalDokterResponse(

	@field:SerializedName("jadwalDokter")
	val jadwalDokter: List<JadwalDokterItem>,

	@field:SerializedName("status")
	val status: Int
)

data class JadwalDokterItem(

	@field:SerializedName("hari")
	val hari: String,

	@field:SerializedName("id_jadwal_dokter")
	val idJadwalDokter: Int,

	@field:SerializedName("dokter_id")
	val dokterId: Int,

	@field:SerializedName("jam_akhir")
	val jamAkhir: String,

	@field:SerializedName("jam_awal")
	val jamAwal: String,

	@field:SerializedName("seen")
	val seen: Int,

	@field:SerializedName("status")
	val status: String
)
