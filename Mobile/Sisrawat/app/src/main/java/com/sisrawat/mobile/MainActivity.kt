package com.sisrawat.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.sisrawat.mobile.data.local.preferences.SessionPreferences
import com.sisrawat.mobile.data.local.preferences.datastore
import com.sisrawat.mobile.ui.theme.SisrawatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sessionPreferences = SessionPreferences.getInstance(this.datastore)
        setContent {
            SisrawatTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SisrawatApp(sessionPreferences = sessionPreferences)
                }
            }
        }
    }
}