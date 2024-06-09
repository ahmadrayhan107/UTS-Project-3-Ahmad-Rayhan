package com.sisrawat.mobile.di

import android.content.Context
import com.sisrawat.mobile.data.local.preferences.SessionPreferences
import com.sisrawat.mobile.data.local.preferences.datastore
import com.sisrawat.mobile.data.remote.retrofit.ApiConfig
import com.sisrawat.mobile.data.repository.AuthRepository
import com.sisrawat.mobile.data.repository.UserRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideAuthRepository(context: Context): AuthRepository {
        val sessionPreferences = SessionPreferences.getInstance(context.datastore)
        val user = runBlocking { sessionPreferences.getSession().first() }
        val apiService = ApiConfig.getApiService(user.token)
        return AuthRepository.getInstance(sessionPreferences, apiService)
    }

    fun provideUserRepository(context: Context): UserRepository {
        val sessionPreferences = SessionPreferences.getInstance(context.datastore)
        val user = runBlocking { sessionPreferences.getSession().first() }
        val apiService = ApiConfig.getApiService(user.token)
        return UserRepository.getInstance(apiService)
    }
}