package com.sisrawat.mobile.ui.screen.rekammedis

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sisrawat.mobile.R
import com.sisrawat.mobile.ui.screen.utils.listItems
import com.sisrawat.mobile.ui.theme.Azul
import com.sisrawat.mobile.ui.theme.EerieBlack
import com.sisrawat.mobile.ui.theme.SisrawatTheme

@Composable
fun DetailRekamMedis(
    modifier: Modifier = Modifier,
) {
    DetailRekamMedisScreen(
        modifier = modifier
    )
}

@Composable
fun DetailRekamMedisScreen(
    modifier: Modifier
) {
    // Testing
    val items by rememberSaveable { mutableStateOf(List(5) { it }) }

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
                                    text = "Keluhan Pasien",
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
                                    text = "Diagnosa Pasien",
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
                                    text = "100 mmHg",
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
                                    text = "65 Kg",
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
                                    text = "45°C",
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
            data = items,
            modifier = modifier.padding(horizontal = 16.dp)
        ) { obats ->
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Azul,
                    contentColor = Color.White
                )
            ) {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(8.dp)
                ) {
                    Text(
                        text = "Nama Obat $obats",
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Text(
                        text = stringResource(R.string.dosis, "3x1/hari"),
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = stringResource(R.string.jenis_obat, "Sirup"),
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = stringResource(R.string.keterangan_obat, "Sesudah makan"),
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
@Preview(
    uiMode = UI_MODE_NIGHT_YES,
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
            DetailRekamMedis()
        }
    }
}