package com.sisrawat.mobile.ui.component.bottombar

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sisrawat.mobile.R
import com.sisrawat.mobile.ui.navigation.BottomNavigationItem
import com.sisrawat.mobile.ui.theme.Azul

@ExperimentalAnimationApi
@Composable
fun BottomNavItem(
    modifier: Modifier = Modifier,
    bottomNavigationItem: BottomNavigationItem,
    isSelected: Boolean,
) {
    val animatedHeight by animateDpAsState(
        targetValue = if (isSelected) 36.dp else 26.dp,
        label = stringResource(R.string.menu)
    )
    val animatedElevation by animateDpAsState(
        targetValue = if (isSelected) 15.dp else 0.dp,
        label = stringResource(R.string.menu)
    )
    val animatedAlpha by animateFloatAsState(
        targetValue = if (isSelected) 1f else .5f,
        label = stringResource(R.string.menu)
    )
    val animatedIconSize by animateDpAsState(
        targetValue = if (isSelected) 26.dp else 20.dp,
        animationSpec = spring(
            stiffness = Spring.StiffnessLow,
            dampingRatio = Spring.DampingRatioMediumBouncy
        ),
        label = stringResource(R.string.menu)
    )

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            modifier = modifier
                .height(animatedHeight)
                .shadow(
                    elevation = animatedElevation,
                    shape = RoundedCornerShape(20.dp)
                )
                .background(
                    color = Azul,
                    shape = RoundedCornerShape(20.dp)
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                rememberVectorPainter(
                    image = if (isSelected) bottomNavigationItem.activeIcon else bottomNavigationItem.inactiveIcon
                ),
                contentDescription = bottomNavigationItem.title,
                modifier = modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxHeight()
                    .padding(start = 11.dp)
                    .alpha(animatedAlpha)
                    .size(animatedIconSize),
                tint = Color.White
            )
            if (isSelected) {
                Text(
                    text = bottomNavigationItem.title,
                    modifier = modifier.padding(start = 8.dp, end = 10.dp),
                    maxLines = 1,
                    color = Color.White
                )
            }
        }
    }
}