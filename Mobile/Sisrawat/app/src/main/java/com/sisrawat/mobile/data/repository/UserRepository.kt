package com.sisrawat.mobile.data.repository

import com.sisrawat.mobile.data.paging.DokterPagingSource
import com.sisrawat.mobile.data.remote.model.Pasien
import com.sisrawat.mobile.data.remote.response.AttachmentsResponse
import com.sisrawat.mobile.data.remote.response.DetailDokterResponse
import com.sisrawat.mobile.data.remote.response.JadwalDokterItem
import com.sisrawat.mobile.data.remote.response.JadwalDokterResponse
import com.sisrawat.mobile.data.remote.response.PasienResponse
import com.sisrawat.mobile.data.remote.response.UpdatePasienResponse
import com.sisrawat.mobile.data.remote.retrofit.ApiService
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class UserRepository private constructor(
    private val apiService: ApiService
) {
    suspend fun showPasien(id: Int): PasienResponse {
        return apiService.showPasien(id)
    }

    fun getAllDokter() = DokterPagingSource(apiService)

    suspend fun updatePasien(
        idPasien: Int,
        namaPasien: String,
        noBpjs: String,
        nik: String,
        jenisKelamin: String,
        tanggalLahir: String,
        tempatLahir: String,
        noHp: String,
        alamat: String
    ): UpdatePasienResponse {
        return apiService.updatePasien(
            idPasien,
            Pasien(namaPasien, noBpjs, nik, jenisKelamin, tanggalLahir, tempatLahir, noHp, alamat)
        )
    }

    suspend fun uploadImage(id: Int, imageFile: File): AttachmentsResponse {
        val requestImageFile = imageFile.asRequestBody("image/jpeg".toMediaType())
        val image = MultipartBody.Part.createFormData(
            "img_profile",
            imageFile.name,
            requestImageFile
        )

        return apiService.uploadImage(id ,image)
    }

    suspend fun showDokter(id: Int): DetailDokterResponse {
        return apiService.showDokter(id)
    }

    suspend fun getJadwalDokter(idDokter: Int): JadwalDokterResponse {
        return apiService.getJadwalDokter(idDokter)
    }

    companion object {
        @Volatile
        private var instance: UserRepository? = null
        fun getInstance(
            apiService: ApiService
        ): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(apiService)
            }.also { instance = it }
    }
}