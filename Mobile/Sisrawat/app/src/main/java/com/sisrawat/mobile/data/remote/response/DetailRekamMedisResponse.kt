package com.sisrawat.mobile.data.remote.response

import com.google.gson.annotations.SerializedName

data class DetailRekamMedisResponse(

	@field:SerializedName("rekamMedis")
	val rekamMedis: RekamMedis,

	@field:SerializedName("status")
	val status: Int
)

data class ObatsItem(

	@field:SerializedName("keterangan")
	val keterangan: String,

	@field:SerializedName("dosis")
	val dosis: String,

	@field:SerializedName("nama_obat")
	val namaObat: String,

	@field:SerializedName("jenis_obat")
	val jenisObat: String
)

data class RekamMedis(

	@field:SerializedName("diagnosa")
	val diagnosa: String,

	@field:SerializedName("tekanan_darah")
	val tekananDarah: String,

	@field:SerializedName("berat_badan")
	val beratBadan: String,

	@field:SerializedName("obats")
	val obats: List<ObatsItem>,

	@field:SerializedName("suhu_tubuh")
	val suhuTubuh: String,

	@field:SerializedName("keluhan")
	val keluhan: String
)
