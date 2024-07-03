package com.sisrawat.mobile.ui.screen.jadwaltemu

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.sisrawat.mobile.data.remote.response.DaftarTemuItem
import com.sisrawat.mobile.data.remote.response.PendaftaranTemuErrorResponse
import com.sisrawat.mobile.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.HttpException

class JadwalTemuViewModel(private val repository: UserRepository) : ViewModel() {
    private val _message = MutableStateFlow("")
    val message: StateFlow<String>
        get() = _message

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean>
        get() = _loading

    private val _status = MutableStateFlow(false)
    val status: StateFlow<Boolean>
        get() = _status

    private val _pendaftaranTemus = MutableStateFlow<List<DaftarTemuItem>>(emptyList())
    val pendaftaranTemus: StateFlow<List<DaftarTemuItem>> = _pendaftaranTemus

    suspend fun getPendaftaranTemuPasien(id: Int) {
        _loading.value = true
        try {
            val data = repository.getPendaftaranTemuPasien(id)
            _status.value = false
            _pendaftaranTemus.value = data.daftarTemu
        } catch (e: HttpException) {
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, PendaftaranTemuErrorResponse::class.java)
            val errorMessage = errorBody.message
            _status.value = true
            _message.value = errorMessage
        }
    }
}