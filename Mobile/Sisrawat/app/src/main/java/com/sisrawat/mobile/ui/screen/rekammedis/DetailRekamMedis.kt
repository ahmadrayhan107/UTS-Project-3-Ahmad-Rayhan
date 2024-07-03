package com.sisrawat.mobile.ui.screen.rekammedis

import android.content.res.Configuration.UI_MODE_NIGHT_NO
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
import com.sisrawat.mobile.data.remote.response.ObatsItem
import com.sisrawat.mobile.ui.screen.utils.listItems
import com.sisrawat.mobile.ui.screen.utils.viewmodelfactory.UserViewModelFactory
import com.sisrawat.mobile.ui.theme.Bubbles
import com.sisrawat.mobile.ui.theme.EerieBlack
import com.sisrawat.mobile.ui.theme.SisrawatTheme
import kotlinx.coroutines.launch

@Composable
fun DetailRekamMedis(
    modifier: Modifier = Modifier,
    viewModel: RekamMedisViewModel = viewModel(
        factory = UserViewModelFactory.getInstance(LocalContext.current)
    ),
    idRekamMedis: Int
) {
    val scope = rememberCoroutineScope()

    var keluhan by remember { mutableStateOf("") }
    var diagnosa by remember { mutableStateOf("") }
    var tekananDarah by remember { mutableStateOf("") }
    var beratBadan by remember { mutableStateOf("") }
    var suhuTubuh by remember { mutableStateOf("") }

    scope.launch {
        viewModel.getDetailRekamMedis(idRekamMedis).let {
            keluhan = viewModel.keluhan.value
            diagnosa = viewModel.diagnosa.value
            tekananDarah = viewModel.tekananDarah.value
            beratBadan = viewModel.beratBadan.value
            suhuTubuh = viewModel.suhuTubuh.value
        }
    }

    val obats by viewModel.obats.collectAsState()

    DetailRekamMedisScreen(
        modifier = modifier,
        keluhan = keluhan,
        diagnosa = diagnosa,
        tekananDarah = tekananDarah,
        beratBadan = beratBadan,
        suhuTubuh = suhuTubuh,
        obats = obats
    )
}

@Composable
fun DetailRekamMedisScreen(
    modifier: Modifier,
    keluhan: String,
    diagnosa: String,
    tekananDarah: String,
    beratBadan: String,
    suhuTubuh: String,
    obats: List<ObatsItem>
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        item {
            Spacer(modifier = modifier.height(16.dp))

            Text(
                text = stringResource(R.string.detail_rekam_medis),
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
                                    text = stringResource(R.string.keluhan),
                                    style = MaterialTheme.typography.bodyMedium
                                )

                                Text(
                                    text = keluhan,
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
                                    text = stringResource(R.string.diagnosa),
                                    style = MaterialTheme.typography.bodyMedium
                                )

                                Text(
                                    text = diagnosa,
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
                                    text = stringResource(R.string.tekanan_darah),
                                    style = MaterialTheme.typography.bodyMedium
                                )

                                Text(
                                    text = tekananDarah,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }

                    Spacer(modifier = modifier.height(8.dp))

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
                                    text = stringResource(R.string.berat_badan),
                                    style = MaterialTheme.typography.bodyMedium
                                )

                                Text(
                                    text = beratBadan,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }

                    Spacer(modifier = modifier.height(8.dp))

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
                                    text = stringResource(R.string.suhu_tubuh),
                                    style = MaterialTheme.typography.bodyMedium
                                )

                                Text(
                                    text = suhuTubuh,
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
                text = stringResource(R.string.list_obat),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = modifier.height(16.dp))
        }

        listItems(
            data = obats,
            modifier = modifier.padding(horizontal = 16.dp)
        ) { obats ->
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
                        text = obats.namaObat,
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Text(
                        text = stringResource(R.string.dosis, obats.dosis),
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = stringResource(R.string.jenis_obat, obats.jenisObat),
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = stringResource(R.string.keterangan_obat, obats.keterangan),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Spacer(modifier = modifier.height(8.dp))
        }
    }
}

@Preview(
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_4_XL
)
@Composable
fun PreviewDetailRekamMedisScreen() {
    SisrawatTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DetailRekamMedis(
                idRekamMedis = 0
            )
        }
    }
}