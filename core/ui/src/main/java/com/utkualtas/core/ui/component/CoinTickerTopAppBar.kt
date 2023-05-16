package com.utkualtas.core.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.utkualtas.core.ui.theme.CoinTickerTheme

@Composable
fun CoinTickerTopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    color: Color = MaterialTheme.colorScheme.primary,
    shadowElevation: Dp = 2.dp,
    navigationIcon: ImageVector? = null,
    menuIcon: Int? = null,
    onNavigationIconClick: (() -> Unit)? = null,
    onMenuIconClick: (() -> Unit)? = null,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        color = color,
        shadowElevation = shadowElevation,
    ) {
        Box(contentAlignment = Alignment.Center) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (navigationIcon != null) {
                    IconButton(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .size(24.dp),
                        onClick = { onNavigationIconClick?.invoke() }
                    ) {
                        Icon(
                            imageVector = navigationIcon,
                            contentDescription = null
                        )
                    }
                } else {
                    Spacer(modifier = Modifier.size(24.dp))
                }

                if (menuIcon != null) {
                    IconButton(
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(24.dp),
                        onClick = { onMenuIconClick?.invoke() }
                    ) {
                        Image(
                            painter = painterResource(id = menuIcon),
                            contentDescription = null
                        )
                    }
                } else {
                    Spacer(modifier = Modifier.size(24.dp))
                }
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = title,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }
}

@Preview
@Composable
private fun BisuAppBarPreview() {
    CoinTickerTheme {
        CoinTickerTopAppBar(
            title = "GİRİŞ YAP",
            navigationIcon = null,
            menuIcon = null
        )
    }
}