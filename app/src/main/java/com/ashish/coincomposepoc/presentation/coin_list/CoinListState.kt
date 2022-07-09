package com.ashish.coincomposepoc.presentation.coin_list

import com.ashish.coincomposepoc.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
