package com.sisrawat.mobile.ui.component.sliderbanner

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.sisrawat.mobile.R
import com.sisrawat.mobile.ui.theme.SisrawatTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SliderBanner(
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(initialPage = 0)
    val sliderBannerItem = listOf(
        SliderBannerItem(
            img = painterResource(R.drawable.img_flu),
            title = stringResource(R.string.flu),
            description = stringResource(R.string.flu_description)
        ),
        SliderBannerItem(
            img = painterResource(R.drawable.img_batuk),
            title = stringResource(R.string.batuk),
            description = stringResource(R.string.batuk_description)
        ),
        SliderBannerItem(
            img = painterResource(R.drawable.img_covid),
            title = stringResource(R.string.covid),
            description = stringResource(R.string.covid_description)
        )
    )

    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(2600)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount)
            )
        }
    }

    Column {
        HorizontalPager(
            count = sliderBannerItem.size,
            state = pagerState,
            modifier = modifier
                .height(114.dp)
                .fillMaxWidth()
        ) { page ->
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White
                ),
                modifier = modifier
                    .graphicsLayer {
                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                        lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }

                        alpha = lerp(
                            start = 0.5f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }
            ) {
                Row(
                    modifier = modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = sliderBannerItem[page].img,
                        contentDescription = sliderBannerItem[page].title,
                        contentScale = ContentScale.Crop,
                        modifier = modifier.size(114.dp)
                    )

                    Spacer(modifier = modifier.width(8.dp))

                    Column(
                        modifier = modifier.padding(top = 4.dp)
                    ) {
                        Text(
                            text = sliderBannerItem[page].title,
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Spacer(modifier = modifier.height(4.dp))

                        Text(
                            text = sliderBannerItem[page].description,
                            style = MaterialTheme.typography.bodySmall,
                            softWrap = true
                        )
                    }
                }
            }
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            activeColor = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun PreviewSlideBanner() {
    SisrawatTheme {
        SliderBanner()
    }
}