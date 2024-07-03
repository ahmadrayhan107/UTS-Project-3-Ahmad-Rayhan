package com.sisrawat.mobile.data.remote.response

import com.google.gson.annotations.SerializedName

data class DetailTransaksiResponse(

	@field:SerializedName("transaksi")
	val transaksi: Transaksi,

	@field:SerializedName("status")
	val status: Int
)

data class TagihanItem(

	@field:SerializedName("biaya")
	val biaya: String,

	@field:SerializedName("nama_tagihan")
	val namaTagihan: String
)

data class Transaksi(

	@field:SerializedName("tagihan")
	val tagihan: List<TagihanItem>,

	@field:SerializedName("total_biaya")
	val totalBiaya: String,

	@field:SerializedName("tanggal_pembayaran")
	val tanggalPembayaran: String,

	@field:SerializedName("nota")
	val nota: String,

	@field:SerializedName("status")
	val status: String
)
