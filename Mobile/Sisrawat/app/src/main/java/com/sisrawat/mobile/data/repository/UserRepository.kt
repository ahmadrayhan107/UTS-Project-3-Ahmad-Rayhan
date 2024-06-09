package com.sisrawat.mobile.data.repository

import com.sisrawat.mobile.data.remote.response.PasienResponse
import com.sisrawat.mobile.data.remote.retrofit.ApiService

class UserRepository private constructor(
    private val apiService: ApiService
) {
    suspend fun showPasien(id: Int): PasienResponse {
        return apiService.showPasien(id)
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