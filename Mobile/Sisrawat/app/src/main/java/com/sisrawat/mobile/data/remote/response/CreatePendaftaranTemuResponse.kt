package com.sisrawat.mobile.data.remote.response

import com.google.gson.annotations.SerializedName

data class CreatePendaftaranTemuResponse(

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Int
)
