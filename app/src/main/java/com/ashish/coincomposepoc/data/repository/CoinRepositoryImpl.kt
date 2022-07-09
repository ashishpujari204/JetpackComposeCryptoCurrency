package com.ashish.coincomposepoc.data.repository

import com.ashish.coincomposepoc.data.remote.CoinApi
import com.ashish.coincomposepoc.data.remote.dto.CoinDetailDto
import com.ashish.coincomposepoc.data.remote.dto.CoinDto
import com.ashish.coincomposepoc.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}