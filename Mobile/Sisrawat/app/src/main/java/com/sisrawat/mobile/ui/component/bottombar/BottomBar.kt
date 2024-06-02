package com.sisrawat.mobile.ui.component.bottombar

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sisrawat.mobile.R
import com.sisrawat.mobile.ui.navigation.BottomNavigationItem
import com.sisrawat.mobile.ui.theme.Azul

@ExperimentalAnimationApi
@Composable
fun BottomBar(
    bottomNavigationItems: List<BottomNavigationItem>,
    modifier: Modifier = Modifier
) {
    var selectedScreen by remember { mutableStateOf(0) }
    Box(
        modifier
            .shadow(5.dp)
            .background(color = Azul)
            .height(64.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            for (bottomNavigationItem in bottomNavigationItems) {
                val isSelected = bottomNavigationItem == bottomNavigationItems[selectedScreen]
                val animatedWeight by animateFloatAsState(
                    targetValue = if (isSelected) 1.5f else 1f,
                    label = stringResource(R.string.menu)
                )
                Box(
                    modifier = Modifier.weight(animatedWeight),
                    contentAlignment = Alignment.Center,
                ) {
                    val interactionSource = remember { MutableInteractionSource() }
                    BottomNavItem(
                        modifier = modifier.clickable(
                            interactionSource = interactionSource,
                            indication = null
                        ) {
                            selectedScreen = bottomNavigationItems.indexOf(bottomNavigationItem)
                        },
                        bottomNavigationItem = bottomNavigationItem,
                        isSelected = isSelected
                    )
                }
            }
        }
    }
}