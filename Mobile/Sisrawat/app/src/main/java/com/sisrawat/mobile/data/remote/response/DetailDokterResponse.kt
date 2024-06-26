package com.sisrawat.mobile.data.remote.response

import com.google.gson.annotations.SerializedName

data class DetailDokterResponse(

	@field:SerializedName("dataDokter")
	val dataDokter: DataDokter,

	@field:SerializedName("status")
	val status: Int
)

data class DokterUser(

	@field:SerializedName("role")
	val role: String,

	@field:SerializedName("img_profile")
	val imgProfile: String,

	@field:SerializedName("last_login")
	val lastLogin: Any,

	@field:SerializedName("id_user")
	val idUser: Int,

	@field:SerializedName("email")
	val email: String,

	@field:SerializedName("username")
	val username: String
)

data class DataDokter(

	@field:SerializedName("nip")
	val nip: String,

	@field:SerializedName("no_hp")
	val noHp: String,

	@field:SerializedName("user_id")
	val userId: Int,

	@field:SerializedName("nama_dokter")
	val namaDokter: String,

	@field:SerializedName("spesialis")
	val spesialis: String,

	@field:SerializedName("jenis_kelamin")
	val jenisKelamin: String,

	@field:SerializedName("user")
	val user: DokterUser,

	@field:SerializedName("id_dokter")
	val idDokter: Int,

	@field:SerializedName("alamat")
	val alamat: String
)
