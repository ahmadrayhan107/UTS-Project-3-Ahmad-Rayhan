package com.sisrawat.mobile.ui.screen.profile.pasien

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.sisrawat.mobile.data.remote.response.AttachmentsResponse
import com.sisrawat.mobile.data.remote.response.PasienErrorResponse
import com.sisrawat.mobile.data.remote.response.UpdatePasienResponse
import com.sisrawat.mobile.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.HttpException
import java.io.File

class ProfileViewModel(private val repository: UserRepository) : ViewModel() {
    private val _message = MutableStateFlow("")
    val message: StateFlow<String>
        get() = _message

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean>
        get() = _loading

    private val _namaPasien = MutableStateFlow("")
    val namaPasien: StateFlow<String>
        get() = _namaPasien

    private val _noBpjs = MutableStateFlow("")
    val noBpjs: StateFlow<String>
        get() = _noBpjs

    private val _nik = MutableStateFlow("")
    val nik: StateFlow<String>
        get() = _nik

    private val _jenisKelamin = MutableStateFlow("")
    val jenisKelamin: StateFlow<String>
        get() = _jenisKelamin

    private val _tanggalLahir = MutableStateFlow("")
    val tanggalLahir: StateFlow<String>
        get() = _tanggalLahir

    private val _tempatLahir = MutableStateFlow("")
    val tempatLahir: StateFlow<String>
        get() = _tempatLahir

    private val _noHp = MutableStateFlow("")
    val noHp: StateFlow<String>
        get() = _noHp

    private val _alamat = MutableStateFlow("")
    val alamat: StateFlow<String>
        get() = _alamat

    private val _imgProfile = MutableStateFlow("")
    val imgProfile: StateFlow<String>
        get() = _imgProfile

    private val _email = MutableStateFlow("")
    val email: StateFlow<String>
        get() = _email

    private val _idPasien = MutableStateFlow(0)
    val idPasien: StateFlow<Int>
        get() = _idPasien

    suspend fun showPasien(id: Int) {
        _loading.value = true
        try {
            val data = repository.showPasien(id)
            _namaPasien.value = data.dataPasien.namaPasien
            _noBpjs.value = data.dataPasien.noBpjs
            _nik.value = data.dataPasien.nik
            _jenisKelamin.value = data.dataPasien.jenisKelamin
            _tanggalLahir.value = data.dataPasien.tanggalLahir
            _tempatLahir.value = data.dataPasien.tempatLahir
            _noHp.value = data.dataPasien.noHp
            _alamat.value = data.dataPasien.alamat
            _imgProfile.value = data.dataPasien.user.imgProfile
            _email.value = data.dataPasien.user.email
            _idPasien.value = data.dataPasien.idPasien
        } catch (e: HttpException) {
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, PasienErrorResponse::class.java)
            val errorMessage = errorBody.errors
            _message.value = errorMessage
        }
    }

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
    ) {
        _loading.value = true
        try {
            val response = repository.updatePasien(
                idPasien,
                namaPasien,
                noBpjs,
                nik,
                jenisKelamin,
                tanggalLahir,
                tempatLahir,
                noHp,
                alamat
            )
            _message.value = response.message
        } catch (e: HttpException) {
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, UpdatePasienResponse::class.java)
            val errorMessage = errorBody.message
            _message.value = errorMessage
        }
    }

    suspend fun uploadImage(id: Int, imageFile: File) {
        _loading.value = true
        try {
            val response = repository.uploadImage(id, imageFile)
            _message.value = response.message
        } catch (e: HttpException) {
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, AttachmentsResponse::class.java)
            val errorMessage = errorBody.message
            _message.value = errorMessage
        }
    }
}