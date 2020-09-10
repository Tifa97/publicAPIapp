package com.example.android.publicapiapp.api

import com.example.android.publicapiapp.model.apiResponse.BreakingBadResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    // Radi preko responsea, onda u mapperu oblikuj u data class
    @GET("/api/characters")
    suspend fun getCharacters(): Response<BreakingBadResponse>
}
