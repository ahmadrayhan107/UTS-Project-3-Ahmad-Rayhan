package com.sisrawat.mobile.ui.screen.utils.viewmodelfactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sisrawat.mobile.data.repository.UserRepository
import com.sisrawat.mobile.di.Injection
import com.sisrawat.mobile.ui.screen.home.pasien.HomePasienViewModel
import com.sisrawat.mobile.ui.screen.jadwaltemu.JadwalTemuViewModel
import com.sisrawat.mobile.ui.screen.profile.pasien.ProfileViewModel
import com.sisrawat.mobile.ui.screen.rekammedis.RekamMedisViewModel

class UserViewModelFactory(private val repository: UserRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomePasienViewModel::class.java)) {
            return HomePasienViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            return ProfileViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(JadwalTemuViewModel::class.java)) {
            return JadwalTemuViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(RekamMedisViewModel::class.java)) {
            return RekamMedisViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    companion object {
        @Volatile
        private var instance: UserViewModelFactory? = null

        @JvmStatic
        fun getInstance(context: Context): UserViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: UserViewModelFactory(Injection.provideUserRepository(context))
            }.also { instance = it }
    }
}