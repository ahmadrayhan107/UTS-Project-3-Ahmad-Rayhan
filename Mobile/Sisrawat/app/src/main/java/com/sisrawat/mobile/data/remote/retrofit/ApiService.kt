package com.sisrawat.mobile.data.remote.retrofit

import com.sisrawat.mobile.data.remote.model.Login
import com.sisrawat.mobile.data.remote.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/api/v1/login")
    suspend fun login(@Body login: Login): LoginResponse
}