package com.sisrawat.mobile.data.local.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.sisrawat.mobile.data.local.model.SessionModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = "session")

class SessionPreferences private constructor(private val datastore: DataStore<Preferences>) {
    private val idUserKey = intPreferencesKey("id_user")
    private val roleKey = stringPreferencesKey("role")
    private val tokenKey = stringPreferencesKey("token")

    fun getSession(): Flow<SessionModel> {
        return datastore.data.map { data ->
            SessionModel(
                data[idUserKey] ?: 0,
                data[roleKey] ?: "",
                data[tokenKey] ?: "",
            )
        }
    }

    suspend fun saveSession(sessionModel: SessionModel) {
        datastore.edit { data ->
            data[idUserKey] = sessionModel.idUser
            data[roleKey] = sessionModel.role
            data[tokenKey] = sessionModel.token
        }
    }

    suspend fun logout() {
        datastore.edit { data ->
            data.clear()
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: SessionPreferences? = null

        fun getInstance(datastore: DataStore<Preferences>): SessionPreferences {
            return INSTANCE ?: synchronized(this) {
                val instance = SessionPreferences(datastore)
                INSTANCE = instance
                instance
            }
        }
    }
}