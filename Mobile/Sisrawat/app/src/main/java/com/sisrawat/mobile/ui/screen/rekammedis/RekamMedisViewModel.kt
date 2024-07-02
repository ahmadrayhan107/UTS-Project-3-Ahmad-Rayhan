package com.sisrawat.mobile.ui.screen.rekammedis

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.sisrawat.mobile.data.remote.response.DaftarTemuItem
import com.sisrawat.mobile.data.remote.response.ObatsItem
import com.sisrawat.mobile.data.remote.response.PendaftaranTemuErrorResponse
import com.sisrawat.mobile.data.remote.response.RekamMedisErrorResponse
import com.sisrawat.mobile.data.remote.response.RekamMedisItem
import com.sisrawat.mobile.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.HttpException

class RekamMedisViewModel(private val repository: UserRepository) : ViewModel() {
    private val _message = MutableStateFlow("")
    val message: StateFlow<String>
        get() = _message

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean>
        get() = _loading

    private val _status = MutableStateFlow(false)
    val status: StateFlow<Boolean>
        get() = _status

    private val _rekamMedises = MutableStateFlow<List<RekamMedisItem>>(emptyList())
    val rekamMedises: StateFlow<List<RekamMedisItem>> = _rekamMedises

    private val _keluhan = MutableStateFlow("")
    val keluhan: StateFlow<String>
        get() = _keluhan

    private val _diagnosa = MutableStateFlow("")
    val diagnosa: StateFlow<String>
        get() = _diagnosa

    private val _tekananDarah = MutableStateFlow("")
    val tekananDarah: StateFlow<String>
        get() = _tekananDarah

    private val _beratBadan = MutableStateFlow("")
    val beratBadan: StateFlow<String>
        get() = _beratBadan

    private val _suhuTubuh = MutableStateFlow("")
    val suhuTubuh: StateFlow<String>
        get() = _suhuTubuh

    private val _obats = MutableStateFlow<List<ObatsItem>>(emptyList())
    val obats: StateFlow<List<ObatsItem>> = _obats

    suspend fun getRekamMedis(id: Int) {
        _loading.value = true
        try {
            val data = repository.getRekamMedis(id)
            _status.value = false
            _rekamMedises.value = data.rekamMedis
        } catch (e: HttpException) {
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, RekamMedisErrorResponse::class.java)
            val errorMessage = errorBody.message
            _status.value = true
            _message.value = errorMessage
        }
    }

    suspend fun getDetailRekamMedis(id: Int) {
        _loading.value = true
        try {
            val data = repository.getDetailRekamMedis(id)
            _keluhan.value = data.rekamMedis.keluhan
            _diagnosa.value = data.rekamMedis.diagnosa
            _tekananDarah.value = data.rekamMedis.tekananDarah
            _beratBadan.value = data.rekamMedis.beratBadan
            _suhuTubuh.value = data.rekamMedis.suhuTubuh
            _obats.value = data.rekamMedis.obats
        } catch (e: HttpException) {
            _message.value = e.message()
        }
    }
}