package com.example.ricknmorty.data

import retrofit2.Response
import retrofit2.http.GET


interface RickAndMortyAPI {

    @GET("character")
    suspend fun getCharactersList(): Response<CharacterList>

    }