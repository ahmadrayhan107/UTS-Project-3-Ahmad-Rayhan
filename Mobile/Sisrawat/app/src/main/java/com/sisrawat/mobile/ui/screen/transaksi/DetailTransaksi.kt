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
import com.sisrawat.mobile.ui.theme.Bubbles
import com.sisrawat.mobile.ui.theme.EerieBlack
import com.sisrawat.mobile.ui.theme.SisrawatTheme

@Composable
fun DetailTransaksi(
    modifier: Modifier = Modifier,
) {
    DetailTransaksiScreen(
        modifier = modifier
    )
}

@Composable
fun DetailTransaksiScreen(
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
                                    text = "T20240617224948",
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
                                    text = "17 Juni 2024",
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
                                    text = "Rp70000",
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
                                    text = "Finish",
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
            data = items,
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
                        text = "Nama Tagihan $tagihans",
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Text(
                        text = "Rp10000",
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
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
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
            DetailTransaksi()
        }
    }
}