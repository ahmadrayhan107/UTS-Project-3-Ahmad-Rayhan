package com.sisrawat.mobile.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val title: String,
    val activeIcon: ImageVector,
    val inactiveIcon: ImageVector,
    val route: String
)
