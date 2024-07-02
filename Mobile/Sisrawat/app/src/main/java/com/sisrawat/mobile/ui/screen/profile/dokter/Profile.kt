package com.sisrawat.mobile.ui.screen.profile.dokter

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MedicalInformation
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.sisrawat.mobile.R
import com.sisrawat.mobile.ui.navigation.Screen
import com.sisrawat.mobile.ui.theme.Bubbles
import com.sisrawat.mobile.ui.theme.SisrawatTheme

@Composable
fun ProfileDokter(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    ProfileScreen(
        modifier = modifier,
        navController = navController
    )
}

@Composable
fun ProfileScreen(
    modifier: Modifier,
    navController: NavController
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.height(32.dp))

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
                    contentDescription = stringResource(R.string.img_profile),
                    contentScale = ContentScale.FillBounds
                )
            },
            contentDescription = stringResource(R.string.img_profile),
            contentScale = ContentScale.FillBounds,
            modifier = modifier
                .size(120.dp)
                .clip(CircleShape)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.onBackground,
                    shape = CircleShape
                )
        )

        Spacer(modifier = modifier.height(16.dp))

        Text(
            text = "user@gmail.com",
            style = MaterialTheme.typography.bodyLarge,
        )

        Spacer(modifier = modifier.height(32.dp))

        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(
                onClick = {
                    navController.navigate(Screen.EditProfile.route)
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = stringResource(R.string.edit)
                )

                Text(
                    text = stringResource(R.string.edit),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }


        Card(
            modifier = modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Bubbles,
                contentColor = Color.Black
            )
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = stringResource(R.string.nama),
                    modifier = modifier.size(24.dp)
                )

                Spacer(modifier = modifier.width(16.dp))

                Text(
                    text = stringResource(R.string.nama),
                    style = MaterialTheme.typography.bodyMedium
                )

                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "Nama Dokter",
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            }

            HorizontalDivider(
                thickness = 3.dp,
                color = MaterialTheme.colorScheme.background
            )

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.identity),
                    contentDescription = stringResource(R.string.nik),
                    modifier = modifier.size(24.dp)
                )

                Spacer(modifier = modifier.width(16.dp))

                Text(
                    text = stringResource(R.string.nip),
                    style = MaterialTheme.typography.bodyMedium
                )

                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "7410552209092447",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            HorizontalDivider(
                thickness = 3.dp,
                color = MaterialTheme.colorScheme.background
            )

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.gender),
                    contentDescription = stringResource(R.string.jenis_kelamin),
                    modifier = modifier.size(24.dp)
                )

                Spacer(modifier = modifier.width(16.dp))

                Text(
                    text = stringResource(R.string.jenis_kelamin),
                    style = MaterialTheme.typography.bodyMedium
                )

                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "Laki-Laki",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            HorizontalDivider(
                thickness = 3.dp,
                color = MaterialTheme.colorScheme.background
            )

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.MedicalInformation,
                    contentDescription = stringResource(R.string.spesialis),
                    modifier = modifier.size(24.dp)
                )

                Spacer(modifier = modifier.width(16.dp))

                Text(
                    text = stringResource(R.string.spesialis),
                    style = MaterialTheme.typography.bodyMedium
                )

                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "Poli THT",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            HorizontalDivider(
                thickness = 3.dp,
                color = MaterialTheme.colorScheme.background
            )

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.PhoneAndroid,
                    contentDescription = stringResource(R.string.no_hp),
                    modifier = modifier.size(24.dp)
                )

                Spacer(modifier = modifier.width(16.dp))

                Text(
                    text = stringResource(R.string.no_hp),
                    style = MaterialTheme.typography.bodyMedium
                )

                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "0812345681",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            HorizontalDivider(
                thickness = 3.dp,
                color = MaterialTheme.colorScheme.background
            )

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = stringResource(R.string.alamat),
                    modifier = modifier.size(24.dp)
                )

                Spacer(modifier = modifier.width(16.dp))

                Text(
                    text = stringResource(R.string.alamat),
                    style = MaterialTheme.typography.bodyMedium
                )

                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "Jl. Kandang Padati",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_4_XL,
)
@Composable
fun PreviewProfilScreen() {
    SisrawatTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ProfileDokter(
                navController = rememberNavController()
            )
        }
    }
}