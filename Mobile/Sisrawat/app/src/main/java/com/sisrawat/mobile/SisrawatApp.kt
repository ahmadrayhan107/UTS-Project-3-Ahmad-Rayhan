package com.sisrawat.mobile

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MedicalInformation
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonalInjury
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MedicalInformation
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.PersonalInjury
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sisrawat.mobile.data.local.preferences.SessionPreferences
import com.sisrawat.mobile.ui.component.SearchBar
import com.sisrawat.mobile.ui.component.bottombar.BottomBar
import com.sisrawat.mobile.ui.component.navdrawer.NavigationDrawer
import com.sisrawat.mobile.ui.navigation.BottomNavigationItem
import com.sisrawat.mobile.ui.navigation.Screen
import com.sisrawat.mobile.ui.screen.home.dokter.HomeDokter
import com.sisrawat.mobile.ui.screen.home.pasien.HomePasien
import com.sisrawat.mobile.ui.screen.jadwaltemu.JadwalTemu
import com.sisrawat.mobile.ui.screen.login.Login
import com.sisrawat.mobile.ui.screen.pasien.Pasien
import com.sisrawat.mobile.ui.screen.profile.Profile
import com.sisrawat.mobile.ui.screen.register.Register
import com.sisrawat.mobile.ui.screen.rekammedis.RekamMedis
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun SisrawatApp(
    modifier: Modifier = Modifier,
    sessionPreferences: SessionPreferences,
    navController: NavHostController = rememberNavController()
) {
    // Retrieve the session
    val session = sessionPreferences.getSession().collectAsState(initial = null).value

    val snackbarHostState = remember { SnackbarHostState() }
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    var search by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    if (session != null) {
        // Initial UI
        val startDestination =
            if (session.token.isNotEmpty()) {
                Screen.Home.route
            } else {
                Screen.Login.route
            }

        val role = session.role

        NavigationDrawer(
            role = role,
            drawerState = drawerState
        ) {
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        ),
                        title = {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentRoute = navBackStackEntry?.destination?.route

                            if (currentRoute == Screen.Home.route) {
                                SearchBar(
                                    search = search,
                                    onSearch = { input ->
                                        search = input
                                    }
                                )
                            } else {
                                when (currentRoute) {
                                    Screen.JadwalTemu.route -> {
                                        Text(
                                            text = stringResource(R.string.jadwal_temu),
                                            style = MaterialTheme.typography.headlineSmall,
                                            color = Color.White
                                        )
                                    }

                                    Screen.RekamMedis.route -> {
                                        Text(
                                            text = stringResource(R.string.rekam_medis),
                                            style = MaterialTheme.typography.headlineSmall,
                                            color = Color.White
                                        )
                                    }

                                    Screen.Profile.route -> {
                                        Text(
                                            text = stringResource(R.string.my_profile),
                                            style = MaterialTheme.typography.headlineSmall,
                                            color = Color.White
                                        )
                                    }
                                }

                            }

                        },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.Menu,
                                    contentDescription = stringResource(R.string.menu),
                                    tint = Color.White
                                )
                            }
                        },
                        actions = {
                            IconButton(onClick = {

                            }) {
                                Icon(
                                    imageVector = Icons.Filled.Notifications,
                                    contentDescription = stringResource(R.string.notification),
                                    tint = Color.White
                                )
                            }
                        },
                        scrollBehavior = scrollBehavior
                    )
                },
                bottomBar = {
                    // Role condition
                    when (role) {
                        "Pasien" -> {
                            val bottomNavigationItem =
                                listOf(
                                    BottomNavigationItem(
                                        title = stringResource(R.string.home),
                                        activeIcon = Icons.Filled.Home,
                                        inactiveIcon = Icons.Outlined.Home,
                                        route = Screen.Home.route,
                                    ),
                                    BottomNavigationItem(
                                        title = stringResource(R.string.jadwal_temu),
                                        activeIcon = Icons.Filled.DateRange,
                                        inactiveIcon = Icons.Outlined.DateRange,
                                        route = Screen.JadwalTemu.route,
                                    ),
                                    BottomNavigationItem(
                                        title = stringResource(R.string.rekam),
                                        activeIcon = Icons.Filled.MedicalInformation,
                                        inactiveIcon = Icons.Outlined.MedicalInformation,
                                        route = Screen.RekamMedis.route,
                                    ),
                                    BottomNavigationItem(
                                        title = stringResource(R.string.profile),
                                        activeIcon = Icons.Filled.Person,
                                        inactiveIcon = Icons.Outlined.Person,
                                        route = Screen.Profile.route,
                                    )
                                )
                            BottomBar(
                                bottomNavigationItems = bottomNavigationItem,
                                navController = navController
                            )
                        }

                        "Dokter" -> {
                            val bottomNavigationItem =
                                listOf(
                                    BottomNavigationItem(
                                        title = stringResource(R.string.home),
                                        activeIcon = Icons.Filled.Home,
                                        inactiveIcon = Icons.Outlined.Home,
                                        route = Screen.Home.route,
                                    ),
                                    BottomNavigationItem(
                                        title = stringResource(R.string.jadwal_temu),
                                        activeIcon = Icons.Filled.DateRange,
                                        inactiveIcon = Icons.Outlined.DateRange,
                                        route = Screen.JadwalTemu.route,
                                    ),
                                    BottomNavigationItem(
                                        title = stringResource(R.string.pasien),
                                        activeIcon = Icons.Filled.PersonalInjury,
                                        inactiveIcon = Icons.Outlined.PersonalInjury,
                                        route = Screen.Pasien.route,
                                    ),
                                    BottomNavigationItem(
                                        title = stringResource(R.string.profile),
                                        activeIcon = Icons.Filled.Person,
                                        inactiveIcon = Icons.Outlined.Person,
                                        route = Screen.Profile.route,
                                    )
                                )
                            BottomBar(
                                bottomNavigationItems = bottomNavigationItem,
                                navController = navController
                            )
                        }
                    }
                },
                modifier = modifier
            ) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = startDestination,
                    modifier = modifier.padding(innerPadding)
                ) {
                    composable(Screen.Login.route) {
                        Login(
                            navController = navController,
                            snackbarHostState = snackbarHostState
                        )
                    }
                    composable(Screen.Register.route) {
                        Register(
                            navController = navController,
                            snackbarHostState = snackbarHostState
                        )
                    }
                    composable(Screen.Home.route) {
                        when (role) {
                            "Pasien" -> {
                                HomePasien(sessionModel = session)
                            }

                            "Dokter" -> HomeDokter()
                        }
                    }
                    composable(Screen.JadwalTemu.route) {
                        JadwalTemu()
                    }
                    composable(Screen.RekamMedis.route) {
                        RekamMedis()
                    }
                    composable(Screen.Profile.route) {
                        Profile()
                    }
                    composable(Screen.Pasien.route) {
                        Pasien()
                    }
                }
            }
        }
    }
}