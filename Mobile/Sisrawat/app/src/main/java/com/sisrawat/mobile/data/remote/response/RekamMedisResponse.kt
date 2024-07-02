package com.sisrawat.mobile.data.remote.response

import com.google.gson.annotations.SerializedName

data class RekamMedisResponse(

	@field:SerializedName("rekamMedis")
	val rekamMedis: List<RekamMedisItem>,

	@field:SerializedName("status")
	val status: Int
)

data class RekamMedisItem(

	@field:SerializedName("id_rekam_medis")
	val idRekamMedis: Int,

	@field:SerializedName("tanggal")
	val tanggal: String,

	@field:SerializedName("kode_rekam_medis")
	val kodeRekamMedis: String
)
