package com.sisrawat.mobile.ui.component.navdrawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.automirrored.outlined.Logout
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Payments
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.sisrawat.mobile.R
import com.sisrawat.mobile.ui.component.DialogScreen
import com.sisrawat.mobile.ui.navigation.Screen
import com.sisrawat.mobile.ui.screen.utils.SisrawatViewModel
import com.sisrawat.mobile.ui.screen.utils.viewmodelfactory.SisrawatViewModelFactory
import com.sisrawat.mobile.ui.theme.Azul
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer(
    modifier: Modifier = Modifier,
    viewModel: SisrawatViewModel = viewModel(
        factory = SisrawatViewModelFactory.getInstance(
            LocalContext.current
        )
    ),
    role: String,
    drawerState: DrawerState,
    navController: NavHostController,
    content: @Composable () -> Unit
) {
    val openDialog = remember { mutableStateOf(false) }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val screenWithoutTopAppBar = arrayOf(
        Screen.Login.route,
        Screen.Register.route
    )

    var navigationDrawerItems = listOf<NavigationDrawerItem?>()

    if (currentRoute !in screenWithoutTopAppBar) {
        navigationDrawerItems = listOf(
            when (role) {
                "Pasien" -> {
                    NavigationDrawerItem(
                        title = stringResource(R.string.transaksi),
                        selectedIcon = Icons.Filled.Payments,
                        unselectedIcon = Icons.Outlined.Payments,
                    )
                }

                "Dokter" -> {
                    NavigationDrawerItem(
                        title = stringResource(R.string.jadwal_dokter),
                        selectedIcon = Icons.Filled.Schedule,
                        unselectedIcon = Icons.Outlined.Schedule,
                    )
                }

                else -> {
                    null
                }
            },
            NavigationDrawerItem(
                title = stringResource(R.string.settings),
                selectedIcon = Icons.Filled.Settings,
                unselectedIcon = Icons.Outlined.Settings,
            ),
            NavigationDrawerItem(
                title = stringResource(R.string.about),
                selectedIcon = Icons.Filled.Info,
                unselectedIcon = Icons.Outlined.Info,
            ),
            NavigationDrawerItem(
                title = stringResource(R.string.logout),
                selectedIcon = Icons.AutoMirrored.Filled.Logout,
                unselectedIcon = Icons.AutoMirrored.Outlined.Logout,
            )
        )
    }


    var selectedItemIndex by rememberSaveable {
        mutableStateOf(-1)
    }
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = MaterialTheme.colorScheme.background
            ) {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Azul
                    ),
                    shape = RectangleShape,
                    modifier = modifier
                        .fillMaxWidth()
                        .height(125.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.logo_sisrawat),
                            contentDescription = stringResource(R.string.logo_sisrawat)
                        )

                        Text(
                            text = stringResource(R.string.app_name),
                            style = MaterialTheme.typography.headlineMedium,
                            color = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                navigationDrawerItems.forEachIndexed { index, item ->
                    if (item != null) {
                        NavigationDrawerItem(
                            label = {
                                Text(
                                    text = item.title,
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = if (item.title.contentEquals("Logout")) {
                                        Color.Red
                                    } else MaterialTheme.colorScheme.onBackground
                                )
                            },
                            selected = index == selectedItemIndex,
                            onClick = {
                                if (item.title.contentEquals("Logout")) {
                                    openDialog.value = true
                                } else {
                                    selectedItemIndex = index
                                }

                                scope.launch {
                                    drawerState.close()
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = if (index == selectedItemIndex) {
                                        item.selectedIcon
                                    } else item.unselectedIcon,
                                    contentDescription = item.title,
                                    tint = if (item.title.contentEquals("Logout")) {
                                        Color.Red
                                    } else MaterialTheme.colorScheme.onBackground
                                )
                            },
                            modifier = modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                            colors = NavigationDrawerItemDefaults.colors(
                                selectedContainerColor = Azul,
                                unselectedContainerColor = MaterialTheme.colorScheme.background,
                            )
                        )
                    }
                }
            }
        },
        drawerState = drawerState,
    ) {
        content()

        when {
            openDialog.value -> {
                DialogScreen(
                    onDismissRequest = { openDialog.value = false },
                    onConfirmation = {
                        viewModel.logout()
                        openDialog.value = false
                    },
                    message = R.string.logout_message,
                    icon = Icons.Outlined.Info
                )
            }
        }
    }
}