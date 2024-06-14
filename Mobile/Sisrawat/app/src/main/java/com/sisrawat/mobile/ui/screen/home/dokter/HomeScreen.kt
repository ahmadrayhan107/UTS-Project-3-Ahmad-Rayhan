package com.sisrawat.mobile.ui.screen.home.dokter

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.sisrawat.mobile.R
import com.sisrawat.mobile.ui.screen.utils.gridItems
import com.sisrawat.mobile.ui.theme.SisrawatTheme
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun HomeDokter(
    modifier: Modifier = Modifier
) {
    val imageUrl by remember { mutableStateOf("") }
    val namaDokter by remember { mutableStateOf("Dokter") }

    HomeScreen(
        modifier = modifier,
        namaDokter = namaDokter,
        imageUrl = imageUrl,
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier,
    imageUrl: String,
    namaDokter: String
) {
    // Dummy
    val fakeData = List(10) { it + 1 }
    val pagingData = PagingData.from(fakeData)
    val fakeDataFlow = MutableStateFlow(pagingData)
    val data = fakeDataFlow.collectAsLazyPagingItems()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                SubcomposeAsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imageUrl)
                        .crossfade(true)
                        .build(),
                    loading = {
                        CircularProgressIndicator(
                            modifier = modifier.padding(16.dp)
                        )
                    },
                    error = {
                        Image(
                            painter = painterResource(R.drawable.img_profile),
                            contentDescription = stringResource(R.string.img_profile)
                        )
                    },
                    contentDescription = stringResource(R.string.img_profile),
                    contentScale = ContentScale.FillBounds,
                    modifier = modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.onBackground,
                            shape = CircleShape
                        )
                )

                Spacer(modifier = modifier.width(8.dp))

                Text(
                    text = stringResource(R.string.welcome, namaDokter),
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Spacer(modifier = modifier.height(16.dp))

            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White
                ),
                modifier = modifier
                    .fillMaxWidth()
                    .height(80.dp)
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
                        loading = {
                            CircularProgressIndicator(
                                modifier = modifier.padding(16.dp)
                            )
                        },
                        error = {
                            Image(
                                painter = painterResource(R.drawable.img_profile),
                                contentDescription = stringResource(R.string.img_profile)
                            )
                        },
                        contentDescription = stringResource(R.string.img_profile),
                        contentScale = ContentScale.FillBounds,
                        modifier = modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .border(
                                width = 1.dp,
                                color = MaterialTheme.colorScheme.onBackground,
                                shape = CircleShape
                            )
                    )

                    Spacer(modifier = modifier.width(16.dp))

                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = "Nama Pasien",
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Spacer(modifier = modifier.height(4.dp))

                        Text(
                            text = "Tanggal",
                            style = MaterialTheme.typography.bodySmall,
                            softWrap = true
                        )
                    }
                }
            }

            Spacer(modifier = modifier.height(16.dp))
        }

        gridItems(
            data = data,
            columnCount = 2,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.padding(vertical = 4.dp)
        ) { pasiens ->
            Card(
                modifier = modifier
                    .padding(
                        top = 8.dp,
                        end = 8.dp,
                        bottom = 8.dp
                    )
                    .clickable {

                    },
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White
                )
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
                            contentScale = ContentScale.Crop
                        )
                    },
                    contentDescription = stringResource(R.string.img_profile),
                    contentScale = ContentScale.Crop,
                    modifier = modifier.fillMaxWidth()
                )

                Spacer(modifier = modifier.height(8.dp))

                Text(
                    text = "Nama Pasien $pasiens",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = modifier.padding(start = 16.dp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )

                Spacer(modifier = modifier.height(4.dp))

                Text(
                    text = "Laki-Laki",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = modifier.padding(
                        start = 16.dp,
                        bottom = 16.dp
                    )
                )
            }
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
fun PreviewHomeScreen() {
    SisrawatTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HomeDokter()
        }
    }
}