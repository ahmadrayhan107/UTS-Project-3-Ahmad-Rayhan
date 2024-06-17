package com.sisrawat.mobile.ui.screen.rekammedis

import android.content.res.Configuration
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sisrawat.mobile.ui.navigation.Screen
import com.sisrawat.mobile.ui.theme.SisrawatTheme

@Composable
fun RekamMedis(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    RekamMedisScreen(
        modifier = modifier,
        navController = navController
    )
}

@Composable
fun RekamMedisScreen(
    modifier: Modifier,
    navController: NavController
) {
    LazyColumn(
        modifier = modifier.padding(16.dp)
    ) {
        items(10) { rekamMedises ->
            Card(
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White
                ),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .clickable {
                        navController.navigate(Screen.DetailRekamMedis.route)
                    }
            ) {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(8.dp)
                ) {
                    Text(
                        text = "Kode Rekam Medis ${rekamMedises + 1}",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = modifier.height(4.dp))

                    Text(
                        text = "14 Juni 2024",
                        style = MaterialTheme.typography.bodySmall,
                        softWrap = true
                    )
                }
            }

            Spacer(modifier = modifier.height(8.dp))
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
fun PreviewRekamMedisScreen() {
    SisrawatTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            RekamMedis(
                navController = rememberNavController()
            )
        }
    }
}