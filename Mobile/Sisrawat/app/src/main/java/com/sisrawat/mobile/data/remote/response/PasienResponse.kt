package com.sisrawat.mobile.data.remote.response

import com.google.gson.annotations.SerializedName

data class PasienResponse(

	@field:SerializedName("dataPasien")
	val dataPasien: DataPasien,

	@field:SerializedName("status")
	val status: Int
)

data class UserPasien(

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

data class DataPasien(

	@field:SerializedName("nama_pasien")
	val namaPasien: String,

	@field:SerializedName("nik")
	val nik: String,

	@field:SerializedName("tempat_lahir")
	val tempatLahir: String,

	@field:SerializedName("no_hp")
	val noHp: String,

	@field:SerializedName("user_id")
	val userId: Int,

	@field:SerializedName("id_pasien")
	val idPasien: Int,

	@field:SerializedName("jenis_kelamin")
	val jenisKelamin: String,

	@field:SerializedName("user")
	val user: UserPasien,

	@field:SerializedName("tanggal_lahir")
	val tanggalLahir: String,

	@field:SerializedName("alamat")
	val alamat: String
)
