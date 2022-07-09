package com.ashish.coincomposepoc.presentation.coin_detail

import com.ashish.coincomposepoc.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
