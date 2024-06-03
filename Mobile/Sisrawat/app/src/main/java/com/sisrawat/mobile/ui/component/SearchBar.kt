package com.sisrawat.mobile.ui.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sisrawat.mobile.R
import com.sisrawat.mobile.ui.theme.AliceBlue
import com.sisrawat.mobile.ui.theme.Azul
import com.sisrawat.mobile.ui.theme.SisrawatTheme
import com.sisrawat.mobile.ui.theme.SoftBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    search: String,
    onSearch: (String) -> Unit
) {
    OutlinedTextField(
        value = search,
        onValueChange = onSearch,
        shape = RoundedCornerShape(50.dp),
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
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = stringResource(R.string.search)
            )
        },
        placeholder = {
            Text(
                text = stringResource(R.string.search),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.LightGray
            )
        },
        textStyle = MaterialTheme.typography.bodyMedium,
        modifier = modifier.height(48.dp)
    )
}

@Preview
@Composable
fun PreviewSearchBar() {
    var search by remember { mutableStateOf("") }
    SisrawatTheme {
        SearchBar(
            search = search,
            onSearch = { input ->
                search = input
            }
        )
    }
}