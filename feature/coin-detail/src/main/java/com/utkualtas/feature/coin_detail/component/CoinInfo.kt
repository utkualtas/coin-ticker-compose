package com.utkualtas.feature.coin_detail.component

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.utkualtas.core.ui.theme.CoinTickerTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CoinInfo(
    modifier: Modifier = Modifier,
    name: String,
    hashingAlgorithm: String,
    onFavouriteClick: () -> Unit,
    isFavourite: Boolean,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = onFavouriteClick
            ) {
                val icon = when (isFavourite) {
                    true -> Icons.Default.Favorite
                    false -> Icons.Default.FavoriteBorder
                }
                AnimatedContent(targetState = icon) {
                    Icon(
                        imageVector = it,
                        contentDescription = null
                    )
                }
            }

            Text(
                modifier = Modifier,
                text = name.uppercase(),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontWeight = FontWeight.Bold,
            )
        }


        AnimatedVisibility(visible = hashingAlgorithm.isNotEmpty()) {
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = "Hashing: $hashingAlgorithm",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
            )
        }
    }
}

@Preview
@Composable
fun CoinInfoPreview() {
    CoinTickerTheme {
        CoinInfo(
            name = "Bitcoin",
            hashingAlgorithm = "SHA256",
            onFavouriteClick = {},
            isFavourite = true
        )
    }
}