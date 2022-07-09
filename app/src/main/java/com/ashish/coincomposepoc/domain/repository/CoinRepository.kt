package com.ashish.coincomposepoc.domain.repository

import com.ashish.coincomposepoc.data.remote.dto.CoinDetailDto
import com.ashish.coincomposepoc.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinById(coinId: String) : CoinDetailDto
}