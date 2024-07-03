package com.sisrawat.mobile.data.remote.response

import com.google.gson.annotations.SerializedName

data class TransaksiResponse(

	@field:SerializedName("daftarPembayaran")
	val daftarPembayaran: List<DaftarPembayaranItem>,

	@field:SerializedName("status")
	val status: Int
)

data class DaftarPembayaranItem(

	@field:SerializedName("id_pembayaran")
	val idPembayaran: Int,

	@field:SerializedName("total_biaya")
	val totalBiaya: String,

	@field:SerializedName("tanggal_pembayaran")
	val tanggalPembayaran: String,

	@field:SerializedName("nota")
	val nota: String,

	@field:SerializedName("status")
	val status: String
)
