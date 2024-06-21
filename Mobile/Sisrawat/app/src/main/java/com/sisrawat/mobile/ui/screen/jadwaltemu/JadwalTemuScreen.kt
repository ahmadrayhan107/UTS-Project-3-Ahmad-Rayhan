package com.sisrawat.mobile.ui.screen.jadwaltemu

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.sisrawat.mobile.R
import com.sisrawat.mobile.ui.theme.Bubbles
import com.sisrawat.mobile.ui.theme.SisrawatTheme

@Composable
fun JadwalTemu(
    modifier: Modifier = Modifier
) {
    JadwalTemuScreen(modifier)
}

@Composable
fun JadwalTemuScreen(
    modifier: Modifier
) {
    LazyColumn(
        modifier = modifier.padding(16.dp)
    ) {
        items(10) { jadwalTemus ->
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Bubbles,
                    contentColor = Color.Black
                ),
                modifier = modifier
                    .fillMaxWidth()
                    .height(80.dp),
                border = BorderStroke(
                    width = 1.dp,
                    color = Color.Black
                )
            ) {
                Row(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SubcomposeAsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("")
                            .crossfade(true)
                            .build(),
                        error = {
                            Image(
                                painter = painterResource(R.drawable.img_profile),
                                contentDescription = stringResource(R.string.img_profile),
                                contentScale = ContentScale.FillHeight
                            )
                        },
                        contentDescription = stringResource(R.string.img_profile),
                        contentScale = ContentScale.FillHeight
                    )

                    Spacer(modifier = modifier.width(16.dp))

                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = "Nama Pasien/Dokter ${jadwalTemus + 1}",
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Spacer(modifier = modifier.height(4.dp))

                        Text(
                            text = "08:00-09:00, 14 Juni 2024",
                            style = MaterialTheme.typography.bodySmall,
                            softWrap = true
                        )
                    }
                }
            }

            Spacer(modifier = modifier.height(16.dp))
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_4_XL,
)
@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_4_XL,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun PreviewJadwalTemuScreen() {
    SisrawatTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            JadwalTemu()
        }
    }
}