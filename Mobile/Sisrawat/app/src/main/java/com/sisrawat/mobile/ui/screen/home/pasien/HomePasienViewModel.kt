package com.sisrawat.mobile.ui.screen.home.pasien

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.sisrawat.mobile.data.remote.response.DoktersResponse
import com.sisrawat.mobile.data.remote.response.PasienErrorResponse
import com.sisrawat.mobile.data.repository.UserRepository
import com.sisrawat.mobile.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.HttpException

class HomePasienViewModel(private val repository: UserRepository) : ViewModel() {
    private val _message = MutableStateFlow("")
    val message: StateFlow<String>
        get() = _message

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean>
        get() = _loading

    private val _namaPasien = MutableStateFlow("")
    val namaPasien: StateFlow<String>
        get() = _namaPasien

    private val _imgProfile = MutableStateFlow("")
    val imgProfile: StateFlow<String>
        get() = _imgProfile

    suspend fun showPasien(id: Int) {
        _loading.value = true
        try {
            val data = repository.showPasien(id)
            _namaPasien.value = data.dataPasien.namaPasien
            _imgProfile.value = data.dataPasien.user.imgProfile
        } catch (e: HttpException) {
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, PasienErrorResponse::class.java)
            val errorMessage = errorBody.errors
            _message.value = errorMessage
        }
    }
}