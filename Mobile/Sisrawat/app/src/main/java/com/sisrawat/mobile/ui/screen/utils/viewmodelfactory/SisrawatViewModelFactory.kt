package com.sisrawat.mobile.ui.screen.utils.viewmodelfactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sisrawat.mobile.data.repository.AuthRepository
import com.sisrawat.mobile.di.Injection
import com.sisrawat.mobile.ui.screen.utils.SisrawatViewModel

class SisrawatViewModelFactory(private val repository: AuthRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SisrawatViewModel::class.java)) {
            return SisrawatViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    companion object {
        @Volatile
        private var instance: SisrawatViewModelFactory? = null

        @JvmStatic
        fun getInstance(context: Context): SisrawatViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: SisrawatViewModelFactory(Injection.provideAuthRepository(context))
            }.also { instance = it }
    }
}