package com.example.bitcoinresponce

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.create


class Repository(val apiClient: ApiClient) {
        suspend fun getCurrencyByName(name:String): Response<BitcoinResponse> {
            val apiInterface = apiClient.client?.create(ApiInterface::class.java)
            return apiInterface!!.getCryptoByName(name)
        }
    }
