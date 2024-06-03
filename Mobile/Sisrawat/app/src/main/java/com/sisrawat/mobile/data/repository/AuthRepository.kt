package com.sisrawat.mobile.data.repository

import com.sisrawat.mobile.data.local.model.SessionModel
import com.sisrawat.mobile.data.local.preferences.SessionPreferences
import com.sisrawat.mobile.data.remote.model.Login
import com.sisrawat.mobile.data.remote.model.Register
import com.sisrawat.mobile.data.remote.response.LoginResponse
import com.sisrawat.mobile.data.remote.response.RegisterResponse
import com.sisrawat.mobile.data.remote.retrofit.ApiService

class AuthRepository private constructor(
    private val userPreference: SessionPreferences,
    private val apiService: ApiService
) {
    suspend fun login(email: String, password: String): LoginResponse {
        return apiService.login(Login(email, password))
    }

    suspend fun register(username: String, email: String, password: String): RegisterResponse {
        return apiService.register(Register(username, email, password))
    }

    suspend fun saveSession(idUser: Int, role: String, token: String) {
        userPreference.saveSession(SessionModel(idUser, role, token))
    }

    suspend fun logout() {
        userPreference.logout()
    }

    companion object {
        @Volatile
        private var instance: AuthRepository? = null
        fun getInstance(
            userPreference: SessionPreferences,
            apiService: ApiService
        ): AuthRepository =
            instance ?: synchronized(this) {
                instance ?: AuthRepository(userPreference, apiService)
            }.also { instance = it }
    }
}