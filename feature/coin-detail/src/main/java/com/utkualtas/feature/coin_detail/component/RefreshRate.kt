package com.utkualtas.feature.coin_detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.utkualtas.core.ui.theme.CoinTickerTheme

fun LazyListScope.refreshRate(
    modifier: Modifier = Modifier,
    refreshRateInSecond: Int,
    onIncreaseRefreshRate: () -> Unit,
    onDecreaseRefreshRate: () -> Unit,
) {
    item {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Text(
                text = "Refresh Rate (Second)",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(shape = RoundedCornerShape(percent = 50))
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(percent = 50)
                        )
                        .clickable { onDecreaseRefreshRate() },
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = "-",
                        style = TextStyle(fontSize = 16.sp),
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }

                Text(
                    modifier = Modifier
                        .width(60.dp)
                        .background(
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            shape = MaterialTheme.shapes.small,
                        )
                        .padding(
                            horizontal = 12.dp,
                            vertical = 6.dp
                        ),
                    text = refreshRateInSecond.toString(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                )

                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(shape = RoundedCornerShape(percent = 50))
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(percent = 50)
                        )
                        .clickable { onIncreaseRefreshRate() },
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = "+",
                        style = TextStyle(fontSize = 16.sp),
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }

}


@Preview
@Composable
private fun RefreshRatePreview() {
    CoinTickerTheme {
        LazyColumn {
            refreshRate(
                refreshRateInSecond = 5,
                onIncreaseRefreshRate = {},
                onDecreaseRefreshRate = {},
            )
        }
    }
}