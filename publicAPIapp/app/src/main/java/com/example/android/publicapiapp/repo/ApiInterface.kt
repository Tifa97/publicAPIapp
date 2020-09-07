package com.example.android.publicapiapp.repo

import com.example.android.publicapiapp.model.BreakingBadCharacter
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("/api/characters")
    fun getCharacters() : Call<List<BreakingBadCharacter>>

    companion object{
        var BASE_URL = "https://www.breakingbadapi.com/api/"

        fun create() : ApiInterface{

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ApiInterface::class.java)
        }
    }
}