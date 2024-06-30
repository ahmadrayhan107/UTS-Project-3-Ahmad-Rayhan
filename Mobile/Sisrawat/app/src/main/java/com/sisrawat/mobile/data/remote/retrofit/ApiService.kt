package com.sisrawat.mobile.data.remote.retrofit

import com.sisrawat.mobile.data.remote.model.Login
import com.sisrawat.mobile.data.remote.model.Pasien
import com.sisrawat.mobile.data.remote.model.Register
import com.sisrawat.mobile.data.remote.response.AttachmentsResponse
import com.sisrawat.mobile.data.remote.response.DetailDokterResponse
import com.sisrawat.mobile.data.remote.response.DokterResponse
import com.sisrawat.mobile.data.remote.response.JadwalDokterItem
import com.sisrawat.mobile.data.remote.response.JadwalDokterResponse
import com.sisrawat.mobile.data.remote.response.LoginResponse
import com.sisrawat.mobile.data.remote.response.PasienResponse
import com.sisrawat.mobile.data.remote.response.RegisterResponse
import com.sisrawat.mobile.data.remote.response.UpdatePasienResponse
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @POST("/api/v1/login")
    suspend fun login(@Body login: Login): LoginResponse

    @POST("/api/v1/register")
    suspend fun register(@Body register: Register): RegisterResponse

    @GET("/api/v1/pasien/{id}")
    suspend fun showPasien(@Path("id") id: Int): PasienResponse

    @GET("/api/v1/dokter")
    suspend fun getAllDokter(@Query("page") page: Int): DokterResponse

    @PUT("/api/v1/pasien/{id}")
    suspend fun updatePasien(
        @Path("id") idPasien: Int,
        @Body pasien: Pasien
    ): UpdatePasienResponse

    @Multipart
    @POST("/api/v1/attachments/{id}")
    suspend fun uploadImage(
        @Path("id") id: Int,
        @Part file: MultipartBody.Part
    ): AttachmentsResponse

    @GET("/api/v1/dokter/{id}")
    suspend fun showDokter(@Path("id") id: Int): DetailDokterResponse

    @GET("/api/v1/jadwal-dokter/{id}")
    suspend fun getJadwalDokter(@Path("id") id: Int): JadwalDokterResponse
}