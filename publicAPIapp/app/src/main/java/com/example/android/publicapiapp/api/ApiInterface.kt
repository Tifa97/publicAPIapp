package com.example.android.publicapiapp.api

import com.example.android.publicapiapp.model.BreakingBadCharacterItem
import com.example.android.publicapiapp.model.BreakingBadCharacters
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.sql.Array

interface ApiInterface {
    @GET("/api/characters")
    fun getCharacters() : List<BreakingBadCharacterItem>

    companion object{
        var BASE_URL = "https://www.breakingbadapi.com"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()

            return retrofit.create(ApiInterface::class.java)
        }
    }
}