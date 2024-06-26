package com.sisrawat.mobile.ui.screen.home.pasien

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
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
import com.sisrawat.mobile.ui.theme.Azul
import com.sisrawat.mobile.ui.theme.EerieBlack
import com.sisrawat.mobile.ui.theme.SisrawatTheme
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun CreatePendaftaranTemu(
    modifier: Modifier = Modifier
) {
    CreatePendaftaranTemuScreen(modifier = modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatePendaftaranTemuScreen(
    modifier: Modifier = Modifier
) {
    // Time Picker
    var showTimePicker by remember { mutableStateOf(false) }
    val timeState = rememberTimePickerState(is24Hour = true)
    val timeFormat = remember { SimpleDateFormat("HH:mm", Locale.getDefault()) }
    var jam by remember { mutableStateOf("--:--") }

    // Date Picker
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState =
        rememberDatePickerState(yearRange = 2000..2024)
    val dateFormat = remember { SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()) }
    var tanggal by remember { mutableStateOf("--/--/----") }

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
                .width(300.dp)
                .clickable {
                    showTimePicker = true
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
                    contentDescription = stringResource(R.string.jam)
                )

                Spacer(modifier = modifier.width(16.dp))

                Column {
                    Text(
                        text = stringResource(R.string.jam),
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = jam,
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
                    showDatePicker = true
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
                    imageVector = Icons.Outlined.DateRange,
                    contentDescription = stringResource(R.string.tanggal)
                )

                Spacer(modifier = modifier.width(16.dp))

                Column {
                    Text(
                        text = stringResource(R.string.tanggal),
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = tanggal,
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

    if (showTimePicker) {
        TimePickerDialog(
            onCancel = { showTimePicker = false },
            onConfirm = { showTimePicker = false },
            content = { displayMode ->
                val calendar = Calendar.getInstance()
                calendar.set(Calendar.HOUR_OF_DAY, timeState.hour)
                calendar.set(Calendar.MINUTE, timeState.minute)
                jam = timeFormat.format(calendar.time)
                if (displayMode == DisplayMode.Input) {
                    TimePicker(state = timeState)
                } else {
                    TimeInput(state = timeState)
                }
            }
        )
    }

    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(
                    onClick = { showDatePicker = false },
                    enabled = datePickerState.selectedDateMillis != null
                ) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDatePicker = false
                    }
                ) {
                    Text(text = "Dismiss")
                }
            }
        ) {
            if (datePickerState.selectedDateMillis != null) {
                tanggal = dateFormat.format(datePickerState.selectedDateMillis)
            }
            DatePicker(state = datePickerState)
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
fun PreviewCreatePendaftaranTemuScreen() {
    SisrawatTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CreatePendaftaranTemu()
        }
    }
}