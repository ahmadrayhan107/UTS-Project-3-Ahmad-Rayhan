package com.sisrawat.mobile.ui.screen.register

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sisrawat.mobile.R
import com.sisrawat.mobile.ui.navigation.Screen
import com.sisrawat.mobile.ui.theme.AliceBlue
import com.sisrawat.mobile.ui.theme.Azul
import com.sisrawat.mobile.ui.theme.RoyalBlue
import com.sisrawat.mobile.ui.theme.SisrawatTheme
import com.sisrawat.mobile.ui.theme.SoftBlue

@Composable
fun Register(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }
    var confirmPasswordHidden by rememberSaveable { mutableStateOf(true) }

    RegisterScreen(
        modifier = modifier,
        email = email,
        onEmail = { input ->
            email = input
        },
        password = password,
        onPassword = { input ->
            password = input
        },
        confirmPassword = confirmPassword,
        onConfirmPassword = { input ->
            confirmPassword = input
        },
        passwordHidden = passwordHidden,
        onPasswordHidden = {
            passwordHidden = !passwordHidden
        },
        confirmPasswordHidden = confirmPasswordHidden,
        onConfirmPasswordHidden = {
            confirmPasswordHidden = !confirmPasswordHidden
        },
        navigateToLogin = {
            navController.popBackStack()
            navController.navigate(Screen.Login.route)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    modifier: Modifier,
    email: String,
    onEmail: (String) -> Unit,
    password: String,
    onPassword: (String) -> Unit,
    confirmPassword: String,
    onConfirmPassword: (String) -> Unit,
    passwordHidden: Boolean,
    onPasswordHidden: () -> Unit,
    confirmPasswordHidden: Boolean,
    onConfirmPasswordHidden: () -> Unit,
    navigateToLogin: () -> Unit
) {
    Box {
        Image(
            painter = painterResource(R.drawable.star),
            contentDescription = stringResource(R.string.background),
            modifier = modifier.fillMaxSize()
        )

        Image(
            painter = painterResource(R.drawable.pattern),
            contentDescription = stringResource(R.string.background),
            modifier = modifier.fillMaxSize(),
            alignment = Alignment.TopEnd
        )

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(top = 60.dp, start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.logo_sisrawat),
                contentDescription = stringResource(R.string.logo_sisrawat),
                modifier = modifier
                    .size(80.dp, 80.dp)
                    .padding(bottom = 16.dp)
            )

            Text(
                text = stringResource(R.string.sign_up_headline),
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = modifier.padding(bottom = 12.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = modifier.padding(bottom = 32.dp)
            ) {
                Text(
                    text = stringResource(R.string.sign_up_message),
                    style = MaterialTheme.typography.headlineSmall
                )

                TextButton(
                    onClick = { navigateToLogin() },
                ) {
                    Text(
                        text = stringResource(R.string.login_alt),
                        style = MaterialTheme.typography.headlineSmall,
                        color = RoyalBlue
                    )
                }
            }

            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 48.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)
            ) {
                TextField(
                    value = email,
                    onValueChange = onEmail,
                    modifier = modifier.fillMaxWidth(),
                    textStyle = MaterialTheme.typography.bodyMedium,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = AliceBlue,
                        disabledIndicatorColor = AliceBlue,
                        unfocusedIndicatorColor = AliceBlue,
                        textColor = Color.Black,
                        selectionColors = TextSelectionColors(
                            handleColor = Azul,
                            backgroundColor = SoftBlue
                        ),
                    ),
                    leadingIcon = {
                        Icon(
                            Icons.Outlined.Email,
                            contentDescription = stringResource(R.string.email),
                            tint = Color.Blue
                        )
                    },
                    placeholder = {
                        Text(
                            text = stringResource(R.string.email),
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.LightGray
                        )
                    }
                )

                TextField(
                    value = password,
                    onValueChange = onPassword,
                    modifier = modifier.fillMaxWidth(),
                    textStyle = MaterialTheme.typography.bodyMedium,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        textColor = Color.Black,
                        selectionColors = TextSelectionColors(
                            handleColor = Azul,
                            backgroundColor = SoftBlue
                        ),
                    ),
                    leadingIcon = {
                        Icon(
                            Icons.Outlined.Lock,
                            contentDescription = stringResource(R.string.password),
                            tint = Color.Blue
                        )
                    },
                    placeholder = {
                        Text(
                            text = stringResource(R.string.password),
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.LightGray
                        )
                    },
                    visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                    trailingIcon = {
                        val image =
                            if (passwordHidden) Icons.Filled.VisibilityOff
                            else Icons.Filled.Visibility

                        val description =
                            if (passwordHidden) stringResource(R.string.hide_password)
                            else stringResource(R.string.show_password)

                        IconButton(onClick = onPasswordHidden) {
                            Icon(
                                imageVector = image,
                                description,
                                tint = Color.LightGray
                            )
                        }
                    }
                )

                TextField(
                    value = confirmPassword,
                    onValueChange = onConfirmPassword,
                    modifier = modifier.fillMaxWidth(),
                    textStyle = MaterialTheme.typography.bodyMedium,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        textColor = Color.Black,
                        selectionColors = TextSelectionColors(
                            handleColor = Azul,
                            backgroundColor = SoftBlue
                        ),
                    ),
                    leadingIcon = {
                        Icon(
                            Icons.Outlined.Lock,
                            contentDescription = stringResource(R.string.confirm_password),
                            tint = Color.Blue
                        )
                    },
                    placeholder = {
                        Text(
                            text = stringResource(R.string.confirm_password),
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.LightGray
                        )
                    },
                    visualTransformation = if (confirmPasswordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                    trailingIcon = {
                        val image =
                            if (confirmPasswordHidden) Icons.Filled.VisibilityOff
                            else Icons.Filled.Visibility

                        val description =
                            if (confirmPasswordHidden) stringResource(R.string.hide_password)
                            else stringResource(R.string.show_password)

                        IconButton(onClick = onConfirmPasswordHidden) {
                            Icon(
                                imageVector = image,
                                description,
                                tint = Color.LightGray
                            )
                        }
                    }
                )
            }

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Azul),
                modifier = modifier
                    .fillMaxWidth()
                    .size(60.dp),
                shape = RoundedCornerShape(16.dp),
            ) {
                Text(
                    text = stringResource(R.string.register),
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium
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
fun PreviewRegisterScreen() {
    SisrawatTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Register(navController = rememberNavController())
        }
    }
}