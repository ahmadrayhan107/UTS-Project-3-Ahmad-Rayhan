package com.sisrawat.mobile.ui.screen.jadwaldokter

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.Today
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sisrawat.mobile.R
import com.sisrawat.mobile.ui.component.TimePickerDialog
import com.sisrawat.mobile.ui.theme.AliceBlue
import com.sisrawat.mobile.ui.theme.Azul
import com.sisrawat.mobile.ui.theme.EerieBlack
import com.sisrawat.mobile.ui.theme.SisrawatTheme
import com.sisrawat.mobile.ui.theme.SoftBlue
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateJadwalDokter(
    modifier: Modifier = Modifier
) {
    // Time Picker
    var showBeginTimePicker by remember { mutableStateOf(false) }
    var showEndTimePicker by remember { mutableStateOf(false) }
    val timeState = rememberTimePickerState(is24Hour = true)
    val timeFormat = remember { SimpleDateFormat("HH:mm", Locale.getDefault()) }
    var jamAwal by remember { mutableStateOf("--:--") }
    var jamAkhir by remember { mutableStateOf("--:--") }
    var hari by remember { mutableStateOf("") }

    // Button
    var enabled by remember { mutableStateOf(true) }
    var loading by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedCard(
            modifier = modifier
                .width(300.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
                contentColor = EerieBlack
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            TextField(
                value = hari,
                onValueChange = { input ->
                    hari = input
                },
                modifier = modifier.fillMaxWidth(),
                textStyle = MaterialTheme.typography.bodyMedium,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = AliceBlue,
                    disabledIndicatorColor = AliceBlue,
                    unfocusedIndicatorColor = AliceBlue,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    selectionColors = TextSelectionColors(
                        handleColor = Azul,
                        backgroundColor = SoftBlue
                    )
                ),
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Today,
                        contentDescription = stringResource(R.string.hari),
                        tint = Color.Black
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.hari),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.LightGray
                    )
                },
                singleLine = true
            )
        }

        Spacer(modifier = modifier.height(16.dp))

        OutlinedCard(
            modifier = modifier
                .width(300.dp)
                .clickable {
                    showBeginTimePicker = true
                },
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
                Icon(
                    imageVector = Icons.Outlined.AccessTime,
                    contentDescription = stringResource(R.string.jam_awal)
                )

                Spacer(modifier = modifier.width(16.dp))

                Column {
                    Text(
                        text = stringResource(R.string.jam_awal),
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = jamAwal,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }

        Spacer(modifier = modifier.height(16.dp))

        OutlinedCard(
            modifier = modifier
                .width(300.dp)
                .clickable {
                    showEndTimePicker = true
                },
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
                Icon(
                    imageVector = Icons.Outlined.AccessTime,
                    contentDescription = stringResource(R.string.jam_akhir)
                )

                Spacer(modifier = modifier.width(16.dp))

                Column {
                    Text(
                        text = stringResource(R.string.jam_akhir),
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = jamAkhir,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }

        Spacer(modifier = modifier.height(16.dp))

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Azul),
            modifier = modifier
                .width(150.dp)
                .height(48.dp),
            shape = RoundedCornerShape(16.dp),
            enabled = enabled
        ) {
            if (loading) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.primary
                )
            } else {
                Text(
                    text = stringResource(R.string.submit),
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }

    if (showBeginTimePicker) {
        TimePickerDialog(
            onCancel = { showBeginTimePicker = false },
            onConfirm = { showBeginTimePicker = false },
            content = { displayMode ->
                val calendar = Calendar.getInstance()
                calendar.set(Calendar.HOUR_OF_DAY, timeState.hour)
                calendar.set(Calendar.MINUTE, timeState.minute)
                jamAwal = timeFormat.format(calendar.time)
                if (displayMode == DisplayMode.Input) {
                    TimePicker(state = timeState)
                } else {
                    TimeInput(state = timeState)
                }
            }
        )
    }

    if (showEndTimePicker) {
        TimePickerDialog(
            onCancel = { showEndTimePicker = false },
            onConfirm = { showEndTimePicker = false },
            content = { displayMode ->
                val calendar = Calendar.getInstance()
                calendar.set(Calendar.HOUR_OF_DAY, timeState.hour)
                calendar.set(Calendar.MINUTE, timeState.minute)
                jamAkhir = timeFormat.format(calendar.time)
                if (displayMode == DisplayMode.Input) {
                    TimePicker(state = timeState)
                } else {
                    TimeInput(state = timeState)
                }
            }
        )
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
fun PreviewCreateJadwalDokterScreen() {
    SisrawatTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CreateJadwalDokter()
        }
    }
}