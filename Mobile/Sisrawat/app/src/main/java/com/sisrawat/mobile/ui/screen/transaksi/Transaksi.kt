package com.sisrawat.mobile.ui.screen.transaksi

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import com.sisrawat.mobile.ui.navigation.Screen
import com.sisrawat.mobile.ui.screen.utils.viewmodelfactory.UserViewModelFactory
import com.sisrawat.mobile.ui.theme.Bubbles
import com.sisrawat.mobile.ui.theme.SisrawatTheme
import kotlinx.coroutines.launch

@Composable
fun Transaksi(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: TransaksiViewModel = viewModel(
        factory = UserViewModelFactory.getInstance(LocalContext.current)
    ),
    sessionModel: SessionModel
) {
    val scope = rememberCoroutineScope()

    var idPasien by remember { mutableStateOf(0) }
    var status by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }

    idPasien = sessionModel.userId
    scope.launch {
        viewModel.getAllTransaksi(idPasien)
    }

    status = viewModel.status.value
    val transaksis by viewModel.transaksis.collectAsState()

    if (status) {
        message = viewModel.message.value

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = message,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )
        }
    } else {
        LazyColumn(
            modifier = modifier.padding(16.dp)
        ) {
            items(transaksis) { transaksis ->
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
                            navController.navigate(Screen.DetailTransaksi.createRoute(transaksis.idPembayaran))
                        }
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Column {
                            Text(
                                text = transaksis.nota,
                                style = MaterialTheme.typography.bodyMedium
                            )

                            Spacer(modifier = modifier.height(4.dp))

                            Text(
                                text = transaksis.tanggalPembayaran,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }

                        Column(
                            horizontalAlignment = Alignment.End
                        ) {
                            Text(
                                text = transaksis.status,
                                style = MaterialTheme.typography.bodyMedium
                            )

                            Spacer(modifier = modifier.height(4.dp))

                            Text(
                                text = transaksis.totalBiaya,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }


                    }
                }

                Spacer(modifier = modifier.height(8.dp))
            }
        }
    }

}

@Preview(
    showSystemUi = true,
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO,
    device = Devices.PIXEL_4_XL
)
@Composable
fun PreviewTransaksiScreen() {
    SisrawatTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Transaksi(
                navController = rememberNavController(),
                sessionModel = SessionModel(0, 0, "", "")
            )
        }
    }
}