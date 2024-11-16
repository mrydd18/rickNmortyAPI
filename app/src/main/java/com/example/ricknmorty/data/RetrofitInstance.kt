package com.example.ricknmorty.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    fun getApi(): RickAndMortyAPI{
        return getRetrofit().create(RickAndMortyAPI::class.java)

    }
}