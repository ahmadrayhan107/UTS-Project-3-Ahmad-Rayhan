package com.sisrawat.mobile.ui.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.sisrawat.mobile.R
import com.sisrawat.mobile.ui.theme.Azul
import com.sisrawat.mobile.ui.theme.SisrawatTheme
import com.sisrawat.mobile.ui.theme.SoftBlue

@Composable
fun DialogScreen(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    message: Int,
    icon: ImageVector,
    modifier: Modifier = Modifier,
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = modifier
                .height(200.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = SoftBlue
            )
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = modifier.size(48.dp),
                    tint = Color.White
                )
                Text(
                    text = stringResource(message),
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    TextButton(
                        onClick = { onDismissRequest() },
                    ) {
                        Text(
                            text = stringResource(R.string.dismiss),
                            color = Color.White,
                        )
                    }
                    TextButton(
                        onClick = { onConfirmation() },
                    ) {
                        Text(
                            text = stringResource(R.string.confirm),
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewDialogScreen() {
    SisrawatTheme {
        DialogScreen(
            onDismissRequest = { },
            onConfirmation = { },
            message = R.string.logout_message,
            icon = Icons.Default.Info
        )
    }
}