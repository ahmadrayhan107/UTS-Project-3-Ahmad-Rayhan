package com.sisrawat.mobile.ui.screen.register

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.sisrawat.mobile.data.remote.response.LoginErrorResponse
import com.sisrawat.mobile.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.HttpException

class RegisterViewModel(private val repository: AuthRepository) : ViewModel() {
    private val _message = MutableStateFlow("")
    val message: StateFlow<String>
        get() = _message

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean>
        get() = _loading

    private val _status = MutableStateFlow(false)
    val status: StateFlow<Boolean>
        get() = _status

    suspend fun register(username: String, email: String, password: String) {
        _loading.value = true
        try {
            val data = repository.register(username, email, password)
            _message.value = "Success: ${data.message}"
            _status.value = true
        } catch (e: HttpException) {
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, LoginErrorResponse::class.java)
            val errorMessage = errorBody.message
            _message.value = "Error: $errorMessage"
            _status.value = false
        }
    }
}