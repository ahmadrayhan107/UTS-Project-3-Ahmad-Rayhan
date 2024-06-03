package com.sisrawat.mobile.ui.screen.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sisrawat.mobile.data.repository.AuthRepository
import kotlinx.coroutines.launch

class SisrawatViewModel(private val repository: AuthRepository) : ViewModel() {
    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }
}