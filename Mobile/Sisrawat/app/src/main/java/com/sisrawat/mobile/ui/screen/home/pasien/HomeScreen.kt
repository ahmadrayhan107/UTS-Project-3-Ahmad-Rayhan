package com.sisrawat.mobile.ui.screen.home.pasien

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.sisrawat.mobile.BuildConfig
import com.sisrawat.mobile.R
import com.sisrawat.mobile.data.local.model.SessionModel
import com.sisrawat.mobile.ui.component.sliderbanner.SliderBanner
import com.sisrawat.mobile.ui.screen.utils.gridItems
import com.sisrawat.mobile.ui.screen.utils.viewmodelfactory.UserViewModelFactory
import com.sisrawat.mobile.ui.theme.SisrawatTheme
import kotlinx.coroutines.launch

@Composable
fun HomePasien(
    modifier: Modifier = Modifier,
    viewModel: HomePasienViewModel = viewModel(
        factory = UserViewModelFactory.getInstance(
            LocalContext.current
        )
    ),
    sessionModel: SessionModel,
) {
    val scope = rememberCoroutineScope()
    var loading by remember { mutableStateOf(false) }
    var id by remember { mutableStateOf(0) }
    var imageUrl by remember { mutableStateOf("") }
    var namaPasien by remember { mutableStateOf("Pasien") }

    // View Model Declaration
    id = sessionModel.idUser
    scope.launch {
        viewModel.showPasien(id).let {
            imageUrl = BuildConfig.BASE_URL.plus(viewModel.imgProfile.value)
            if (viewModel.namaPasien.value.isNotBlank()) {
                namaPasien = viewModel.namaPasien.value
            }
        }
    }

    HomeScreen(
        modifier = modifier,
        namaPasien = namaPasien,
        imageUrl = imageUrl
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier,
    namaPasien: String,
    imageUrl: String
) {
    // Testing
    val items by rememberSaveable { mutableStateOf(List(8) { it }) }

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
                    text = stringResource(R.string.welcome, namaPasien)
                )
            }

            Spacer(modifier = modifier.height(16.dp))

            SliderBanner()
        }

        gridItems(
            data = items,
            columnCount = 2,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.padding(horizontal = 24.dp, vertical = 4.dp)
        ) { item ->
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
                Image(
                    painter = painterResource(R.drawable.img_profile),
                    contentDescription = null,
                    modifier = modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = modifier.height(8.dp))

                Text(
                    text = "Nama Dokter",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = modifier.padding(start = 16.dp)
                )

                Spacer(modifier = modifier.height(4.dp))

                Text(
                    text = "Poli Umum",
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
            HomePasien(
                sessionModel = SessionModel(0, "", "")
            )
        }
    }
}