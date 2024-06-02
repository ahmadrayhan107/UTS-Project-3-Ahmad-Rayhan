package com.sisrawat.mobile.data.remote.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("authorization")
	val authorization: Authorization,

	@field:SerializedName("dataUser")
	val dataUser: DataUser,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Int
)

data class DataUser(

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

data class Authorization(

	@field:SerializedName("type")
	val type: String,

	@field:SerializedName("token")
	val token: String
)
