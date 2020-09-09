package com.example.android.publicapiapp.api

import com.example.android.publicapiapp.model.apiResponse.BreakingBadCharacters
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    //Radi preko responsea, onda u mapperu oblikuj u data class
    @GET("/api/character/random")
    fun getCharacter() : Call<BreakingBadCharacters>
}