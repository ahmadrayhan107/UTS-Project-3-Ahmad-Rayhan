package com.sisrawat.mobile.ui.screen.transaksi

import android.content.res.Configuration
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sisrawat.mobile.R
import com.sisrawat.mobile.data.remote.response.TagihanItem
import com.sisrawat.mobile.ui.screen.utils.listItems
import com.sisrawat.mobile.ui.screen.utils.viewmodelfactory.UserViewModelFactory
import com.sisrawat.mobile.ui.theme.Bubbles
import com.sisrawat.mobile.ui.theme.EerieBlack
import com.sisrawat.mobile.ui.theme.SisrawatTheme
import kotlinx.coroutines.launch

@Composable
fun DetailTransaksi(
    modifier: Modifier = Modifier,
    viewModel: TransaksiViewModel = viewModel(
        factory = UserViewModelFactory.getInstance(LocalContext.current)
    ),
    idTransaksi: Int
) {
    val scope = rememberCoroutineScope()

    var idPembayaran by remember { mutableStateOf(0) }
    var nota by remember { mutableStateOf("") }
    var tanggalPembayaran by remember { mutableStateOf("") }
    var totalBiaya by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    idPembayaran = idTransaksi
    scope.launch {
        viewModel.getDetailTransaksi(idPembayaran).let {
            nota = viewModel.nota.value
            tanggalPembayaran = viewModel.tanggalPembayaran.value
            totalBiaya = viewModel.totalBiaya.value
            status = viewModel.statusTransaksi.value
        }
    }

    val tagihans by viewModel.tagihans.collectAsState()

    DetailTransaksiScreen(
        modifier = modifier,
        nota = nota,
        tanggalPembayaran = tanggalPembayaran,
        totalBiaya = totalBiaya,
        status = status,
        tagihans = tagihans
    )
}

@Composable
fun DetailTransaksiScreen(
    modifier: Modifier,
    nota: String,
    tanggalPembayaran: String,
    totalBiaya: String,
    status: String,
    tagihans: List<TagihanItem>
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        item {
            Spacer(modifier = modifier.height(16.dp))

            Text(
                text = stringResource(R.string.detail_transaksi),
                style = MaterialTheme.typography.bodyLarge,
                modifier = modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = modifier.height(8.dp))

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    OutlinedCard(
                        modifier = modifier
                            .width(180.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White,
                            contentColor = EerieBlack
                        ),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Row(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = stringResource(R.string.nota),
                                    style = MaterialTheme.typography.bodyMedium
                                )

                                Text(
                                    text = nota,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }

                    Spacer(modifier = modifier.height(8.dp))

                    OutlinedCard(
                        modifier = modifier
                            .width(180.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White,
                            contentColor = EerieBlack
                        ),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Row(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = stringResource(R.string.tanggal_pembayaran),
                                    style = MaterialTheme.typography.bodyMedium
                                )

                                Text(
                                    text = tanggalPembayaran,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }

                    Spacer(modifier = modifier.height(8.dp))

                    OutlinedCard(
                        modifier = modifier
                            .width(180.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White,
                            contentColor = EerieBlack
                        ),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Row(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = stringResource(R.string.total_biaya),
                                    style = MaterialTheme.typography.bodyMedium
                                )

                                Text(
                                    text = totalBiaya,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }
                }

                Column {
                    OutlinedCard(
                        modifier = modifier
                            .width(150.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White,
                            contentColor = EerieBlack
                        ),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Row(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = stringResource(R.string.status),
                                    style = MaterialTheme.typography.bodyMedium
                                )

                                Text(
                                    text = status,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = modifier.height(16.dp))

            HorizontalDivider(
                modifier = modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = modifier.height(16.dp))

            Text(
                text = stringResource(R.string.list_tagihan),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = modifier.height(16.dp))
        }

        listItems(
            data = tagihans,
            modifier = modifier.padding(horizontal = 16.dp)
        ) { tagihans ->
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Bubbles,
                    contentColor = Color.Black
                )
            ) {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(8.dp)
                ) {
                    Text(
                        text = tagihans.namaTagihan,
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Text(
                        text = tagihans.biaya,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Spacer(modifier = modifier.height(8.dp))
        }
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_4_XL
)
@Composable
fun PreviewDetailTransaksiScreen() {
    SisrawatTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DetailTransaksi(
                idTransaksi = 0
            )
        }
    }
}