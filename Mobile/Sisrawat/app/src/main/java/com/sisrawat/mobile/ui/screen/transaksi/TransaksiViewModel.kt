package com.sisrawat.mobile.ui.screen.transaksi

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.sisrawat.mobile.data.remote.response.DaftarPembayaranItem
import com.sisrawat.mobile.data.remote.response.RekamMedisErrorResponse
import com.sisrawat.mobile.data.remote.response.RekamMedisItem
import com.sisrawat.mobile.data.remote.response.TagihanItem
import com.sisrawat.mobile.data.remote.response.TransaksiErrorResponse
import com.sisrawat.mobile.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.HttpException

class TransaksiViewModel(private val repository: UserRepository) : ViewModel() {
    private val _message = MutableStateFlow("")
    val message: StateFlow<String>
        get() = _message

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean>
        get() = _loading

    private val _status = MutableStateFlow(false)
    val status: StateFlow<Boolean>
        get() = _status

    private val _transaksis = MutableStateFlow<List<DaftarPembayaranItem>>(emptyList())
    val transaksis: StateFlow<List<DaftarPembayaranItem>> = _transaksis

    private val _nota = MutableStateFlow("")
    val nota: StateFlow<String>
        get() = _nota

    private val _tanggalPembayaran = MutableStateFlow("")
    val tanggalPembayaran: StateFlow<String>
        get() = _tanggalPembayaran

    private val _totalBiaya = MutableStateFlow("")
    val totalBiaya: StateFlow<String>
        get() = _totalBiaya

    private val _statusTransaksi = MutableStateFlow("")
    val statusTransaksi: StateFlow<String>
        get() = _statusTransaksi

    private val _tagihans = MutableStateFlow<List<TagihanItem>>(emptyList())
    val tagihans: StateFlow<List<TagihanItem>> = _tagihans


    suspend fun getAllTransaksi(idPasien: Int) {
        _loading.value = true
        try {
            _status.value = false
            val data = repository.getAllTransaksi(idPasien)
            _transaksis.value = data.daftarPembayaran
        } catch (e: HttpException) {
            _status.value = true
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, TransaksiErrorResponse::class.java)
            val errorMessage = errorBody.message
            _message.value = errorMessage
        }
    }

    suspend fun getDetailTransaksi(idPembayaran: Int) {
        _loading.value = true
        try {
            val data = repository.getDetailTransaksi(idPembayaran)
            _nota.value = data.transaksi.nota
            _tanggalPembayaran.value = data.transaksi.tanggalPembayaran
            _totalBiaya.value = data.transaksi.totalBiaya
            _statusTransaksi.value = data.transaksi.status
            _tagihans.value = data.transaksi.tagihan
        } catch (e: HttpException) {
            _message.value = e.message()
        }
    }
}