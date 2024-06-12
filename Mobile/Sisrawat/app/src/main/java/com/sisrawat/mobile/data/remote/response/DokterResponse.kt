package com.sisrawat.mobile.data.remote.response

import com.google.gson.annotations.SerializedName

data class DokterResponse(

	@field:SerializedName("dataDokters")
	val dataDokters: List<DataDoktersItem>,

	@field:SerializedName("current_page")
	val currentPage: Int,

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

data class User(

	@field:SerializedName("role")
	val role: String,

	@field:SerializedName("img_profile")
	val imgProfile: String,

	@field:SerializedName("last_login")
	val lastLogin: String,

	@field:SerializedName("id_user")
	val idUser: Int,

	@field:SerializedName("email")
	val email: String,

	@field:SerializedName("username")
	val username: String
)

data class DataDoktersItem(

	@field:SerializedName("nip")
	val nip: String,

	@field:SerializedName("no_hp")
	val noHp: String,

	@field:SerializedName("jadwalDokter")
	val jadwalDokter: List<JadwalDokterItem>,

	@field:SerializedName("nama_dokter")
	val namaDokter: String,

	@field:SerializedName("spesialis")
	val spesialis: String,

	@field:SerializedName("jenis_kelamin")
	val jenisKelamin: String,

	@field:SerializedName("user")
	val user: User,

	@field:SerializedName("id_dokter")
	val idDokter: Int,

	@field:SerializedName("alamat")
	val alamat: String
)
