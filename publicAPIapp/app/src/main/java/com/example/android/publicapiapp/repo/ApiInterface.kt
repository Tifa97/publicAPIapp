package com.example.android.publicapiapp.repo

import com.example.android.publicapiapp.model.BreakingBadCharacters
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("/api/characters")
    fun getCharacters() : List<BreakingBadCharacters>

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