package com.ashish.coincomposepoc.domain.use_case.get_coin

import com.ashish.coincomposepoc.common.Resource
import com.ashish.coincomposepoc.data.remote.dto.toCoin
import com.ashish.coincomposepoc.data.remote.dto.toCoinDetail
import com.ashish.coincomposepoc.domain.model.Coin
import com.ashish.coincomposepoc.domain.model.CoinDetail
import com.ashish.coincomposepoc.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId : String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (httpException: HttpException) {
            emit(Resource.Error(httpException.localizedMessage ?: "An unexpected error occurred"))
        } catch (ioException: IOException) {
            emit(Resource.Error(ioException.localizedMessage ?: "An unexpected error occurred"))
        } catch (exception: Exception) {
            emit(Resource.Error(exception.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}