package com.sisrawat.mobile.ui.screen.home.pasien

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.google.gson.Gson
import com.sisrawat.mobile.data.remote.response.DataDoktersItem
import com.sisrawat.mobile.data.remote.response.DetailDokterErrorResponse
import com.sisrawat.mobile.data.remote.response.JadwalDokterItem
import com.sisrawat.mobile.data.remote.response.PasienErrorResponse
import com.sisrawat.mobile.data.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
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

    val dokters: Flow<PagingData<DataDoktersItem>> = Pager(
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = { repository.getAllDokter() }
    ).flow.cachedIn(viewModelScope)

    private val _imgDokter = MutableStateFlow("")
    val imgDokter: StateFlow<String>
        get() = _imgDokter

    private val _namaDokter = MutableStateFlow("")
    val namaDokter: StateFlow<String>
        get() = _namaDokter

    private val _poliDokter = MutableStateFlow("")
    val poliDokter: StateFlow<String>
        get() = _poliDokter

    private val _idDokter = MutableStateFlow(0)
    val idDokter: StateFlow<Int>
        get() = _idDokter

    private val _jadwalDokters = MutableStateFlow<List<JadwalDokterItem>>(emptyList())
    val jadwalDokters: StateFlow<List<JadwalDokterItem>> = _jadwalDokters

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

    suspend fun showDokter(id: Int) {
        _loading.value = true
        try {
            val data = repository.showDokter(id)
            _imgDokter.value = data.dataDokter.user.imgProfile
            _namaDokter.value = data.dataDokter.namaDokter
            _poliDokter.value = data.dataDokter.spesialis
            _idDokter.value = data.dataDokter.idDokter
        } catch (e: HttpException) {
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, DetailDokterErrorResponse::class.java)
            val errorMessage = errorBody.errors
            _message.value = errorMessage
        }
    }

    suspend fun getJadwalDokter(idDokter: Int) {
        _loading.value = true
        try {
            val data = repository.getJadwalDokter(idDokter)
            _jadwalDokters.value = data.jadwalDokter
        } catch (e: HttpException) {
            _message.value = e.message()
        }
    }
}