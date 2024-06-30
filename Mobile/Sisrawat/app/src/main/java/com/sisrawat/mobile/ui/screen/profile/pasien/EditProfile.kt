package com.sisrawat.mobile.ui.screen.profile.pasien

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
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
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.sisrawat.mobile.BuildConfig
import com.sisrawat.mobile.R
import com.sisrawat.mobile.data.local.model.SessionModel
import com.sisrawat.mobile.ui.screen.utils.rememberExposedMenuStateHolder
import com.sisrawat.mobile.ui.screen.utils.uriToFile
import com.sisrawat.mobile.ui.screen.utils.viewmodelfactory.UserViewModelFactory
import com.sisrawat.mobile.ui.theme.AliceBlue
import com.sisrawat.mobile.ui.theme.Azul
import com.sisrawat.mobile.ui.theme.SisrawatTheme
import com.sisrawat.mobile.ui.theme.SoftBlue
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfilePasien(
    modifier: Modifier = Modifier,
    sessionModel: SessionModel,
    viewModel: ProfileViewModel = viewModel(
        factory = UserViewModelFactory.getInstance(
            LocalContext.current
        )
    ),
    snackbarHostState: SnackbarHostState
) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    var id by remember { mutableStateOf(0) }
    var imageUrl by remember { mutableStateOf("") }

    var namaPasien by remember { mutableStateOf("") }
    var noBpjs by remember { mutableStateOf("") }
    var nik by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var tempatLahir by remember { mutableStateOf("") }
    var tanggalLahir by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var idPasien by remember { mutableStateOf(0) }

    var loading by remember { mutableStateOf(false) }
    var enabled by remember { mutableStateOf(true) }

    // Date Picker
    val datePickerState =
        rememberDatePickerState(yearRange = 1900..2024)
    val dateFormat = remember { SimpleDateFormat("dd MMMM yyyy", Locale("in", "ID")) }
    var showDatePicker by remember { mutableStateOf(false) }

    // Image Gallery
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var hasImage by remember { mutableStateOf(false) }
    val launcherGallery = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
        }
    )

    // View Model Declaration
    id = sessionModel.idUser
    scope.launch {
        viewModel.showPasien(id).let {
            imageUrl = BuildConfig.BASE_URL.plus(viewModel.imgProfile.value)
            namaPasien = viewModel.namaPasien.value
            noBpjs = viewModel.noBpjs.value
            nik = viewModel.nik.value
            jenisKelamin = viewModel.jenisKelamin.value
            tanggalLahir = viewModel.tanggalLahir.value
            tempatLahir = viewModel.tempatLahir.value
            noHp = viewModel.noHp.value
            alamat = viewModel.alamat.value
            idPasien = viewModel.idPasien.value
        }
    }

    Scaffold(snackbarHost = { SnackbarHost(snackbarHostState) }) { innerPadding ->
        EditProfileScreen(
            modifier = modifier.padding(innerPadding),
            imageUrl = imageUrl,
            namaPasien = namaPasien,
            onNamaPasien = { input ->
                namaPasien = input
            },
            noBpjs = noBpjs,
            onBpjs = { input ->
                noBpjs = input
            },
            nik = nik,
            onNik = { input ->
                nik = input
            },
            jenisKelamin = jenisKelamin,
            onJenisKelamin = { input ->
                jenisKelamin = input
            },
            tanggalLahir = tanggalLahir,
            tempatLahir = tempatLahir,
            onTempatLahir = { input ->
                tempatLahir = input
            },
            noHp = noHp,
            onNoHp = { input ->
                noHp = input
            },
            alamat = alamat,
            onAlamat = { input ->
                alamat = input
            },
            onUpdate = {
                scope.launch {
                    viewModel.updatePasien(
                        idPasien,
                        namaPasien,
                        noBpjs,
                        nik,
                        jenisKelamin,
                        tanggalLahir,
                        tempatLahir,
                        noHp,
                        alamat
                    ).let {
                        loading = viewModel.loading.value
                        enabled = false

                        delay(2000)

                        snackbarHostState.showSnackbar(
                            message = viewModel.message.value,
                            duration = SnackbarDuration.Short
                        )

                        loading = false
                        enabled = true
                    }

                    if (hasImage) {
                        imageUri?.let { uri ->
                            val imageFile = uriToFile(uri, context)
                            viewModel.uploadImage(id, imageFile).let {
                                loading = viewModel.loading.value
                                enabled = false

                                delay(2000)

                                snackbarHostState.showSnackbar(
                                    message = viewModel.message.value,
                                    duration = SnackbarDuration.Short
                                )

                                loading = false
                                enabled = true
                            }
                        }
                        hasImage = false
                    }
                }
            },
            loading = loading,
            enabled = enabled,
            onShowDatePicker = { showDatePicker = true },
            launcherGallery = launcherGallery,
            hasImage = hasImage,
            imageUri = imageUri
        )

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
}

@Composable
fun EditProfileScreen(
    modifier: Modifier,
    imageUrl: String,
    namaPasien: String,
    onNamaPasien: (String) -> Unit,
    noBpjs: String,
    onBpjs: (String) -> Unit,
    nik: String,
    onNik: (String) -> Unit,
    jenisKelamin: String,
    onJenisKelamin: (String) -> Unit,
    tanggalLahir: String,
    tempatLahir: String,
    onTempatLahir: (String) -> Unit,
    noHp: String,
    onNoHp: (String) -> Unit,
    alamat: String,
    onAlamat: (String) -> Unit,
    onUpdate: () -> Unit,
    loading: Boolean,
    enabled: Boolean,
    onShowDatePicker: () -> Unit,
    launcherGallery: ManagedActivityResultLauncher<String, Uri?>,
    hasImage: Boolean,
    imageUri: Uri?
) {
    val scrollState = rememberScrollState()

    // Dropdown
    val genders = listOf("Laki-Laki", "Perempuan")
    val dropdownState = rememberExposedMenuStateHolder(items = genders)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
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
                onValueChange = onNamaPasien,
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
                value = noBpjs,
                onValueChange = onBpjs,
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
                        contentDescription = stringResource(R.string.no_bpjs),
                        tint = Color.Blue,
                        modifier = modifier.size(24.dp)
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.no_bpjs),
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
                onValueChange = onNik,
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
                    value = jenisKelamin,
                    onValueChange = onJenisKelamin,
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
//                                jenisKelamin = s
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
                onValueChange = onTempatLahir,
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
                        onClick = onShowDatePicker
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
                onValueChange = onNoHp,
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
                onValueChange = onAlamat,
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
            onClick = onUpdate,
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
                    text = stringResource(R.string.update),
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO,
    device = Devices.PIXEL_4_XL
)
@Composable
fun PreviewEditProfileScreen() {
    SisrawatTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            EditProfilePasien(
                sessionModel = SessionModel(0, "", ""),
                snackbarHostState = remember { SnackbarHostState() }
            )
        }
    }
}