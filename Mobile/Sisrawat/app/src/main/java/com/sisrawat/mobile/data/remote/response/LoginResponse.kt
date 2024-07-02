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

	@field:SerializedName("user_id")
	val userId: Int,

	@field:SerializedName("id_user")
	val idUser: Int
)

data class Authorization(

	@field:SerializedName("type")
	val type: String,

	@field:SerializedName("token")
	val token: String
)
