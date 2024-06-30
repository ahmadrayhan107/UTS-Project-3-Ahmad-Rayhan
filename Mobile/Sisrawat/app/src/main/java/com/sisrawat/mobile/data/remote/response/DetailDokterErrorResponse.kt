package com.sisrawat.mobile.data.remote.response

import com.google.gson.annotations.SerializedName

data class DetailDokterErrorResponse(

	@field:SerializedName("errors")
	val errors: String,

	@field:SerializedName("status")
	val status: Int
)
