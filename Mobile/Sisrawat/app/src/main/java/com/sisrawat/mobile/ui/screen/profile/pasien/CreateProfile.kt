package com.sisrawat.mobile.ui.screen.profile.pasien

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowRight
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.sisrawat.mobile.R
import com.sisrawat.mobile.ui.screen.utils.rememberExposedMenuStateHolder
import com.sisrawat.mobile.ui.theme.AliceBlue
import com.sisrawat.mobile.ui.theme.Azul
import com.sisrawat.mobile.ui.theme.SisrawatTheme
import com.sisrawat.mobile.ui.theme.SoftBlue
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateProfilePasien(
    modifier: Modifier = Modifier
) {
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var hasImage by remember { mutableStateOf(false) }

    val launcherGallery = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
        }
    )

    var namaPasien by remember { mutableStateOf("") }
    var nik by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var tempatLahir by remember { mutableStateOf("") }
    var tanggalLahir by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    var loading by remember { mutableStateOf(false) }
    var enabled by remember { mutableStateOf(true) }

    // Dropdown
    val genders = listOf("Laki-Laki", "Perempuan")
    val dropdownState = rememberExposedMenuStateHolder(items = genders)
    jenisKelamin = dropdownState.value

    // Date Picker
    val datePickerState =
        rememberDatePickerState(yearRange = 1900..2024)
    val dateFormat = remember { SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()) }
    var showDatePicker by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = modifier.height(32.dp))

        Box(
            modifier = modifier
                .align(CenterHorizontally)
                .clip(CircleShape)
                .clickable {
                    launcherGallery.launch("image/*")
                },
            contentAlignment = Center
        ) {
            if (hasImage) {
                SubcomposeAsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imageUri)
                        .crossfade(true)
                        .build(),
                    loading = {
                        CircularProgressIndicator(
                            modifier = modifier.padding(16.dp)
                        )
                    },
                    contentDescription = stringResource(R.string.img_profile),
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.onBackground,
                            shape = CircleShape
                        )
                )

                Text(
                    text = stringResource(R.string.click_to_change),
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium,
                )
            } else {
                Image(
                    painter = painterResource(R.drawable.img_profile),
                    contentDescription = stringResource(R.string.img_profile),
                    contentScale = ContentScale.Crop,
                    alpha = 0.5f,
                    modifier = modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.onBackground,
                            shape = CircleShape
                        ),
                )

                Text(
                    text = stringResource(R.string.click_to_change),
                    color = Color.Black,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }

        Spacer(modifier = modifier.height(32.dp))

        Card(
            modifier = modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)
        ) {
            TextField(
                value = namaPasien,
                onValueChange = { input ->
                    namaPasien = input
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
                        Icons.Filled.Person,
                        contentDescription = stringResource(R.string.nama),
                        tint = Color.Blue,
                        modifier = modifier.size(24.dp)
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.nama),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.LightGray
                    )
                },
                singleLine = true
            )
        }

        Spacer(modifier = modifier.height(8.dp))

        Card(
            modifier = modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)
        ) {
            TextField(
                value = nik,
                onValueChange = { input ->
                    nik = input
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
                        painter = painterResource(R.drawable.identity),
                        contentDescription = stringResource(R.string.nik),
                        tint = Color.Blue,
                        modifier = modifier.size(24.dp)
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.nik),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.LightGray
                    )
                },
                singleLine = true
            )
        }

        Spacer(modifier = modifier.height(8.dp))

        Card(
            modifier = modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)
        ) {
            Box {
                TextField(
                    value = dropdownState.value,
                    onValueChange = { },
                    readOnly = true,
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.gender),
                            contentDescription = stringResource(R.string.jenis_kelamin),
                            tint = Color.Blue,
                            modifier = modifier.size(24.dp)
                        )
                    },
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                dropdownState.onEnabled(!(dropdownState.enabled))
                            }
                        ) {
                            Icon(
                                imageVector = dropdownState.icon,
                                contentDescription = stringResource(R.string.dropdown_menu)
                            )
                        }
                    },
                    modifier = modifier
                        .fillMaxWidth()
                        .onGloballyPositioned {
                            dropdownState.onSize(it.size.toSize())
                        },
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    textStyle = MaterialTheme.typography.bodyMedium,
                    placeholder = {
                        Text(
                            text = stringResource(R.string.jenis_kelamin),
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.LightGray
                        )
                    },
                )

                DropdownMenu(
                    expanded = dropdownState.enabled,
                    onDismissRequest = {
                        dropdownState.onEnabled(false)
                    },
                    modifier = modifier
                        .width(
                            with(LocalDensity.current) {
                                dropdownState.size.width.toDp()
                            }
                        )
                        .background(Azul)
                ) {
                    genders.forEachIndexed { index, s ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = s,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color.White
                                )
                            }, onClick = {
                                dropdownState.onSelectedIndex(index)
                                dropdownState.onEnabled(false)
                            }
                        )
                    }
                }
            }
        }

        Spacer(modifier = modifier.height(8.dp))

        Card(
            modifier = modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)
        ) {
            TextField(
                value = tempatLahir,
                onValueChange = { input ->
                    tempatLahir = input
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
                        imageVector = Icons.Filled.DateRange,
                        contentDescription = stringResource(R.string.tanggal_lahir),
                        tint = Color.Blue,
                        modifier = modifier.size(24.dp)
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.tempat_lahir),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.LightGray
                    )
                },
                singleLine = true
            )
        }

        Spacer(modifier = modifier.height(8.dp))

        Card(
            modifier = modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)
        ) {
            TextField(
                value = tanggalLahir,
                onValueChange = { },
                readOnly = true,
                modifier = modifier
                    .fillMaxWidth(),
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
                        imageVector = Icons.Filled.DateRange,
                        contentDescription = stringResource(R.string.tanggal_lahir),
                        tint = Color.Blue,
                        modifier = modifier.size(24.dp)
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.tanggal_lahir),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.LightGray
                    )
                },
                singleLine = true,
                trailingIcon = {
                    IconButton(
                        onClick = {
                            showDatePicker = true
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowRight,
                            contentDescription = stringResource(R.string.dropdown_menu)
                        )
                    }
                },
            )
        }

        Spacer(modifier = modifier.height(8.dp))

        Card(
            modifier = modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)
        ) {
            TextField(
                value = noHp,
                onValueChange = { input ->
                    noHp = input
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
                        imageVector = Icons.Filled.PhoneAndroid,
                        contentDescription = stringResource(R.string.no_hp),
                        tint = Color.Blue,
                        modifier = modifier.size(24.dp)
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.no_hp),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.LightGray
                    )
                },
                singleLine = true
            )
        }

        Spacer(modifier = modifier.height(8.dp))

        Card(
            modifier = modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)
        ) {
            TextField(
                value = alamat,
                onValueChange = { input ->
                    alamat = input
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
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = stringResource(R.string.alamat),
                        tint = Color.Blue,
                        modifier = modifier.size(24.dp)
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.alamat),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.LightGray
                    )
                },
                singleLine = true
            )
        }

        Spacer(modifier = modifier.height(32.dp))

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Azul),
            modifier = modifier
                .fillMaxWidth()
                .size(60.dp),
            shape = RoundedCornerShape(16.dp),
            enabled = enabled
        ) {
            if (loading) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.primary
                )
            } else {
                Text(
                    text = stringResource(R.string.save),
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
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
                tanggalLahir = dateFormat.format(datePickerState.selectedDateMillis)
            }
            DatePicker(state = datePickerState)
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO,
    device = Devices.PIXEL_4_XL
)
@Preview(
    showSystemUi = true,
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    device = Devices.PIXEL_4_XL
)
@Composable
fun PreviewCreateProfileScreen() {
    SisrawatTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CreateProfilePasien()
        }
    }
}