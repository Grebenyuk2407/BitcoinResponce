package com.example.bitcoinresponce

import retrofit2.Response
import retrofit2.Retrofit


class Repository(val client: Retrofit) {
        suspend fun getCurrencyByName(name:String): Response<BitcoinResponse> {
            val apiInterface = client.create(ApiInterface::class.java)
            return apiInterface.getCryptoByName(name)
        }
    }
