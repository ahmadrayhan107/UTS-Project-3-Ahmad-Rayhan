package com.sisrawat.mobile.ui.screen.home.pasien

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.sisrawat.mobile.R
import com.sisrawat.mobile.ui.navigation.Screen
import com.sisrawat.mobile.ui.theme.Azul
import com.sisrawat.mobile.ui.theme.SisrawatTheme

@Composable
fun DetailDokter(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    DetailDokterScreen(
        modifier = modifier,
        navController = navController
    )
}

@Composable
fun DetailDokterScreen(
    modifier: Modifier,
    navController: NavController
) {
    Column(modifier = modifier.fillMaxSize()) {
        SubcomposeAsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("")
                .crossfade(true)
                .build(),
            loading = {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = modifier.padding(16.dp)
                    )
                }
            },
            error = {
                Image(
                    painter = painterResource(R.drawable.img_profile),
                    contentDescription = stringResource(R.string.img_profile),
                    contentScale = ContentScale.FillHeight
                )
            },
            contentDescription = stringResource(R.string.img_profile),
            contentScale = ContentScale.FillHeight,
            modifier = modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Spacer(modifier = modifier.height(16.dp))

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Nama Dokter",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            Text(
                text = "Poli Dokter",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        Spacer(modifier = modifier.height(16.dp))

        HorizontalDivider(
            modifier = modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = modifier.height(16.dp))

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.jadwal_dokter),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = modifier.height(16.dp))

            LazyColumn {
                items(3) { jadwalDokter ->
                    Card(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .clickable {
                                navController.navigate(Screen.CreatePendaftaranTemu.route)
                            },
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
                                text = "Hari $jadwalDokter",
                                style = MaterialTheme.typography.bodyLarge
                            )

                            Text(
                                text = stringResource(R.string.jam_format, "08:00", "09:00"),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }

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
fun PreviewDetailDokterScreen() {
    SisrawatTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DetailDokter(
                navController = rememberNavController()
            )
        }
    }
}