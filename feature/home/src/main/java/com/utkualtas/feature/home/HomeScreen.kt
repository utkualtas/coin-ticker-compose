package com.utkualtas.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.utkualtas.core.ui.DevicePreviews
import com.utkualtas.feature.home.component.SearchBar
import com.utkualtas.core.ui.common.SingleCoinListItem

@Composable
fun HomeScreen(
    state: HomeUIState,
    onSearchQueryChange: (query: String) -> Unit,
    onNavigateToCoinDetail: (coinId: String) -> Unit,
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SearchBar(
            searchText = state.searchQuery,
            placeholderText = "Search...",
            onSearchQueryChange = onSearchQueryChange,
            onClearClick = { onSearchQueryChange("") }
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(top = 12.dp, start = 16.dp, end = 16.dp, bottom = 20.dp)
        ) {
            items(items = state.filteredCoins) { coin ->
                SingleCoinListItem(coin = coin, onCoinClick = onNavigateToCoinDetail)
            }
        }

    }
}


@DevicePreviews
@Composable
fun HomeScreenPreview() {
    val state = HomeUIState()
    HomeScreen(state = state, onSearchQueryChange = {}, onNavigateToCoinDetail = {})
}