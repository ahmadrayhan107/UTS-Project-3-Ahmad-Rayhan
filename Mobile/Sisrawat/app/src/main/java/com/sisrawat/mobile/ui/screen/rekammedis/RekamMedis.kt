package com.sisrawat.mobile.ui.screen.rekammedis

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sisrawat.mobile.data.local.model.SessionModel
import com.sisrawat.mobile.data.remote.response.RekamMedisItem
import com.sisrawat.mobile.ui.navigation.Screen
import com.sisrawat.mobile.ui.screen.jadwaltemu.JadwalTemuScreen
import com.sisrawat.mobile.ui.screen.utils.viewmodelfactory.UserViewModelFactory
import com.sisrawat.mobile.ui.theme.Bubbles
import com.sisrawat.mobile.ui.theme.SisrawatTheme
import kotlinx.coroutines.launch

@Composable
fun RekamMedis(
    modifier: Modifier = Modifier,
    navController: NavController,
    sessionModel: SessionModel,
    viewModel: RekamMedisViewModel = viewModel(
        factory = UserViewModelFactory.getInstance(LocalContext.current)
    )
) {
    val scope = rememberCoroutineScope()

    scope.launch {
        viewModel.getRekamMedis(sessionModel.userId)
    }

    val rekamMedises by viewModel.rekamMedises.collectAsState()

    if (viewModel.status.value) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = viewModel.message.value,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )
        }
    } else {
        RekamMedisScreen(
            modifier = modifier,
            navController = navController,
            rekamMedises = rekamMedises
        )
    }
}

@Composable
fun RekamMedisScreen(
    modifier: Modifier,
    navController: NavController,
    rekamMedises: List<RekamMedisItem>
) {
    LazyColumn(
        modifier = modifier.padding(16.dp)
    ) {
        items(rekamMedises) { rekamMedises ->
            Card(
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Bubbles,
                    contentColor = Color.Black
                ),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .clickable {
                        navController.navigate(Screen.DetailRekamMedis.createRoute(rekamMedises.idRekamMedis))
                    }
            ) {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(8.dp)
                ) {
                    Text(
                        text = rekamMedises.kodeRekamMedis,
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Spacer(modifier = modifier.height(4.dp))

                    Text(
                        text = rekamMedises.tanggal,
                        style = MaterialTheme.typography.bodySmall,
                        softWrap = true
                    )
                }
            }

            Spacer(modifier = modifier.height(8.dp))
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_4_XL,
)
@Composable
fun PreviewRekamMedisScreen() {
    SisrawatTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            RekamMedis(
                navController = rememberNavController(),
                sessionModel = SessionModel(0, 0, "", "")
            )
        }
    }
}