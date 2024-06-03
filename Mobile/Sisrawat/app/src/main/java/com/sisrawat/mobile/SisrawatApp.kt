package com.sisrawat.mobile

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MedicalInformation
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonalInjury
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MedicalInformation
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.PersonalInjury
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sisrawat.mobile.data.local.preferences.SessionPreferences
import com.sisrawat.mobile.ui.component.bottombar.BottomBar
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

    if (session != null) {
        // Initial UI
        val startDestination =
            if (session.token.isNotEmpty()) {
                Screen.Home.route
            } else {
                Screen.Login.route
            }

        val role = session.role

        Scaffold(
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
                                    title = stringResource(R.string.rekam_medis),
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
                        "Pasien" -> HomePasien()
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