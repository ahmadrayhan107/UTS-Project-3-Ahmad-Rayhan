package com.sisrawat.mobile.ui.screen.login

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.sisrawat.mobile.data.remote.response.LoginErrorResponse
import com.sisrawat.mobile.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.HttpException

class LoginViewModel(private val repository: AuthRepository) : ViewModel() {
    private val _message = MutableStateFlow("")
    val message: StateFlow<String>
        get() = _message

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean>
        get() = _loading

    suspend fun login(email: String, password: String) {
        _loading.value = true
        try {
            val data = repository.login(email, password)
            _message.value = "Success: ${data.message}"
            repository.saveSession(
                data.dataUser.idUser,
                data.dataUser.role,
                data.authorization.token
            )
        } catch (e: HttpException) {
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, LoginErrorResponse::class.java)
            val errorMessage = errorBody.message
            _message.value = errorMessage
        }
    }
}