package com.sisrawat.mobile.data.remote.retrofit

import com.sisrawat.mobile.data.remote.model.Login
import com.sisrawat.mobile.data.remote.model.Register
import com.sisrawat.mobile.data.remote.response.LoginResponse
import com.sisrawat.mobile.data.remote.response.PasienResponse
import com.sisrawat.mobile.data.remote.response.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("/api/v1/login")
    suspend fun login(@Body login: Login): LoginResponse

    @POST("/api/v1/register")
    suspend fun register(@Body register: Register): RegisterResponse

    @GET("/api/v1/pasien/{id}")
    suspend fun showPasien(@Path("id") id: Int): PasienResponse
}